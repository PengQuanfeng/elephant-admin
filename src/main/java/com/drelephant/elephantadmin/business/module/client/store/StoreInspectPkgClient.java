package com.drelephant.elephantadmin.business.module.client.store;

import com.drelephant.elephantadmin.business.module.store.dto.response.StoreInspectPkgResponse;
import com.drelephant.elephantadmin.business.module.util.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

/**
 * @author zhou.fan
 * @date 2018/10/23 16:21
 * @description
 */
@FeignClient(value = "store")
public interface StoreInspectPkgClient {

    /**
     * 根据门店编码查询
     * @param storeCode 门店编码
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/storeInspectPkg/getPkgByStoreCode")
    Result<List<StoreInspectPkgResponse>> getPkgByStoreCode(@RequestParam("storeCode") String storeCode);
}
