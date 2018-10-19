package com.drelephant.elephantadmin.business.module.patient.controller;

import com.drelephant.elephantadmin.business.module.patient.service.PatientService;
import com.drelephant.framework.base.common.R;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author admin
 */
@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    /**
     * 患者注册.
     *
     * @param data data
     * @return R
     */
    @ApiOperation("后台-新增用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phoneNumber", value = "phoneNumber", required = true),
            @ApiImplicitParam(name = "password", value = "password", required = true),
            @ApiImplicitParam(name = "storeCode", value = "storeCode"),
            @ApiImplicitParam(name = "storeName", value = "storeName"),
    })
    @PostMapping("/addPatientAccount")
    public R addPatientAccountForWeb(@RequestBody Map<String, String> data) {
        return patientService.regPatientForWeb(data);
    }


}
