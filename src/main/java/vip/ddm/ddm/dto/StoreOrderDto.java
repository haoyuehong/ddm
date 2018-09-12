package vip.ddm.ddm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreOrderDto {
    private Integer id;

    private Byte amOrderStatus;

    private Byte pmOrderStatus;

}
