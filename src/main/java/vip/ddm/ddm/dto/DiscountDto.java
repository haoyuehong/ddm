package vip.ddm.ddm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountDto {

    private Integer id;

    @NotNull(message = "商品id不能为空")
    private Integer goodsId;

    @NotNull(message = "折后价格不能为空")
    @Min(value = 0,message = "折后价格最小为0")
    private Double discountPrice;

    @NotNull(message = "是否可叠加不能为空")
    private Byte superposition;

    private Integer num;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date date;

    private Byte status = 0;

}
