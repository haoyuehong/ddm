package vip.ddm.ddm.controller.app;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.ddm.ddm.dao.CouponGoodsMapper;
import vip.ddm.ddm.model.Discount;
import vip.ddm.ddm.model.Goods;
import vip.ddm.ddm.result.Result;
import vip.ddm.ddm.service.CouponService;
import vip.ddm.ddm.service.DisCountService;
import vip.ddm.ddm.service.GoodsService;
import vip.ddm.ddm.utils.DateTools;
import vip.ddm.ddm.vo.AppGoodsVo;
import vip.ddm.ddm.vo.SellGoodsVo;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/app")
public class AppDataController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CouponGoodsMapper couponGoodsMapper;
    @Autowired
    private DisCountService disCountService;

    /**
     * 查询连续7天的数据
     */
    @RequestMapping("/goodsList")
    public Result goodsList(Integer storeId,Integer groupId) throws ParseException {
        List<SellGoodsVo> sellGoodsVos = new ArrayList<>();
        List<Date> sevenDate = DateTools.getSevenDate();
        for(Date date : sevenDate){
            List<AppGoodsVo> appGoodsVos = new ArrayList<>();
            SellGoodsVo sellGoodsVo = new SellGoodsVo();
            sellGoodsVo.setDate(date);
            List<Goods> goodsList = goodsService.findByStoreId(storeId,groupId,date);
            for(Goods goods : goodsList){
                AppGoodsVo appGoodsVo = new AppGoodsVo();
                Discount discount = disCountService.findByGoodsId(goods.getId());
                BeanUtils.copyProperties(goods,appGoodsVo);
                if(discount != null){
                    appGoodsVo.setDiscount(true);
                    appGoodsVo.setDiscountPrice(discount.getDiscountPrice());
                    appGoodsVo.setSuperpostion(discount.getSuperposition());
                    appGoodsVo.setNum(discount.getNum());
                }
                String taste = goods.getTaste();
                if(taste.length()>0){
                    String[] split = taste.split(GoodsService.SPLITE_STR);
                    appGoodsVo.setTaste(Arrays.asList(split));
                }
                String images = goods.getImages();
                if(images.length()>0){
                    String[] split = images.split(GoodsService.SPLITE_STR);
                    appGoodsVo.setImages(Arrays.asList(split));
                }
                appGoodsVo.setGoodsId(goods.getId());
                appGoodsVos.add(appGoodsVo);
            }
            sellGoodsVo.setAppGoodsVos(appGoodsVos);
            sellGoodsVos.add(sellGoodsVo);
        }
        return Result.success(sellGoodsVos);
    }
}
