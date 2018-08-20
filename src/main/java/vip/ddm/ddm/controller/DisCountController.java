package vip.ddm.ddm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vip.ddm.ddm.dto.DiscountDto;
import vip.ddm.ddm.dto.DiscountQueryDto;
import vip.ddm.ddm.dto.IdQuery;
import vip.ddm.ddm.model.Discount;
import vip.ddm.ddm.result.Result;
import vip.ddm.ddm.service.DisCountService;
import vip.ddm.ddm.vo.DiscountVo;

@RestController
@RequestMapping("/discount")
public class DisCountController {

    @Autowired
    private DisCountService disCountService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result save(@RequestBody DiscountDto discountDto){
        disCountService.save(discountDto);
        return Result.success(true);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Result delete(@RequestBody IdQuery idQuery){
        disCountService.delete(idQuery.getId());
        return Result.success(true);
    }


    @RequestMapping(value = "/list")
    public Result<PageInfo<DiscountVo>> list(@RequestBody DiscountQueryDto discountQueryDto){
        return Result.success(disCountService.list(discountQueryDto.getDiscount(),discountQueryDto.getPage(),discountQueryDto.getRows()));
    }




}
