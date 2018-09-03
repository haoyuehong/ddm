package vip.ddm.ddm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.ddm.ddm.dto.*;
import vip.ddm.ddm.exception.GlobleException;
import vip.ddm.ddm.result.CodeMsg;
import vip.ddm.ddm.result.Result;
import vip.ddm.ddm.service.OrderService;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/save")
    public Result save(@RequestBody OrderDtos orderDtos){
        orderService.save(orderDtos);
        return Result.success(true);
    }

    @RequestMapping("/detail")
    public Result detail(@RequestBody IdAndStatusDto idAndStatusDto){
        return Result.success(orderService.detail(idAndStatusDto.getId()));
    }


    @RequestMapping("/update")
    public Result updateStatus(@RequestBody IdAndStatusDto idAndStatusDto){
        orderService.updateStatus(idAndStatusDto.getId(),idAndStatusDto.getStatus());
        return Result.success(true);
    }

    @RequestMapping("/list")
    public Result list(@RequestBody OrderQueryDto orderQueryDto){
        try {
            orderService.list(orderQueryDto);
        } catch (ParseException e) {
            throw new GlobleException(CodeMsg.SERVER_ERROR);
        }
        return Result.success(true);
    }


}
