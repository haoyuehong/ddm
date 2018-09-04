package vip.ddm.ddm.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.ddm.ddm.dao.FullDownMapper;
import vip.ddm.ddm.dto.FullDownDto;
import vip.ddm.ddm.exception.GlobleException;
import vip.ddm.ddm.model.CouponStore;
import vip.ddm.ddm.model.FullDown;
import vip.ddm.ddm.result.CodeMsg;
import vip.ddm.ddm.utils.SessionUtil;
import vip.ddm.ddm.vo.FullDownVo;

import javax.validation.Valid;
import java.util.List;

@Service
public class FullDownService {

    @Autowired
    private FullDownMapper fullDownMapper;
    @Autowired
    private CouponService couponService;


    public void save(@Valid FullDownDto fullDownDto){
        if(fullDownDto.getStoreIds() == null || fullDownDto.getStoreIds().size() == 0){
            FullDown fullDown = new FullDown();
            BeanUtils.copyProperties(fullDownDto,fullDown);
            fullDown.setStoreId(SessionUtil.getOnlineSession().getId());
            saveBetch(fullDown);
        }else{
            for(Integer storeId : fullDownDto.getStoreIds()){
                FullDown fullDown = new FullDown();
                BeanUtils.copyProperties(fullDownDto,fullDown);
                fullDown.setStoreId(storeId);
                saveBetch(fullDown);
            }
        }
    }

    public void saveBetch(FullDown fullDown){
        fullDownMapper.insert(fullDown);
    }


    public void delete(Integer id){
        if(id == null){
            throw new GlobleException(CodeMsg.FULL_DOWN_ID_NULL);
        }
        FullDown fullDown = fullDownMapper.selectByPrimaryKey(id);
        if(fullDown == null){
            throw new GlobleException(CodeMsg.FULL_DOWN_NULL);
        }
        fullDown.setStatus((byte)1);
        fullDownMapper.updateByPrimaryKey(fullDown);
    }

    public List<FullDownVo> list(FullDown fullDown){
        List<Integer> storeIds = couponService.getStoreIds(fullDown.getStoreId());
        return fullDownMapper.findList(fullDown,storeIds);
    }

    public List<FullDown> findByStatus(int i) {
        return null;
    }
}
