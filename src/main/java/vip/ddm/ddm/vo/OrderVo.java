package vip.ddm.ddm.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vip.ddm.ddm.model.Order;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderVo extends Order {

    private String address;

    private String nickname;

}
