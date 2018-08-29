package vip.ddm.ddm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.ddm.ddm.dto.IdAndStatusDto;
import vip.ddm.ddm.dto.IdQuery;
import vip.ddm.ddm.dto.OrderDto;
import vip.ddm.ddm.dto.OrderQueryDto;
import vip.ddm.ddm.result.Result;
import vip.ddm.ddm.service.OrderService;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/save")
    public Result save(OrderDto orderDto){
        orderService.save(orderDto);
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
        orderService.list(orderQueryDto);
        return Result.success(true);
    }


}
