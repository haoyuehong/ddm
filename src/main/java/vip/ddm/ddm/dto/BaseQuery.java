package vip.ddm.ddm.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BaseQuery implements Serializable {

    private int page;

    private int rows;

    private String key;
}
