package vip.ddm.ddm.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vip.ddm.ddm.model.Goods;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoodsVo extends Goods {

    /**
     * 分组名称
     */
    private String groupName;

    /**
     *照片
     */
    private List<String> imageStr;

    /**
     * 是否打折
     */
    private String discount = "不打折";//不打折

    /**
     * 折后价格
     */
    private Double discountPrice = null;


    private String strStatus;


    /**
     * 可选择口味
     */
    private List<String> tasteStr; //口味

    private String storeName;

    private Integer storeId;

}
