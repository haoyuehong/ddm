package vip.ddm.ddm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;
import vip.ddm.ddm.dao.GoodsGroupMapper;
import vip.ddm.ddm.exception.GlobleException;
import vip.ddm.ddm.model.GoodsGroup;
import vip.ddm.ddm.result.CodeMsg;

import java.util.Date;
import java.util.List;

@Service
public class GoodsGroupService {

    @Autowired
    private GoodsGroupMapper goodsGroupMapper;

    public void save(GoodsGroup goodsGroup){
        if(goodsGroup.getId() != null){
            goodsGroupMapper.updateByPrimaryKeySelective(goodsGroup);
        }else{
            goodsGroup.setDate(new Date());
            goodsGroupMapper.insert(goodsGroup);
        }
    }

    public void delete(Integer id){
        if(id == null){
            throw new GlobleException(CodeMsg.GROUP_ID_NULL);
        }
        // TODO 根据分组id查询商品并删除全部商品

        goodsGroupMapper.deleteByPrimaryKey(id);
    }

    public List<GoodsGroup> findAll(GoodsGroup goodsGroup){
        return goodsGroupMapper.selectByName(goodsGroup.getGroupName());
    }


}
