package vip.ddm.ddm.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BaseQuery implements Serializable {

    private int page = 0;

    private int rows = 10;

    private String key;

    private Integer parentId;
}
