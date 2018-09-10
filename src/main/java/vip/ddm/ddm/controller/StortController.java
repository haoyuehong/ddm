package vip.ddm.ddm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.ddm.ddm.common.OnlineUserInfo;
import vip.ddm.ddm.dto.BaseQuery;
import vip.ddm.ddm.dto.IdQuery;
import vip.ddm.ddm.dto.StoreDto;
import vip.ddm.ddm.exception.GlobleException;
import vip.ddm.ddm.model.Store;
import vip.ddm.ddm.result.CodeMsg;
import vip.ddm.ddm.result.Result;
import vip.ddm.ddm.service.StoreService;
import vip.ddm.ddm.utils.SessionUtil;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/store")
public class StortController {

    @Autowired
    private StoreService storeService;

    @RequestMapping("/save")
    public Result svae(@RequestBody StoreDto storeDto) {
        storeService.save(storeDto);
        return Result.success(true);
    }

    @RequestMapping("/updateStatus")
    public Result updateStatus(@RequestBody StoreDto storeDto) {
        storeService.updateStatus(storeDto.getId(), storeDto.getStatus());

        return Result.success(true);
    }


    @RequestMapping("/list")
    public Result list() {
        List<Store> storeList = new ArrayList<>();
        if (SessionUtil.getOnlineSession().getType() == 0) {
            storeList = storeService.finbyparent(SessionUtil.getOnlineSession().getId());
            storeList.add(SessionUtil.getOnlineSession());
        } else if (SessionUtil.getOnlineSession().getType() == -1) {
            storeList = storeService.list();
        } else {
            Store store = SessionUtil.getOnlineSession();
            storeList.add(store);
        }
        return Result.success(storeList);
    }

    @RequestMapping("/updateOrderStatus")
    public Result updateOrderStatus(@RequestBody StoreDto storeDto) {
        storeService.updateOrderStatus(storeDto);
        return Result.success(true);
    }

    @RequestMapping("/getParent")
    public Result findbyparent() {
        List<Store> list = new ArrayList<>();
        if (SessionUtil.getOnlineSession().getType() == -1) {
            list = storeService.finbyparent(SessionUtil.getOnlineSession().getId());
        } else if (SessionUtil.getOnlineSession().getType() == 0) {
            list.add(SessionUtil.getOnlineSession());
        }
        return Result.success(list);
    }

    @RequestMapping("/status")
    public Result getStoreStatus() {
        Integer storeId = SessionUtil.getOnlineSession().getId();
        Store store = storeService.findById(storeId);
        return Result.success(store);
    }
}