package vip.ddm.ddm.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.ddm.ddm.dao.StoreMapper;
import vip.ddm.ddm.dto.BaseQuery;
import vip.ddm.ddm.dto.StoreDto;
import vip.ddm.ddm.exception.GlobleException;
import vip.ddm.ddm.model.Store;
import vip.ddm.ddm.result.CodeMsg;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreMapper storeMapper;


    public void save(@Valid StoreDto storeDto){
        Store store = new Store();
        BeanUtils.copyProperties(storeDto,store);
        if(store.getId() != null){
            storeMapper.updateByPrimaryKey(store);
        }else {
            store.setDate(new Date());
            store.setStatus((byte) 0);
            storeMapper.insert(store);
        }
    }

    public void updateStatus(Integer id,Byte status){
        if(id == null){
            throw new GlobleException(CodeMsg.STORE_ID_NULL);
        }
        Store store = storeMapper.selectByPrimaryKey(id);
        if(store == null){
            throw new GlobleException(CodeMsg.STORE_NULL);
        }
        store.setStatus(status);
        storeMapper.updateByPrimaryKey(store);

    }

    public List<Store> list(BaseQuery baseQuery){
        PageHelper.startPage(baseQuery.getPage(),baseQuery.getRows());
        List<Store> stores = storeMapper.list(baseQuery.getKey());
        return stores;
    }


    public void updateOrderStatus(StoreDto storeDto) {
        if(storeDto.getId() == null){
            throw new GlobleException(CodeMsg.STORE_ID_NULL);
        }
        Store store = storeMapper.selectByPrimaryKey(storeDto.getId());
        if(store == null){
            throw new GlobleException(CodeMsg.STORE_NULL);
        }
        if(storeDto.getAmOrderStatus() != null){
            store.setAmOrderStatus(storeDto.getAmOrderStatus());
        }
        if(storeDto.getPmOrderStatus() != null){
            store.setAmOrderStatus(storeDto.getPmOrderStatus());
        }
        storeMapper.updateByPrimaryKeySelective(store);
    }
}
