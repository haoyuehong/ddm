package vip.ddm.ddm.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import vip.ddm.ddm.utils.SessionUtil;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FullDownDto implements Serializable {

    private Integer id;

    @NotNull
    private String name;

    private String descr;

    @NotNull
    private Double lowestPrice;

    @NotNull
    private Double price;

    @NotNull
    private Byte superposition;

    private Double hightestPrice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date date;


    private Byte status = 0;

    private Integer storeId;

    private List<Integer> storeIds;
}
