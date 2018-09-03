package vip.ddm.ddm.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vip.ddm.ddm.model.Orders;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderQueryDto extends BaseQuery {

    private Orders order;

    private Integer storid;

    private Date date;
}
