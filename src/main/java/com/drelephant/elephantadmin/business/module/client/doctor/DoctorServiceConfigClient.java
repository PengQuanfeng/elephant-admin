package com.drelephant.elephantadmin.business.module.client.doctor;

import com.drelephant.framework.base.common.R;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/**
 * @author admin
 */
@FeignClient("doctor")
public interface DoctorServiceConfigClient {

    /**
     * updateAverage.
     *
     * @param code
     * @param averageTimeCode
     * @param averageTimeName
     * @return
     */
    @PostMapping("/doctorServiceConfig/updateAverage")
    R updateAverage(Map<String, String> map);

}
