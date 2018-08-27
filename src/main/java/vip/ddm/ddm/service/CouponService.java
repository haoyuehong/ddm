package vip.ddm.ddm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.ddm.ddm.dao.CouponMapper;
import vip.ddm.ddm.dto.CouponDto;
import vip.ddm.ddm.dto.CouponQuesryDto;
import vip.ddm.ddm.exception.GlobleException;
import vip.ddm.ddm.model.Coupon;
import vip.ddm.ddm.model.User;
import vip.ddm.ddm.result.CodeMsg;

import javax.validation.Valid;
import java.util.List;

@Service
public class CouponService {


    @Autowired
    private CouponMapper couponMapper;
    @Autowired
    private UserCouponService userCouponService;

    public void save(@Valid CouponDto couponDto){

        Coupon coupon = new Coupon();
        BeanUtils.copyProperties(couponDto,coupon);
        if(coupon.getId() != null){
            couponMapper.updateByPrimaryKey(coupon);
        }else{
            couponMapper.insert(coupon);
        }
    }

    public void delete(Integer id){
        if(id == null){
            throw new GlobleException(CodeMsg.COUPON_ID_NULL);
        }
        Coupon coupon = couponMapper.selectByPrimaryKey(id);
        if(coupon == null){
            throw new GlobleException(CodeMsg.COUPON_NULL);
        }
        List<User> users = userCouponService.selectByCouponId(id);
        if(users.size()>0){
            throw new GlobleException(CodeMsg.COUPON_BEGET);
        }
        coupon.setStatus((byte)1);
        couponMapper.updateByPrimaryKey(coupon);
    }

    public PageInfo<Coupon> list(CouponQuesryDto couponQuesryDto) {
        PageHelper.startPage(couponQuesryDto.getPage(),couponQuesryDto.getRows());
        List<Coupon> coupons = couponMapper.list(couponQuesryDto.getCoupon());
        return new PageInfo<>(coupons);
    }

}
