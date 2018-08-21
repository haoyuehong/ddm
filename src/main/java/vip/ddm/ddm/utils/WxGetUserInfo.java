package vip.ddm.ddm.utils;

import com.alibaba.fastjson.JSONObject;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.codehaus.xfire.util.Base64;
import vip.ddm.ddm.config.WeChatConfig;
import vip.ddm.ddm.exception.GlobleException;
import vip.ddm.ddm.result.CodeMsg;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Arrays;

public class WxGetUserInfo {

    /**
     * 获取信息
     */
    public static JSONObject getUserInfo(String encryptedData, String sessionkey, String iv){
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionkey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);
        try {
            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return JSONObject.parseObject(result);
            }else {
                throw new GlobleException(CodeMsg.USER_INFO_FAIL);
            }
        } catch (Exception e) {
           throw new GlobleException(CodeMsg.USER_INFO_FAIL);
        }
    }

    /**
     * 根据code获取session_key
     */
    public static JSONObject getSessionKey(String code) {
        try {
            String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + WeChatConfig.APPID + "&secret="
                    + WeChatConfig.AppSecret + "&js_code=" + code + "&grant_type=authorization_code";
            String reusult = HttpTool.GET(url,null,null,"utf-8");

            return JSONObject.parseObject(reusult);
        } catch (Exception e) {
            throw new GlobleException(CodeMsg.USER_OPENID_FAIL);
        }

    }

}
