package com.drelephant.elephantadmin.business.module.client.database;

import club.zhcs.common.Result;
import com.drelephant.elephantadmin.business.module.doctor.util.Dictionary;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient("basedata")
public interface BdOrgClient {

    @RequestMapping(
            value = "/bdOrg/deleteOneHosStatus",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    Result deleteHospital(Map<String, String> map);


    /**
     * 字典- 根据类型查询list
     *
     * @param typeCode typeCode
     * @return list
     */
    @GetMapping("/bdDictValue/selectByTypeCodeApi")
    List<Dictionary> listDicByTypeCodeApi(@RequestParam("typeCode") String typeCode);

    /**
     * 字典-  根据code查对象
     *
     * @param code code
     * @return dic
     */

    @GetMapping("/bdDictValue/selectByCodeApi")
    Dictionary selectDicByCodeApi(@RequestParam("code") String code);

    /**
     * 字典 - 根据parentCode 查list.
     *
     * @param parentCode
     * @return
     */

    @GetMapping("/bdDictValue/listByParentCodeApi")
    List<Dictionary> listDicByParentCodeApi(@RequestParam("parentCode") String parentCode);

}
