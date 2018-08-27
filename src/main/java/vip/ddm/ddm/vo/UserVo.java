package vip.ddm.ddm.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vip.ddm.ddm.model.User;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserVo extends User {
    //订单量
    private int orderNum;

    //优惠卷数量
    private int couponNum;
}
