package com.drelephant.elephantadmin.business.module.doctor.controller;


import com.drelephant.elephantadmin.business.module.base.BaseController;
import com.drelephant.elephantadmin.business.module.doctor.service.DoctorService;
import com.drelephant.framework.base.common.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api(tags = "医生")
@RestController
@RequestMapping("/admin/doctor")
public class DoctorController extends BaseController {

    @Autowired
    private DoctorService doctorService;

    /**
     * 获取医生未关联门店列表,分页.
     *
     *
     * @param doctorCode
     * @param current
     * @param pageSize
     * @return
     */
    @GetMapping("/pageDoctorLinkedStore")
    public R pageDoctorLinkedStore(String doctorCode, Integer current, Integer pageSize) {
        return doctorService.pageDoctorLinkedStore(doctorCode, current, pageSize);
    }

}
