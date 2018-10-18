package com.drelephant.elephantadmin.business.module.doctor.util;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 该vo仅仅针对于后台-医生信息页面
 *
 * @author admin
 */
@Data
public class DoctorInfoVo {

    @NotNull
    private String doctorCode;

    @NotNull
    @Length(min = 1, max = 50, message = "名字必填")
    private String doctorName;
    /**
     * 头像文件ID
     */
    private String portraitFileId;
    /**
     * 性别: 0.女 1.男 2.未知
     */
    @NotNull
    private String sex;
    /**
     * 注册时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date registerTime;

    /**
     * 注册来源, 不修改
     */
    private String registerSourceCode;

    private String registerSourceName;
    /**
     * 身份证号
     */
    @NotNull
    @Length(min = 1, max = 18)
    private String idCardCode;
    /**
     * 医院机构编码
     */
    @NotNull
    @Length(min = 1, max = 32)
    private String orgCode;
    @NotNull
    @Length(min = 1, max = 50)
    private String orgName;
    /**
     * 科室编码
     */
    @NotNull
    @Length(min = 1, max = 32)
    private String deptCode;
    @NotNull
    @Length(min = 1, max = 50)
    private String deptName;
    /**
     * 职称
     */
    @NotNull
    @Length(min = 1, max = 32)
    private String doctorTitleCode;
    @NotNull
    @Length(min = 1, max = 50)
    private String doctorTitleName;
    /**
     * 省编码
     */
    @NotNull
    @Length(min = 1, max = 32)
    private String provinceCode;
    @NotNull
    @Length(min = 1, max = 50)
    private String provinceName;
    /**
     * 市编码
     */
    @NotNull
    @Length(min = 1, max = 32)
    private String cityCode;
    @NotNull
    @Length(min = 1, max = 50)
    private String cityName;
    /**
     * 县编码
     */
    private String countyCode;
    private String countyName;
    /**
     * 详细地址
     */
    private String detailedAddress;
    /**
     * 简介
     */
    @Length(max = 200)

    private String briefIntroduction;
    /**
     * 擅长
     */
    @Length(max = 200)
    private String goodAt;
    //-------------审核start --------------

    /**
     * 备注
     */
    private String remark;
    /**
     * 银行卡开户行,字符串
     */
    @Length(max = 50)
    private String bankName;
    /**
     * 银行账号
     */
    @Length(max = 32)
    private String bankCardCode;
    /**
     * 开户行省编码
     */
    @Length(max = 32)
    private String bankProvinceCode;
    @Length(max = 50)
    private String bankProvinceName;
    /**
     * 开户行城市编码
     */
    @Length(max = 50)
    private String bankCityCode;

    @Length(max = 50)
    private String bankCityName;

    /**
     * 不启用版本控制.
     */
    private String version;
}
