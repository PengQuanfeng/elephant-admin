package com.drelephant.elephantadmin.business.module.coupon.controller;

import com.drelephant.elephantadmin.business.module.coupon.CouponLimitVo;
import com.drelephant.elephantadmin.business.module.coupon.service.CouponService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "优惠券")
@RestController
@RequestMapping("coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @GetMapping("/listByCouponInfoCode")
    public  List<CouponLimitVo> listByCouponInfoCode(String couponInfoCode) {
        return couponService.listByCouponInfoCode(couponInfoCode);
    }

}
