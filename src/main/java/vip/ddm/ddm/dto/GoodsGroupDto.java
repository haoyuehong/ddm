package vip.ddm.ddm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoodsGroupDto implements Serializable {

    private Integer id;

    @NotNull(message = "分组名不能为空")
    private String groupName;

    private Date date;

    private Byte status = 0;

    private Integer storeId;

}
