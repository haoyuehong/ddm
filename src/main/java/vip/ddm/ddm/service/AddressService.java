package vip.ddm.ddm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.ddm.ddm.dao.AddressMapper;
import vip.ddm.ddm.dto.AddressDto;
import vip.ddm.ddm.exception.GlobleException;
import vip.ddm.ddm.model.Address;
import vip.ddm.ddm.result.CodeMsg;

import javax.validation.Valid;
import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressMapper addressMapper;

    public void save(@Valid AddressDto addressDto){
        Address address = new Address();
        BeanUtils.copyProperties(addressDto,address);
        if(address.getId() != null){
            addressMapper.updateByPrimaryKey(address);
        }else{
            address.setStatus((byte)0);
            addressMapper.insert(address);
        }
    }

    public void delete(Integer id){
        if(id == null){
            throw new GlobleException(CodeMsg.ADDRESS_ID_NULL);
        }
        Address address = addressMapper.selectByPrimaryKey(id);
        if(address == null){
            throw new GlobleException(CodeMsg.ADDRESS_NULL);
        }
        address.setStatus((byte)1);
        addressMapper.updateByPrimaryKey(address);
    }

    public PageInfo<Address> list(Address address,int page ,int rows){
        PageHelper.startPage(page,rows);
        List<Address> list = addressMapper.findList(address);
        return new PageInfo<>(list);
    }


}
