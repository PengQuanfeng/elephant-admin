package com.drelephant.elephantadmin.business.module.coupon.service;

import com.drelephant.elephantadmin.business.module.coupon.util.CouponPkgExtractVo;
import com.drelephant.framework.base.common.R;

/**
 * CouponService.
 *
 * @author yf
 */
public interface CouponService {

    /**
     * 券码卡提取.
     * <p>
     * 用户模块,获取其身份证,用户名等信息, 然后调用coupon的保存即可
     *
     * @param vo CouponPkgExtractVo
     * @return R
     */
    R extract(CouponPkgExtractVo vo);


}
