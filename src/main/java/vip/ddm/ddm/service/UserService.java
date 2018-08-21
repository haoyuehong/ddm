package vip.ddm.ddm.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.ddm.ddm.dao.UserMapper;
import vip.ddm.ddm.dto.UserDto;
import vip.ddm.ddm.dto.UserTypeDto;
import vip.ddm.ddm.exception.GlobleException;
import vip.ddm.ddm.model.User;
import vip.ddm.ddm.result.CodeMsg;
import vip.ddm.ddm.utils.WxGetUserInfo;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 检测用户是否已经保存
     */
    public CodeMsg checkSave(String code){
        JSONObject jsonObject = WxGetUserInfo.getSessionKey(code);
        String openid = (String)jsonObject.get("openid");
        User user = userMapper.findByOpenId(openid);
        if(user != null){
            return CodeMsg.USER_SAVED.fillArgs(user.getId());
        }else{
            return CodeMsg.USER_NUSAVE;
        }
    }

    public void save(@Valid UserDto userDto){
        JSONObject jsonObject = getJsonObject(userDto);
        User user = new User();
        user.setAge((Integer) jsonObject.get("openId"));
        user.setNickname((String) jsonObject.get("nickName"));
        user.setOpenid((String) jsonObject.get("openId"));
        user.setSex((byte) jsonObject.get("gender"));
        user.setType(0);
        user.setDate(new Date());
        user.setAvatarurl((String)jsonObject.get("avatarUrl"));
        userMapper.insert(user);
    }


    public String savePhoneNum(@Valid UserDto userDto){
        Integer id = userDto.getId();
        if(id == null){
            throw new GlobleException(CodeMsg.USER_ID_NULL);
        }
        User user = userMapper.selectByPrimaryKey(userDto.getId());
        if(user == null){
            throw new GlobleException(CodeMsg.USER_NULL);
        }
        JSONObject jsonObject = getJsonObject(userDto);
        String phoneNumber = (String)jsonObject.get("phoneNumber");


        user.setTell(phoneNumber);
        userMapper.updateByPrimaryKey(user);
        return phoneNumber;
    }

    private JSONObject getJsonObject(UserDto userDto){
        JSONObject sessionKey = WxGetUserInfo.getSessionKey(userDto.getCode());
        String session_key = (String)sessionKey.get("session_key");
        return  WxGetUserInfo.getUserInfo(userDto.getEncryptedData(), session_key, userDto.getIv());
    }



    public void updateType(UserTypeDto userTypeDto){
        Integer id = userTypeDto.getId();
        if(id == null){
            throw new GlobleException(CodeMsg.USER_ID_NULL);
        }
        User user = userMapper.selectByPrimaryKey(id);
        if(user == null){
            throw new GlobleException(CodeMsg.USER_NULL);
        }
        user.setType(userTypeDto.getType());
        userMapper.updateByPrimaryKey(user);
    }
}
