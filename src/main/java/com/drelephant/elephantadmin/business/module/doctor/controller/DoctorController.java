package com.drelephant.elephantadmin.business.module.doctor.controller;


import com.drelephant.elephantadmin.business.module.base.BaseController;
import com.drelephant.elephantadmin.business.module.doctor.service.DoctorService;
import com.drelephant.elephantadmin.business.module.doctor.util.DUtil;
import com.drelephant.elephantadmin.business.module.doctor.util.DoctorInfoVo;
import com.drelephant.framework.base.common.R;
import io.swagger.annotations.*;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

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
@RequestMapping("/doctor")
public class DoctorController extends BaseController {

    @Autowired
    private DoctorService doctorService;

    /**
     * 分页获取医生关联门店列表,分页.
     *
     * @param doctorCode doctorCode
     * @param current    current
     * @param pageSize   pageSize
     * @return R
     */
    @ApiOperation("分页获取医生关联门店列表")
    @GetMapping("/pageDoctorLinkedStore")
    public R pageDoctorLinkedStore(@ApiParam("医生账号") String doctorCode, Integer current, Integer pageSize) {
        return doctorService.pageDoctorLinkedStore(doctorCode, current, pageSize);
    }

    /**
     * 更新保存医生基本信息.
     *
     * @param doctorInfoVo doctorInfoVo
     * @return R
     */
    @ApiOperation("后台-更新保存医生基本信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "doctorCode", value = "账号", required = true),
            @ApiImplicitParam(name = "doctorName", value = "姓名", required = true),
            @ApiImplicitParam(name = "sex", value = "性别", required = true),
            @ApiImplicitParam(name = "idCardCode", value = "身份证号", required = true),

            @ApiImplicitParam(name = "provinceCode", value = "省编码", required = true),
            @ApiImplicitParam(name = "provinceName", value = "省名称", required = true),
            @ApiImplicitParam(name = "cityCode", value = "市编码", required = true),
            @ApiImplicitParam(name = "cityName", value = "市名称", required = true),
            @ApiImplicitParam(name = "orgCode", value = "医院编码", required = true),
            @ApiImplicitParam(name = "orgName", value = "医院名称", required = true),
            @ApiImplicitParam(name = "deptCode", value = "科室编码", required = true),
            @ApiImplicitParam(name = "deptName", value = "科室名称", required = true),
            @ApiImplicitParam(name = "doctorTitleCode", value = "职称编码", required = true),
            @ApiImplicitParam(name = "doctorTitleName", value = "职称名称", required = true),

            @ApiImplicitParam(name = "briefIntroduction", value = "简介", required = true),
            @ApiImplicitParam(name = "goodAt", value = "擅长", required = true),
            @ApiImplicitParam(name = "bankName", value = "开户行名称", required = true),
            @ApiImplicitParam(name = "bankCardCode", value = "银行卡号", required = true),
            @ApiImplicitParam(name = "bankProvinceCode", value = "开户行省编码", required = true),
            @ApiImplicitParam(name = "bankProvinceName", value = "开户行省名称", required = true),
            @ApiImplicitParam(name = "bankCityCode", value = "开户行城市编码", required = true),
            @ApiImplicitParam(name = "bankCityName", value = "开户行城市名称", required = true),
    })
    @PostMapping("/update")
    public R update(@RequestBody @Valid DoctorInfoVo doctorInfoVo) {
        return doctorService.updateDoctorInfo(doctorInfoVo);
    }

    /**
     * 新增医生, 并新增账号.新增医生基本信息
     *
     * @param data data
     * @return R
     */
    @ApiOperation("后台-新增医生")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "phoneNumber", value = "手机号码", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true),
            @ApiImplicitParam(name = "recommendUserId", value = "推荐人ID"),
    })
    @PostMapping("/addDoctorAccount")
    public R addDoctor(@RequestBody Map<String, String> data) {
        val phoneNumber = data.get("phoneNumber");
        val password = data.get("password");
        // 3,  recommendUserId
        if (DUtil.isAnyBlank(phoneNumber, password)) {
            return R.error("有参数为空" + data.toString());
        }
        return doctorService.addDoctor(data);
    }

}
