package vip.ddm.ddm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vip.ddm.ddm.model.Address;
import vip.ddm.ddm.model.Coupon;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CouponQuesryDto extends BaseQuery {
    private Coupon coupon;
}
