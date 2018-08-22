package vip.ddm.ddm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vip.ddm.ddm.model.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserQueryDto extends BaseQuery{

    private User user;
}
