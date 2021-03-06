package vip.ddm.ddm.service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.ddm.ddm.dao.UserMapper;
import vip.ddm.ddm.dto.BaseQuery;
import vip.ddm.ddm.dto.UserDto;
import vip.ddm.ddm.dto.UserQueryDto;
import vip.ddm.ddm.dto.UserTypeDto;
import vip.ddm.ddm.exception.GlobleException;
import vip.ddm.ddm.model.Coupon;
import vip.ddm.ddm.model.Orders;
import vip.ddm.ddm.model.User;
import vip.ddm.ddm.result.CodeMsg;
import vip.ddm.ddm.utils.WxGetUserInfo;
import vip.ddm.ddm.vo.UserVo;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserCouponService userCouponService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private CouponService couponService;

    private String code;
    private String session_key;

    /**
     * 检测用户是否已经保存
     */
    public CodeMsg checkSave(String code,Integer storeId){
        this.code = code;
        JSONObject jsonObject = WxGetUserInfo.getSessionKey(code);
        String openid = (String)jsonObject.get("openid");
        session_key = (String)jsonObject.get("session_key");
        User user = userMapper.findByOpenId(openid,storeId);
        if(user != null){
            return CodeMsg.USER_SAVED.fillArgs(user.getId());
        }else{
            return CodeMsg.USER_NUSAVE;
        }
    }

    public void save(@Valid UserDto userDto){
        JSONObject jsonObject = getJsonObject(userDto);
        User user = new User();
        user.setNickname((String) jsonObject.get("nickName"));
        user.setOpenid((String) jsonObject.get("openId"));
        user.setSex(Byte.parseByte(jsonObject.get("gender").toString()) );
        user.setType(0);
        user.setDate(new Date());
        user.setAvatarurl((String)jsonObject.get("avatarUrl"));
        user.setStaoreId(userDto.getStoreId());
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
        if(!userDto.getCode().equals(this.code)){
            JSONObject sessionKey = WxGetUserInfo.getSessionKey(userDto.getCode());
            session_key = (String)sessionKey.get("session_key");
        }
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

    public PageInfo<UserVo> list(UserQueryDto userQueryDto){
        List<Integer> storeIds = couponService.getStoreIds(userQueryDto.getUser().getStaoreId());
        List<UserVo> userVoList = new ArrayList<>();
        PageHelper.startPage(userQueryDto.getPage(),userQueryDto.getRows());
        List<User> userList = userMapper.selectUserList(userQueryDto.getKey(),userQueryDto.getUser().getType(),storeIds);
        for(User user : userList){
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user,userVo);
            List<Coupon> coupons = userCouponService.selectByUserId(user.getId());
            userVo.setCouponNum(coupons.size());
            List<Orders> orders = orderService.findByUserId(user.getId());
            userVo.setOrderNum(orders.size());
            userVoList.add(userVo);
        }
        return new PageInfo<>(userVoList);
    }
}
