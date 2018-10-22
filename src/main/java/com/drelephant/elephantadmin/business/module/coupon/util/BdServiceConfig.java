package com.drelephant.elephantadmin.business.module.coupon.util;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 医疗服务配置表
 * </p>
 *
 * @author com.drelephant
 * @since 2018-10-09
 */
@Data
public class BdServiceConfig implements Serializable {

    private static final long serialVersionUID = 1L;

	private String id;
    /**
     * 服务类别编码(一级)
     */
	private String serviceCategoryCode;
    /**
     * 服务类别名称(一级)
     */
	private String serviceCategoryName;
    /**
     * 服务类型编码(二级)
     */
	private String serviceCode;
    /**
     * 服务类型名称(二级)
     */
	private String serviceName;
    /**
     * 医生服务配置标识
     */
	private String isDocCanConfig;
    /**
     * 用户服务须知
     */
	private String serviceNoticeDesc;
    /**
     * 医生回复限制(条)
     */
	private Integer docReplyLimitCount;
    /**
     * 服务时长限制(小时)
     */
	private String docSerTimeLength;
    /**
     * 开处方标识
     */
	private String isPrescription;
    /**
     * 开检查标识
     */
	private String isInspect;
    /**
     * 次数限制(次)
     */
	private Integer frequencyLimitCount;
    /**
     * 费用必选标识
     */
	private String isCostMandatory;
    /**
     * 加急费用1
     */
	private BigDecimal urgentCost1;
    /**
     * 加急费用2
     */
	private BigDecimal urgentCost2;
    /**
     * 加急费用3
     */
	private BigDecimal urgentCost3;
    /**
     * 医生服务配置标识2
     */
	private String isDocApCanConfig;
    /**
     * 预约服务配置标识
     */
	private String isApCanConfig;
	private Date createTime;
	private String createUserCode;
	private String createUserName;
	private Date updateTime;
	private String updateUserCode;
	private String updateUserName;
	private String version;
	private String status;

}
