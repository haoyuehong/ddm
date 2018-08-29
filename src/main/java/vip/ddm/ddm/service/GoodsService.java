package vip.ddm.ddm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.ddm.ddm.dao.GoodsMapper;
import vip.ddm.ddm.dto.GoodsDto;
import vip.ddm.ddm.dto.GoodsListDto;
import vip.ddm.ddm.exception.GlobleException;
import vip.ddm.ddm.model.Discount;
import vip.ddm.ddm.model.Goods;
import vip.ddm.ddm.result.CodeMsg;
import vip.ddm.ddm.utils.SessionUtil;
import vip.ddm.ddm.vo.GoodsVo;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class GoodsService {

    private static  String  SPLITE_STR = "##";

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private DisCountService disCountService;

    public void save(GoodsDto goodsDto){
        Goods goods = new Goods();
        BeanUtils.copyProperties(goodsDto,goods);
        String imageStr = (String) list2Str(goodsDto.getImages());
        goods.setImages(imageStr);
        String tasteStr = (String) list2Str(goodsDto.getTaste());
        goods.setTaste(tasteStr);
        if(goods.getId() != null){
            goodsMapper.updateByPrimaryKeySelective(goods);
        }else{
            goodsMapper.insert(goods);
        }
    }


    public void delete(Integer id){
        if(id == null){
            throw new GlobleException(CodeMsg.GOOD_ID_NULL);
        }
        Goods goods = goodsMapper.selectByPrimaryKey(id);
        if(goods == null){
            throw new GlobleException(CodeMsg.GOOD_NULL);
        }
        goods.setStatus((byte)2);
        goodsMapper.updateByPrimaryKeySelective(goods);
    }

    public PageInfo<GoodsVo> goodsList(Goods goods,int page ,int rows,Integer storeId){
        if(storeId == null && SessionUtil.getOnlineSession().getType() != 0){
            storeId = SessionUtil.getOnlineSession().getId();
        }
        if(goods.getDate() == null){
            goods.setDate(new Date());
        }
        PageHelper.startPage(page,rows);
        List<GoodsVo> goodsVos = goodsMapper.findByParam(goods,storeId);
        for(GoodsVo goodsVo:goodsVos){
            String images = goodsVo.getImages();
            String[] imageList = images.split(SPLITE_STR);
            List<String> imageses = Arrays.asList(imageList);
            goodsVo.setImageStr(imageses);
            if(goodsVo.getStatus() == 0){
                goodsVo.setStrStatus("已上架");
            }else if(goodsVo.getStatus() == 1){
                goodsVo.setStrStatus("已下架");
            }else if(goodsVo.getStatus() == 2){
                goodsVo.setStrStatus("已删除");
            }
            String taste = goodsVo.getTaste();
            if(!taste.equals("")){
                String[] tastes = taste.split(SPLITE_STR);
                List<String> tastList = Arrays.asList(tastes);
                goodsVo.setTasteStr(tastList);
            }
            Discount discount = disCountService.findByGoodsId(goodsVo.getId());
            if(discount != null){
                goodsVo.setDiscount("参与打折");
                goodsVo.setDiscountPrice(discount.getDiscountPrice());

            }
        }
        return new PageInfo<>(goodsVos);
    }


    public static Object list2Str(List strings){
        Object str = null;
        if(strings !=null && strings.size()>0){
            for(int i =0; i < strings.size(); i ++){
                if(i == 0){
                    str = strings.get(0);
                }else{
                    str = str + SPLITE_STR + strings.get(i);
                }
            }
        }
        return str;
    }


    /**
     * 根据分类查询
     */
    public List<Goods> findByGroupId(Integer groupId){
        return goodsMapper.findByGroupId(groupId);

    }

    public void saveBetch(GoodsListDto goodsListDto) {
        Integer groupId = goodsListDto.getGroupId();
        Date date = goodsListDto.getDate();
        List<GoodsDto> goodsDtos = goodsListDto.getGoodsDtos();
        for(GoodsDto goodsDto:goodsDtos){
            Goods goods = new Goods();
            goods.setDate(date);
            goods.setStock(goodsDto.getStock());
            goods.setPrice(goodsDto.getPrice());
            goods.setStatus((byte)0);
            goods.setBoxPrice(goodsDto.getBoxPrice());
            goods.setDescr(goodsDto.getDescr());
            goods.setGoodsName(goodsDto.getGoodsName());
            goods.setGroupId(groupId);
            String taste = (String)list2Str(goodsDto.getTaste());
            goods.setTaste(taste);
            String image = (String)list2Str(goodsDto.getImages());
            goods.setImages(image);
            goodsMapper.insert(goods);
        }
    }
}
