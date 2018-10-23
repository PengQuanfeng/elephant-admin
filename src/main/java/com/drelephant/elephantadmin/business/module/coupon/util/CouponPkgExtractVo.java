package com.drelephant.elephantadmin.business.module.coupon.util;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 券码提取vo.
 */
@Data
public class CouponPkgExtractVo implements Serializable {

    /**
     * 券码包编码
     */
    @NotNull(message = "pkgCode 包编码必填")
    private String pkgCode;
    /**
     * 券码包名称
     */
    @NotNull(message = "pkgCode 包名称必填")
    private String pkgName;
    /**
     * 提取类型
     */
    // USR BIZ SMS
    private String extractType;
    /**
     * 提取批次号
     */
    private String extractNumber;
    /**
     * 提取数量
     */
    @NotNull(message = "extractCount 提取数量必填")
    private Integer extractCount;
    /**
     * 提取时间
     */
    private Date extractTime;
    /**
     * 渠道编码
     */
    @NotNull(message = "channelCode 渠道编码必填")
    private String channelCode;
    /**
     * 销售人员编码
     */
    private String salesmanCode;
    /**
     * 销售人员名称
     */
    @NotNull(message = "salesmanName 销售人必填")
    private String salesmanName;
    /**
     * 接收手机号码
     */
    private String receivePhoneNumber;
    /**
     * 绑定激活手机标识
     */
    // Y  N
    private String isBindingPhone;

    /**
     * 提取内容
     */
    private String extractContent;
    /**
     * 接收用户编码
     */
    private String receiveUserCode;
    /**
     * 成本
     */
    private BigDecimal costPrice;
    /**
     * 销售价格
     */
    @NotNull(message = "sellingPrice 销售价格必填")
    private BigDecimal sellingPrice;
    /**
     * 备注
     */
    @Length(max = 200, message = "remark 备注最大200字")
    private String remark;

    //---vo--
    // vo 生产短信内容.
    private String smsContent;

    /**
     * vo
     * 接收人身份证
     */
    private String receiverIdCardNum;
    /**
     * vo
     * 接收人姓名
     */
    private String receiverName;

}
