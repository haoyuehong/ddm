package vip.ddm.ddm.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vip.ddm.ddm.model.Coupon;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CouponVo extends Coupon {

    private String storeName;
}
