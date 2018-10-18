package com.drelephant.elephantadmin.business.module.doctor.controller;


import com.drelephant.elephantadmin.business.module.base.BaseController;
import com.drelephant.elephantadmin.business.module.doctor.service.DoctorService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("doctor")
public class DoctorController extends BaseController {

    @Autowired
    private DoctorService doctorService;

}
