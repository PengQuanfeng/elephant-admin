package com.drelephant.elephantadmin.business.module.client.patient;

import com.drelephant.framework.base.common.R;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author hyf
 */
@FeignClient("patient")
public interface PatientClient {

    /**
     * 新增patient,
     * 业务接口.
     *
     * @param data data
     * @return
     */
    @PostMapping("/patientInfo/addPatientForAdminApi")
    R addPatientForAdminApi(@RequestBody Map<String, String> data);

}
