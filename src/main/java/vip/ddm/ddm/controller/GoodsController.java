package vip.ddm.ddm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vip.ddm.ddm.dto.GoodsDto;
import vip.ddm.ddm.model.Goods;
import vip.ddm.ddm.result.Result;
import vip.ddm.ddm.service.GoodsService;
import vip.ddm.ddm.vo.GoodsVo;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Result list(int page, int rows, Goods goods){
        PageInfo<GoodsVo> pageInfo = goodsService.goodsList(goods, page, rows);
        return Result.success(pageInfo);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result save(GoodsDto goodsDto){
        goodsService.save(goodsDto);
        return Result.success(true);
    }

    @RequestMapping(value = "/delet",method = RequestMethod.POST)
    public Result save(Integer id){
        goodsService.delete(id);
        return Result.success(true);
    }
}
