package vip.ddm.ddm.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vip.ddm.ddm.model.User;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVo extends User {
    //订单量
    private int orderNum;

    //优惠卷数量
    private int couponNum;
}
