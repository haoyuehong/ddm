package vip.ddm.ddm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDto {

    private Integer id;

    @NotNull(message = "商品名称不能为空")
    private String goodsName;

    @NotNull(message = "商品分布不能为空")
    private Integer groupId;

    @NotNull(message = "至少上传一张图片")
    private List<String> images;

    @NotNull(message = "价格不能为空")
    private Double price;

    private Integer stock;

    private Double boxPrice = 0.0;

    private Byte status = 0;//0上架  1下架  2删除

    private List<String> taste; //口味

    private String descr;//商品描述

    private Date date; //商品售卖时间

    private Integer storeId;
}
