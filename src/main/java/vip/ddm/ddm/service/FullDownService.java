package vip.ddm.ddm.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vip.ddm.ddm.dao.FullDownMapper;
import vip.ddm.ddm.dto.FullDownDto;
import vip.ddm.ddm.exception.GlobleException;
import vip.ddm.ddm.model.FullDown;
import vip.ddm.ddm.result.CodeMsg;

import javax.validation.Valid;
import java.util.List;

@Service
public class FullDownService {

    @Autowired
    private FullDownMapper fullDownMapper;


    public void save(@Valid FullDownDto fullDownDto){
        FullDown fullDown = new FullDown();
        BeanUtils.copyProperties(fullDownDto,fullDown);
        if(fullDown.getId() != null){
            fullDownMapper.updateByPrimaryKey(fullDown);
        }else{
            fullDownMapper.insert(fullDown);
        }
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

    public List<FullDown> list(FullDown fullDown){
        return fullDownMapper.findList(fullDown);
    }
}
