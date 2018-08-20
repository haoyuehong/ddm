package vip.ddm.ddm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vip.ddm.ddm.model.Goods;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoodsQuesryDto extends BaseQuery {
    private Goods goods;
}
