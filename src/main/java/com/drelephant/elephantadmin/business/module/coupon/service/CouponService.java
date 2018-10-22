package com.drelephant.elephantadmin.business.module.coupon.service;

import com.drelephant.elephantadmin.business.module.coupon.CouponLimitVo;

import java.util.List;

public interface CouponService {

    List<CouponLimitVo> listByCouponInfoCode(String couponInfoCode);


}
