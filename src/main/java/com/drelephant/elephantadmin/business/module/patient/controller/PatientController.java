package com.drelephant.elephantadmin.business.module.patient.controller;

import com.drelephant.elephantadmin.business.module.patient.service.PatientService;
import com.drelephant.framework.base.common.R;
import io.swagger.annotations.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author admin
 */
@Api(tags = "后台-用户管理")
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

    /**
     * 重置密码.
     * 需网关check权限.
     * 此处不再check.
     *
     * @param userCode userCode
     * @return R
     */
    @ApiOperation("重置用户或者医生的密码")
    @GetMapping("/resetUserPassword")
    public R resetPatientPass(@ApiParam("userCode") String userCode) {
        if (StringUtils.isBlank(userCode)) {
            return R.error("userCode is required");
        }
        return patientService.resetUserPasswordForAdmin(userCode);
    }

}
