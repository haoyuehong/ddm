package vip.ddm.ddm.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoodsVo {

    /**
     * 商品编号
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 分组id
     */
    private Integer groupId;

    /**
     * 分组名称
     */
    private String groupName;

    /**
     *照片
     */
    private String images;

    /**
     *照片
     */
    private List<String> imageStr;


    /**
     * 价格
     */
    private Double price;

    /**
     * 库存
     */
    private Integer stock;

    /**
     * 餐盒费
     */
    private Double boxPrice = 0.0;

    /**
     * 是否打折
     */
    private Byte discount = 0;//不打折

    /**
     * 折后价格
     */
    private Double discountPrice = null;

    /**
     * 状态
     */
    private Byte status = 0;//0上架  1下架  2删除


    private String strStatus;


    /**
     * 可选择口味
     */
    private List<String> tasteStr; //口味

    private String taste; //口味

    /**
     * 商品描述
     */
    private String descr;//商品描述
}
