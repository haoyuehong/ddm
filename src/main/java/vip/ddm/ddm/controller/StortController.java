package vip.ddm.ddm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.ddm.ddm.dto.BaseQuery;
import vip.ddm.ddm.dto.StoreDto;
import vip.ddm.ddm.model.Store;
import vip.ddm.ddm.result.Result;
import vip.ddm.ddm.service.StoreService;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StortController {

    @Autowired
    private StoreService storeService;

    @RequestMapping("/save")
    public Result svae(StoreDto storeDto){
        storeService.save(storeDto);
        return Result.success(true);
    }

    @RequestMapping("/updateStatus")
    public Result updateStatus(StoreDto storeDto){
        storeService.updateStatus(storeDto.getId(),storeDto.getStatus());
        return Result.success(true);
    }


    @RequestMapping("/list")
    public Result list(BaseQuery baseQuery){
        List<Store> list = storeService.list(baseQuery);
        return Result.success(list);
    }
}