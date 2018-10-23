package com.drelephant.elephantadmin.business.module.client.coupon;

import com.drelephant.elephantadmin.business.module.coupon.CouponLimitVo;
import com.drelephant.elephantadmin.business.module.coupon.util.CouponPkgExtractVo;
import com.drelephant.framework.base.common.R;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 优惠券.
 *
 * @author yf
 */
@FeignClient("coupon")
public interface CouponClient {

    /**
     * @param couponInfoCode
     * @return
     */
    @GetMapping("/couponLimit/listByCouponInfoCodeApi")
    List<CouponLimitVo> listByCouponInfoCodeApi(@RequestParam("couponInfoCode") String couponInfoCode);

    /**
     * 优惠券: 添加提取记录.
     * check: CouponPkgExtractVo 只要!=null即可
     *
     * @param vo
     * @return
     */
    @PostMapping("/couponPkgExtract/extract")
    R extract(@RequestBody CouponPkgExtractVo vo);

}
