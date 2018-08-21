package vip.ddm.ddm.config;

import com.alibaba.fastjson.JSONObject;
import vip.ddm.ddm.utils.WxGetUserInfo;

public class WxTest {

    public static void main(String[] args) {
        JSONObject sessionKey = WxGetUserInfo.getSessionKey("011PcusQ1ckDka10xSoQ1RfDsQ1PcusQ");
        String sessionkey = (String)sessionKey.get("session_key");
        String str = "EkAP+1W91d0iI2zrC01OZR4r/IKgVo7KEsA03i2XkV7SEPQZ8WB9XzAmEjirAT6PQDRuGg3GHkQJ03DwRnipxir4TeAuMJRlkybD40F0PbGazE2MU6dDiHLBOSbIhE+rNYMebNR0b1DRfx1es30v6FZqCBtrAe5PF97b5rg8Y1ztG9T4f1LpJvbUyOw3962MsM8HwMo9M1Zu5hEucBDW5w==";
        JSONObject userInfo = WxGetUserInfo.getUserInfo(str, sessionkey, "rUaMeb3E6ICDBF+fr8Ep9A==");
        System.out.println(userInfo);
    }
}
