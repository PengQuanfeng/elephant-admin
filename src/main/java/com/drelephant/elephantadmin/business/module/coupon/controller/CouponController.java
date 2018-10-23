package com.drelephant.elephantadmin.business.module.coupon.controller;

import com.drelephant.elephantadmin.business.module.coupon.service.CouponService;
import com.drelephant.elephantadmin.business.module.coupon.util.CouponPkgExtractVo;
import com.drelephant.framework.base.common.R;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yf
 */
@Api(tags = "优惠券")
@RestController
@RequestMapping("coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    /**
     * 券码记录提取.
     *
     * @param vo
     * @return
     */
    @PostMapping("/extract")
    public R extract(@RequestBody CouponPkgExtractVo vo) {
        return couponService.extract(vo);
    }

}
