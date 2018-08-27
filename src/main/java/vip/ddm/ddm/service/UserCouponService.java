package vip.ddm.ddm.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.ddm.ddm.dao.UserCouponMapper;
import vip.ddm.ddm.dto.UserCouponDto;
import vip.ddm.ddm.exception.GlobleException;
import vip.ddm.ddm.model.Coupon;
import vip.ddm.ddm.model.User;
import vip.ddm.ddm.model.UserCoupon;
import vip.ddm.ddm.result.CodeMsg;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Service
public class UserCouponService {

    @Autowired
    private UserCouponMapper userCouponMapper;

    public void save(@Valid UserCouponDto userCouponDto){
        UserCoupon userCoupon = new UserCoupon();
        BeanUtils.copyProperties(userCouponDto,userCoupon);
        userCoupon.setDate(new Date());
        userCouponMapper.insertSelective(userCoupon);
    }

    public void updateStatus(Integer couponId,Integer userId,Byte status){
        if(couponId == null || userId == null){
            throw new GlobleException(CodeMsg.USER_ID_NULL);
        }
        UserCoupon userCoupon = userCouponMapper.selectByUserIdAndCouponId(couponId,userId);
        if(userCoupon == null){
            throw new GlobleException(CodeMsg.COUPON_NULL);
        }
        userCoupon.setStatus(status);
        userCouponMapper.updateByPrimaryKey(userCoupon);
    }

    public List<Coupon> selectByUserId(Integer userId){
        return userCouponMapper.selectByUserId(userId);
    }

    public List<User> selectByCouponId(Integer couponId){
        return userCouponMapper.selectByCouponId(couponId);
    }
}
