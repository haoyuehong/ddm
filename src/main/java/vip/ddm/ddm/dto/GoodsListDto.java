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
public class GoodsListDto {

    private List<GoodsDto> goodsDtos;

    @NotNull(message = "商品分布不能为空")
    private Integer groupId;

    private Date date;


}
