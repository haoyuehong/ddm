package vip.ddm.ddm.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vip.ddm.ddm.model.Goods;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppGoodsVo implements Serializable {
    private String goodsName;

    private Integer goodsId;

    private int stock;

    private int hadSell;

    private String descr;

    private List<String> taste;

    private List<String> images;

    private List<String> deliveryTimes;

    private Double price;

    private Boolean discount;

    private Double discountPrice;

    private Integer num;

    private Byte superpostion;
}
