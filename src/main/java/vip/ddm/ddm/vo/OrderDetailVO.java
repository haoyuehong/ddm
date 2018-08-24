package vip.ddm.ddm.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailVO {

    private String fullDown;

    private String coupon;

    List<OrderGoodsVo> orderGoodsVoList;
}
