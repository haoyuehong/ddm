package vip.ddm.ddm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IdQuery implements Serializable {
    private Integer id;

    private Integer couponId;

    private Integer userId;

    private Integer parentId;

    private Integer type;

    private Integer storeId;
}
