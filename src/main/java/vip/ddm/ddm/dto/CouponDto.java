package vip.ddm.ddm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import vip.ddm.ddm.model.Coupon;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CouponDto implements Serializable {

    private Integer id;

    @NotNull(message = "优惠卷名称不能为空")
    private String name;

    private String descr;

    @NotNull(message = "最低价格不能为空")
    private Double lowestPrice = 0.0;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date date;

    private Byte superposition = 0; //是否可与其他优惠叠加使用 0可以  1不可以

    @NotNull(message = "价格不能为空")
    private Double price; //价值

    private Byte status = 0;

    private Byte type;//0 无门槛指定价格（0）  1 指定品类指定价格  2全品类指定价格   3指定商品指定价格

    private Integer storeId;

    private List<Integer> goodsIds;

    private List<Integer> goodsGroupIds;

    @NotNull
    private Integer num;
}
