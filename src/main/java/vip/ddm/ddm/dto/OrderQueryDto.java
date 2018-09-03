package vip.ddm.ddm.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vip.ddm.ddm.model.Order;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderQueryDto extends BaseQuery {

    private Order order;

    private Integer storid;

    private Date date;
}
