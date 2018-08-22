package vip.ddm.ddm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCouponDto implements Serializable {

    private Integer id;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer couponId;

    private Integer num = 1;

}
