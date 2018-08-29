package vip.ddm.ddm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vip.ddm.ddm.dto.GoodsDto;
import vip.ddm.ddm.dto.GoodsListDto;
import vip.ddm.ddm.dto.GoodsQuesryDto;
import vip.ddm.ddm.dto.IdQuery;
import vip.ddm.ddm.model.Goods;
import vip.ddm.ddm.result.Result;
import vip.ddm.ddm.service.GoodsService;
import vip.ddm.ddm.vo.GoodsVo;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public Result list(@RequestBody GoodsQuesryDto quesryDto){
        PageInfo<GoodsVo> pageInfo = goodsService.goodsList(quesryDto.getGoods(), quesryDto.getPage(), quesryDto.getRows(), quesryDto.getStoreId());
        return Result.success(pageInfo);
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result save(@RequestBody GoodsDto goodsDto){
        goodsService.save(goodsDto);
        return Result.success(true);
    }

    @RequestMapping(value = "/saveBetch",method = RequestMethod.POST)
    public Result saveBetch(@RequestBody GoodsListDto goodsListDto){
        goodsService.saveBetch(goodsListDto);
        return Result.success(true);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result save(@RequestBody IdQuery idQuery){
        goodsService.delete(idQuery.getId());
        return Result.success(true);
    }
}
