package vip.ddm.ddm.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vip.ddm.ddm.model.Orders;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderVo extends Orders {

    private String address;

    private String nickname;

    private String storeName;

}
