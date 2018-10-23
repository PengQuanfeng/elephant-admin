package com.drelephant.elephantadmin.business.module.client.inspect;

import com.drelephant.elephantadmin.business.module.store.dto.response.InspectItemAndDeptListResponse;
import com.drelephant.elephantadmin.business.module.util.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

/**
 * @author zhou.fan
 * @date 2018/10/23 10:41
 * @description
 */
@FeignClient(value = "inspect")
public interface InspectItemClient {
    /**
     * 获取所有的科室以及组套
     * @return
     */
    @GetMapping("inspectItem/getAllItemAndDept")
    Result<List<InspectItemAndDeptListResponse>> getAllItemAndDept();
}
