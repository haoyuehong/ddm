package vip.ddm.ddm.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vip.ddm.ddm.model.FullDown;
import vip.ddm.ddm.model.GoodsGroup;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FullDownVo extends FullDown {

    private String storeName;
}
