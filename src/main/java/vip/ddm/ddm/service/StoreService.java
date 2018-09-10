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
import vip.ddm.ddm.utils.EncryptTool;
import vip.ddm.ddm.utils.SessionUtil;

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
            storeMapper.updateByPrimaryKeySelective(store);
        }else {
            String password = EncryptTool.encrypt(storeDto.getPassword());
            store.setPassword(password);
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

    public List<Store> list(){
        List<Store> stores;
        //查询当前登陆店铺的所有子店铺
        if(SessionUtil.getOnlineSession().getType() == -1){
            stores = storeMapper.list();
        }else{
            Integer parentId = SessionUtil.getOnlineSession().getId();
            stores = storeMapper.findByParent(parentId);
            stores.add(SessionUtil.getOnlineSession());
        }
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

    public List<Store> finbyparent(Integer id) {
        return storeMapper.findByParent(id);
    }

    public Store findById(Integer storeId) {
        return storeMapper.selectByPrimaryKey(storeId);

    }
}
