package vip.ddm.ddm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vip.ddm.ddm.dao.UserCouponMapper;
import vip.ddm.ddm.model.UserCoupon;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserCouponMapperTest {

    @Autowired
    UserCouponMapper userCouponMapper;

    @Test
    public void selectByUserIdAndCouponId() {

        UserCoupon userCoupon = userCouponMapper.selectByUserIdAndCouponId(1, 1);
        System.out.println(userCoupon);
    }
}