package vip.ddm.ddm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDtos implements Serializable {
    private List<OrderDto> orderDtoList;

    @NotNull
    private Integer storeid;

    @NotNull
    private Integer userId;

}
