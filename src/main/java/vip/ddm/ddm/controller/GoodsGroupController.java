package vip.ddm.ddm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.ddm.ddm.dto.GoodsGroupDto;
import vip.ddm.ddm.dto.IdQuery;
import vip.ddm.ddm.model.GoodsGroup;
import vip.ddm.ddm.result.Result;
import vip.ddm.ddm.service.GoodsGroupService;

@Controller
@RequestMapping("/gp")
public class GoodsGroupController {
    @Autowired
    private GoodsGroupService goodsGroupService;

    @RequestMapping("/save")
    @ResponseBody
    public Result save(@RequestBody GoodsGroupDto goodsGroupDto){

        goodsGroupService.save(goodsGroupDto);
        return Result.success(true);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestBody IdQuery idQuery){
        goodsGroupService.delete(idQuery.getId());
        return Result.success(true);
    }

    @RequestMapping("/list")
    @ResponseBody
    public Result list(GoodsGroup goodsGroup){

        return Result.success(goodsGroupService.findAll(goodsGroup));
    }
}
