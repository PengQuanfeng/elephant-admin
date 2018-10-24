package com.drelephant.elephantadmin.business.module.store.controller;

import com.drelephant.elephantadmin.business.module.store.dto.request.StorePkgAndDeptQueryRequest;
import com.drelephant.elephantadmin.business.module.store.service.StoreService;
import com.drelephant.elephantadmin.business.module.util.Constants;
import com.drelephant.framework.base.common.R;
import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhou.fan
 * @date 2018/10/23 10:48
 * @description
 */
@RestController
@Api(tags = "门店")
@RequestMapping("store")
public class StoreController {

    @Autowired
    private StoreService storeService;


    @ApiOperation("查询所有的科室以及组套列表")
    @GetMapping("/getAllPkgAndDeptByCondition")
    @ApiParam
    public R getAllPkgAndDeptByCondition(StorePkgAndDeptQueryRequest request) {
        if (!Lists.newArrayList(Constants.JC, Constants.JY).contains(request.getCategoryCode())) {
            return R.error("类型必须为JY/JC");
        }
       return storeService.getAllPkgAndDeptByCondition(request);
    }

}
