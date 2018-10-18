package com.drelephant.elephantadmin.business.module.doctor.util;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 门店store信息表
 * </p>
 *
 * @author com.drelephant
 * @since 2018-10-09
 */
@Data
public class StoreInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
	private String id;
    /**
     * 门店名称
     */
	private String name;
    /**
     * 门店编码
     */
	private String code;
    /**
     * 所属机构编码
     */
	private String orgCode;
    /**
     * 所属机构名称
     */
	private String orgName;
    /**
     * 所属机构类型编码
     */
	private String orgTypeCode;
    /**
     * 所属机构类型名称
     */
	private String orgTypeName;
    /**
     * 门店属性编码
     */
	private String storeAttrCode;
    /**
     * 门店属性名称
     */
	private String storeAttrName;
    /**
     * 负责人姓名
     */
	private String chargePersonName;
    /**
     * 手机号码
     */
	private String phoneNumber;
    /**
     * 门店详细地址
     */
	private String detailedAddress;
    /**
     * 门店地址经度
     */
	private BigDecimal geographyLongitude;
    /**
     * 门面地址纬度
     */
	private BigDecimal geographyLatitude;
    /**
     * 门店账号
     */
	private String storeUserCode;
    /**
     * 门店密码
     */
	private String storeUserPassword;
    /**
     * 电话区号
     */
	private String telAreaCode;
    /**
     * 电话号码
     */
	private String telNumber;
    /**
     * 门店地址省编码
     */
	private String provinceCode;
    /**
     * 门店地址市编码
     */
	private String cityCode;
    /**
     * 业务区域一级编码
     */
	private String buzArea1Code;
    /**
     * 业务区域二级编码
     */
	private String buzArea2Code;
    /**
     * 检查项结算折扣率
     */
	private String inspectDiscount;
    /**
     * 检查项工作日最大预约人数
     */
	private Integer maxCountOfDay;
    /**
     * 门店banner
     */
	private String banner;
    /**
     * 门店照片1
     */
	private String pic1;
    /**
     * 门店照片2
     */
	private String pic2;
    /**
     * 门店照片3
     */
	private String pic3;
    /**
     * 门店照片4
     */
	private String pic4;
    /**
     * 体检须知
     */
	private String medicalNoticeDesc;
    /**
     * 工作日,逗号分隔符
     */
	private String workDays;
    /**
     * 开始时间1
     */
	private String startTime1;
    /**
     * 结束时间1
     */
	private String endTime1;
    /**
     * 开始时间2
     */
	private String startTime2;
    /**
     * 结束时间2
     */
	private String endTime2;
    /**
     * 患者注册链接地址
     */
	private String patientRegisterCode;
	private Date createTime;
	private String createUserCode;
	private String createUserName;
	private Date updateTime;
	private String updateUserCode;
	private String updateUserName;
	private String version;
	private String status;


}
