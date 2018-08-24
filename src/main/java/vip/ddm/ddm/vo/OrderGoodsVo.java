package vip.ddm.ddm.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderGoodsVo {

    private String goodsName;

    private double price;

    private double realPrice;

    private Integer num;


}
