package com.drelephant.elephantadmin.business.module.client.store;

import com.baomidou.mybatisplus.plugins.Page;
import com.drelephant.elephantadmin.business.module.doctor.util.StoreInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hyf
 */
@FeignClient("store")
public interface StoreInfoClient {

    /**
     * @param codes
     * @param current
     * @param pageSize
     * @return
     */
    @GetMapping("/storeInfo/pageByCodeNotInApi")
    Page<StoreInfo> pageByCodeNotInApi(@RequestParam("codes") String codes, @RequestParam("current") int current, @RequestParam("pageSize") int pageSize);
}
