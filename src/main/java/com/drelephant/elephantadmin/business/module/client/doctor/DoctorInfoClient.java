package com.drelephant.elephantadmin.business.module.client.doctor;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author xxf
 */
@FeignClient("doctor")
public interface DoctorInfoClient {

    /**
     * check 医院是否被医生使用.
     *
     * @param map {"orgCode":"0001"}
     * @return boolean
     */
    @RequestMapping(value = "/doctorInfo/isOrgUsed", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    boolean checkDoctors(Map<String, String> map);

    /**
     * listDoctorUnLinkedStoreCode.
     *
     * @param doctorCode doctorCode
     * @return
     */
    @GetMapping("/doctorStoreConfig/listDoctorUnLinkedStoreCode")
    List<String> listDoctorUnLinkedStoreCode(@RequestParam("doctorCode") String doctorCode);
}
