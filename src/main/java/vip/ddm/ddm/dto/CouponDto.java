package vip.ddm.ddm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import vip.ddm.ddm.model.Coupon;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CouponDto implements Serializable {

    private Integer id;

    @NotEmpty(message = "优惠卷名称不能为空")
    private String name;

    private String descr;

    @NotNull(message = "最低价格不能为空")
    private Double lowestPrice = 0.0;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date date;

    private Byte superposition = 0; //是否可与其他优惠叠加使用 0可以  1不可以

    @NotNull(message = "价格不能为空")
    private Double price; //价值

    private int status = 0;


}
