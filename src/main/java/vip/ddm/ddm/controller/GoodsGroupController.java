package vip.ddm.ddm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public Result save(GoodsGroup goodsGroup){
        goodsGroupService.save(goodsGroup);
        return Result.success(true);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Result delete(Integer id){
        goodsGroupService.delete(id);
        return Result.success(true);
    }

    @RequestMapping("/list")
    @ResponseBody
    public Result delete(GoodsGroup goodsGroup){

        return Result.success(goodsGroupService.findAll(goodsGroup));
    }
}
