package com.drelephant.elephantadmin.business.module.doctor.controller;


import com.drelephant.elephantadmin.business.module.base.BaseController;
import com.drelephant.elephantadmin.business.module.doctor.service.DoctorServiceConfigService;
import com.drelephant.framework.base.common.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 医生服务配置 前端控制器
 * </p>
 *
 * @author com.drelephant
 * @since 2018-10-09
 */
@Api(tags = "医生服务配置")
@RestController
@RequestMapping("doctorServiceConfig")
public class DoctorServiceConfigController extends BaseController {

    @Autowired
    private DoctorServiceConfigService doctorServiceConfigService;

    /**
     * 修改所需时长
     *
     * @param code
     * @param averageTimeCode
     * @return
     */
    @PostMapping("/updateAverage")
    public R updateAverage(String code, String averageTimeCode) {
        return doctorServiceConfigService.updateAverage(code, averageTimeCode);
    }

}
