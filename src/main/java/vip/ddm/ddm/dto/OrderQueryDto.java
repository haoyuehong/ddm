package vip.ddm.ddm.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vip.ddm.ddm.model.Order;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderQueryDto extends BaseQuery {

    private Order order;
}
