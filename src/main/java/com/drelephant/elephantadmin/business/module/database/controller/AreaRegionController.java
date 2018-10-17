package com.drelephant.elephantadmin.business.module.database.controller;


import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.drelephant.elephantadmin.business.module.base.BaseController;
import com.drelephant.elephantadmin.business.module.database.service.AreaRegionService;
import com.drelephant.framework.base.common.R;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "地区区域")
@RestController
@RequestMapping("areaRegion")
public class AreaRegionController extends BaseController {
    @Autowired
    private AreaRegionService areaRegionService;

    @ApiOperation("删除地区区域")
    @PostMapping("/deleteAreaRegion")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "code", value = "编码", required = true)
    })
    public R deleteAreaRegion(@RequestBody @ApiParam("map") Map<String, String> map) {
    	String code = map.get("code");
    	if (StringUtils.isBlank(code)) {
    		return R.error("参数map中缺少name为code的值");
    	}
    	//
        return areaRegionService.deleteAreaRegion(code);
    }
    
    @ApiOperation("判断地区区域是否被使用过了")
    @GetMapping("/isUsed")
    public R isUsed(@ApiParam(value="编码") @RequestParam(value="code", required=true) String code) {
        return areaRegionService.isUsed(code);
    }
}
