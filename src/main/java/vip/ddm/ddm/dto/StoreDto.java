package vip.ddm.ddm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreDto implements Serializable {

    private Integer id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String username;

    private String address;

    @NotEmpty
    private String password;

    private String phone;

    private Byte status = 0;

    @NotNull
    private Byte type;

    private Byte amOrderStatus = 0;

    private Byte pmOrderStatus = 0;

    @NotNull
    private String amDeliveryTime;
    @NotNull
    private String pmDeliveryTime;

    private Integer parentId;


}
