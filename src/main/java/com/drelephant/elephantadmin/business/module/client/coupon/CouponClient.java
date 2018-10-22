package com.drelephant.elephantadmin.business.module.client.coupon;

import com.drelephant.elephantadmin.business.module.coupon.CouponLimitVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("coupon")
public interface CouponClient {

    @GetMapping("/couponLimit/listByCouponInfoCodeApi")
    List<CouponLimitVo> listByCouponInfoCodeApi(@RequestParam("couponInfoCode") String couponInfoCode);

}
