package com.drelephant.elephantadmin.business.module.client.store;

import com.baomidou.mybatisplus.plugins.Page;
import com.drelephant.elephantadmin.business.module.doctor.util.StoreInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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


    /**
     * @param storeName
     * @param notInCodesStr
     * @param pageSize
     * @param sqlSelect
     * @return
     */
    @GetMapping("/storeInfo/listForAdminAppByStoreNameCodeNotInApi")
    List<StoreInfo> listForAdminAppByStoreNameCodeNotInApi(@RequestParam("storeName") String storeName, @RequestParam("notInCodesStr") String notInCodesStr, @RequestParam("pageSize") Integer pageSize, @RequestParam("sqlSelect") String sqlSelect);

    /**
     * @param codeStr
     * @param sqlSelect
     * @return
     */
    @GetMapping("/storeInfo/listByCodeInApi")
    List<StoreInfo> listByCodeInApi(@RequestParam("codeStr") String codeStr,@RequestParam("sqlSelect") String sqlSelect);
}
