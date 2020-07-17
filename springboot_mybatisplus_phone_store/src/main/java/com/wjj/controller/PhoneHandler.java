package com.wjj.controller;

import com.wjj.Util.ResultVoUtil;
import com.wjj.service.PhoneService;
import com.wjj.vo.DataVo;
import com.wjj.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phone")
public class PhoneHandler {

    @Autowired
    private PhoneService phoneService;
    @GetMapping("/index")
    public ResultVo index(){
        return ResultVoUtil.success(phoneService.findDateVo());
    }

    @GetMapping("/findByCategoryType/{categoryType}")
    public ResultVo findByCategoryType(@PathVariable("categoryType") Integer categoryType){
        return ResultVoUtil.success(phoneService.findPhoneInfoVoByCategoryType(categoryType));
    }

    @GetMapping("/findSpecsByPhoneId/{phoneId}")
    public ResultVo findSpecsByPhoneId(@PathVariable("phoneId") Integer phoneId){
        return ResultVoUtil.success(phoneService.findSpecsByPhoneId(phoneId));

    }
}
