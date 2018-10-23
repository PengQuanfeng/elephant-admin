package com.drelephant.elephantadmin.business.module.store.controller;

import com.drelephant.elephantadmin.business.module.store.service.StoreService;
import com.drelephant.framework.base.common.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhou.fan
 * @date 2018/10/23 10:48
 * @description
 */
@RestController
@Api("门店")
@RequestMapping("store")
public class StoreController {

    @Autowired
    private StoreService storeService;


    @ApiOperation("查询所有的科室以及组套列表")
    @GetMapping("/getAllPkgAndDept")
    public R getAllPkgAndDept(@RequestParam("storeCode") String storeCode) {
        return storeService.getAllPkgAndDept(storeCode);
    }
}
