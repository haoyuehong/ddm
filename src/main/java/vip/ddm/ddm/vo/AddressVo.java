package vip.ddm.ddm.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vip.ddm.ddm.model.Address;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressVo extends Address {
    private String storename;
}
