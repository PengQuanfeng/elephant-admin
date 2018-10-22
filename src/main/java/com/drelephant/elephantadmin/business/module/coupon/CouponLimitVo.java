package com.drelephant.elephantadmin.business.module.coupon;

import com.drelephant.elephantadmin.business.module.coupon.util.BdServiceConfig;
import com.drelephant.elephantadmin.business.module.coupon.util.StoreInspectSpecPkg;
import com.drelephant.elephantadmin.business.module.doctor.util.StoreInfo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 优惠券限制信息表
 * </p>
 *
 * @author com.drelephant
 * @since 2018-10-09
 */
@Data
public class CouponLimitVo {

    private String id;
    /**
     * 优惠券编码
     */
    private String couponCode;
    /**
     * 限制服务类别编码
     */
    private String serviceCategoryCode;
    /**
     * 限制服务类别名称
     */
    private String serviceCategoryName;
    /**
     * 限制服务类型编码,子
     */
    private String serviceCode;
    /**
     * 限制服务类型名称,子
     */
    private String serviceName;
    /**
     * 限制门店
     */
    private String stores;
    /**
     * 限制药品
     */
    private String drugs;
    /**
     * 限制专项检查
     */
    private String inspects;

    //---vo-----
    /**
     *
     */
    private List<StoreInfo> storeInfoList = new ArrayList<>();
    private List<BdServiceConfig> bdServiceConfigList = new ArrayList<>();
    private List<StoreInspectSpecPkg> storeInspectSpecPkgList=new ArrayList<>();

}
