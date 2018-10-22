package com.drelephant.elephantadmin.business.module.client.database;

import club.zhcs.common.Result;
import com.drelephant.elephantadmin.business.module.coupon.util.BdServiceConfig;
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

    /**
     * api- codeStr
     * get请求, 注意数据长度.
     *
     * @param codeStr like 1,2,3
     * @return map ,like {a:哎,b:比}
     */
    @GetMapping("/bdDictValue/mapCodeNameByCodesApi")
    Map<String, String> mapCodeNameByCodesApi(@RequestParam("codeStr") String codeStr);

    /**
     * 查询二级服务列表
     * where serviceCode in codeStr
     * @param codeStr
     * @return
     */
    @GetMapping("/bdServiceConfig/listByCodes2InStrApi")
    public List<BdServiceConfig> listByCodes2InStrApi(@RequestParam("codeStr") String codeStr);
}
