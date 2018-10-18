package com.drelephant.elephantadmin.business.module.database.controller;


import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.drelephant.elephantadmin.business.module.base.BaseController;
import com.drelephant.elephantadmin.business.module.database.service.HospitalService;
import com.drelephant.framework.base.common.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "医院")
@RestController
@RequestMapping("hospital")
public class HospitalController extends BaseController {
    @Autowired
    private HospitalService hospitalService;

    @ApiOperation("删除医院")
    @PostMapping("/deleteHospital")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "orgCode", value = "医院编码", required = true)
    })
    public R deleteHospital(@RequestBody @ApiParam("map") Map<String, String> map) {
    	String orgCode = map.get("orgCode");
    	if (StringUtils.isBlank(orgCode)) {
    		return R.error("参数map中缺少name为orgCode的值");
    	}
    	//
        return hospitalService.deleteHospital(orgCode);
    }
    
    @ApiOperation("判断医院下是否有所属医生")
    @GetMapping("/checkDoctors")
    public R checkDoctors(@ApiParam(value="医院编码") @RequestParam(value="orgCode", required=true) String orgCode) {
        return hospitalService.checkDoctors(orgCode);
    }
}
