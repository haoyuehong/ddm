package vip.ddm.ddm.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vip.ddm.ddm.dto.AddressDto;
import vip.ddm.ddm.dto.AddressQuesryDto;
import vip.ddm.ddm.dto.IdQuery;
import vip.ddm.ddm.model.Address;
import vip.ddm.ddm.result.Result;
import vip.ddm.ddm.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Result save(@RequestBody AddressDto addressDto){
        addressService.save(addressDto);
        return Result.success(true);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Result save(@RequestBody IdQuery idQuery){
        addressService.delete(idQuery.getId());
        return Result.success(true);
    }

    @RequestMapping(value = "/list")
    public Result<PageInfo<Address>> list(@RequestBody AddressQuesryDto addressQuesryDto){
        return Result.success(addressService.list(addressQuesryDto.getAddress(),addressQuesryDto.getPage(),addressQuesryDto.getRows()));
    }
}
