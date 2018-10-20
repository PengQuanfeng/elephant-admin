package com.drelephant.elephantadmin.business.module.client.doctor;

import com.drelephant.elephantadmin.business.module.doctor.util.DoctorInfoVo;
import com.drelephant.framework.base.common.R;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    /**
     * updateDocInfoApi
     *
     * @param data
     * @return
     */
    @PostMapping("/doctorInfo/update")
    R updateDocInfoApi(@RequestBody DoctorInfoVo data);


    /**
     * 新增医生, for web管理,
     * 业务调用,不通用.
     * doctorCode,
     * recommendUserId
     * registerSourceCode
     * registerSourceName
     * registerTime
     *
     * @param data
     * @return
     */
    @PostMapping("/doctorInfo/addDoctorApi")
    R addDoctorApi(@RequestBody Map<String, String> data);

    /**
     *
     * @param doctorCode
     * @param storeName
     * @param pageSize
     * @return
     */
    @GetMapping("/doctorStoreConfig/listForAdminAppByDoctorCodeStoreNameApi")
    List listForAdminAppByDoctorCodeStoreNameApi(@RequestParam("doctorCode") String doctorCode, @RequestParam("storeName") String storeName, @RequestParam("pageSize") Integer pageSize);
}
