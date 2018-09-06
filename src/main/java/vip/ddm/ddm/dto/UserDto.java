package vip.ddm.ddm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {


    @NotNull
    private String code;

    @NotNull
    private String encryptedData;

    @NotNull
    private String iv;

    private Integer id;

    private Integer storeId;
}
