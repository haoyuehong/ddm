package vip.ddm.ddm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vip.ddm.ddm.dto.FullDownDto;
import vip.ddm.ddm.dto.IdQuery;
import vip.ddm.ddm.model.FullDown;
import vip.ddm.ddm.result.Result;
import vip.ddm.ddm.service.FullDownService;

@RestController
@RequestMapping("/full")
public class FullDownController {

    @Autowired
    private FullDownService fullDownService;

    @RequestMapping("/save")
    public Result save(FullDownDto fullDownDto){
        fullDownService.save(fullDownDto);
        return Result.success(true);
    }

    @RequestMapping("/delete")
    public Result delete(IdQuery idQuery){
        fullDownService.delete(idQuery.getId());
        return Result.success(true);
    }

    @RequestMapping("/list")
    public Result delete(FullDown fullDown){
        return Result.success(fullDownService.list(fullDown));
    }
}
