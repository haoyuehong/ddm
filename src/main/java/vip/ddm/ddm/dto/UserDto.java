package vip.ddm.ddm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {


    @NotEmpty
    private String code;

    @NotEmpty
    private String encryptedData;

    @NotEmpty
    private String iv;

    private Integer id;

    private Integer storeId;
}
