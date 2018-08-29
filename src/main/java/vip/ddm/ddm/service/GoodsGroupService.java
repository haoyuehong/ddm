package vip.ddm.ddm.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.ddm.ddm.dao.GoodsGroupMapper;
import vip.ddm.ddm.dto.GoodsGroupDto;
import vip.ddm.ddm.exception.GlobleException;
import vip.ddm.ddm.model.Goods;
import vip.ddm.ddm.model.GoodsGroup;
import vip.ddm.ddm.result.CodeMsg;
import vip.ddm.ddm.utils.SessionUtil;
import vip.ddm.ddm.vo.GroupVo;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GoodsGroupService {

    @Autowired
    private GoodsGroupMapper goodsGroupMapper;
    @Autowired
    private GoodsService goodsService;

    public void save(@Valid GoodsGroupDto goodsGroupDto){
        Integer storeId = goodsGroupDto.getStoreId();
        if(storeId == null){
            storeId = SessionUtil.getOnlineSession().getId();
        }
        GoodsGroup goodsGroup = new GoodsGroup();
        BeanUtils.copyProperties(goodsGroupDto,goodsGroup);
        if(goodsGroup.getId() != null){
            goodsGroupMapper.updateByPrimaryKeySelective(goodsGroup);
        }else{
            goodsGroup.setStoreId(storeId);
            goodsGroup.setDate(new Date());
            goodsGroupMapper.insert(goodsGroup);
        }
    }

    public void delete(Integer id){
        if(id == null){
            throw new GlobleException(CodeMsg.GROUP_ID_NULL);
        }
        GoodsGroup goodsGroup = goodsGroupMapper.selectByPrimaryKey(id);
        if(goodsGroup == null){
            throw new GlobleException(CodeMsg.GROUP_NOT_FIND);
        }
        List<Goods> list = goodsService.findByGroupId(id);
        if(list.size()>0){
            throw new GlobleException(CodeMsg.GROUP_GOOD_NOT_NULL);
        }
        goodsGroup.setStatus((byte)1);
        goodsGroupMapper.updateByPrimaryKey(goodsGroup);
    }

    public List<GroupVo> findAll(GoodsGroup goodsGroup){
        Integer storeId = goodsGroup.getStoreId();
        if(storeId == null & SessionUtil.getOnlineSession().getType() != 0){
            storeId = SessionUtil.getOnlineSession().getId();
            goodsGroup.setStoreId(storeId);
        }

        List<GroupVo> groupVos = new ArrayList<>();
        List<GroupVo> goodsGroups = goodsGroupMapper.selectByName(goodsGroup);
        for(GoodsGroup gp : goodsGroups){
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strDate = format.format(gp.getDate());
            GroupVo groupVo = new GroupVo();
            BeanUtils.copyProperties(gp,groupVo);
            groupVo.setStrDate(strDate);
            groupVos.add(groupVo);
        }
        return groupVos;
    }


}
