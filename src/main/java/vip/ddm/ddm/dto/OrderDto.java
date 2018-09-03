package vip.ddm.ddm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDto implements Serializable {

    @NotNull
    private Integer userId;

    @NotNull
    private Integer addressId;

    private Byte status = 0; //状态  0已付款 1已接单 2正在配送 3已完成 4申请退款 5已退款

    @NotNull
    private Double price; //价格

    private Integer couponId; //优惠卷id

    private Integer fullDownId; //满减活动id

    @NotNull
    private String phone; //电话

    @NotNull
    private Date deliveryTime; //送达时间

    @NotNull
    private List<OrderGoodsDto> orderGoodsDtos;

    private Integer orderId;

    @NotNull
    private Integer storeid;
}
