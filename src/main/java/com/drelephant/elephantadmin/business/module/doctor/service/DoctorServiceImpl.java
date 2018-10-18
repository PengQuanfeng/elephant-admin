package com.drelephant.elephantadmin.business.module.doctor.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.drelephant.elephantadmin.business.module.client.database.BdOrgClient;
import com.drelephant.elephantadmin.business.module.client.doctor.DoctorInfoClient;
import com.drelephant.elephantadmin.business.module.client.store.StoreInfoClient;
import com.drelephant.elephantadmin.business.module.doctor.util.DUtil;
import com.drelephant.elephantadmin.business.module.doctor.util.Dictionary;
import com.drelephant.elephantadmin.business.module.doctor.util.DoctorInfoVo;
import com.drelephant.framework.base.common.R;
import lombok.val;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hanyf
 */
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private StoreInfoClient storeInfoClient;
    @Autowired
    private DoctorInfoClient doctorInfoClient;
    @Autowired
    private BdOrgClient bdOrgClient;

    @Override
    public R pageDoctorLinkedStore(String doctorCode, Integer current, Integer pageSize) {
        final Page page = DUtil.createPage(current, pageSize);
        //1.首先, 查询出未关联的门店
        final List<String> unStoreList = doctorInfoClient.listDoctorUnLinkedStoreCode(doctorCode);
        String unCodes = "";
        if (!unStoreList.isEmpty()) {
            unCodes = StringUtils.join(unStoreList, ",");
        } else {
            unCodes = "00";
        }
        unStoreList.clear();
        //2.查询所有门店 not in 的 , page分页
        final Page storeInfoPage = storeInfoClient.pageByCodeNotInApi(unCodes, page.getCurrent(), page.getSize());
        return R.ok().put("total", storeInfoPage.getTotal()).put("list", storeInfoPage.getRecords());
    }

    @Override
    public R updateDoctorInfo(@Nonnull DoctorInfoVo doctorInfoVo) {

        doctorInfoVo.setCityName(getName(doctorInfoVo.getCityCode()));
        doctorInfoVo.setCountyName(getName(doctorInfoVo.getCountyCode()));
        doctorInfoVo.setDeptName(getName(doctorInfoVo.getDeptCode()));
        doctorInfoVo.setProvinceName(getName(doctorInfoVo.getProvinceCode()));
        doctorInfoVo.setOrgName(getName(doctorInfoVo.getOrgCode()));
        doctorInfoVo.setDoctorTitleName(getName(doctorInfoVo.getDoctorTitleCode()));
        doctorInfoVo.setBankCityName(getName(doctorInfoVo.getBankCityCode()));
        doctorInfoVo.setBankProvinceName(getName(doctorInfoVo.getBankProvinceCode()));

        return doctorInfoClient.updateDocInfoApi(doctorInfoVo);
    }

    @Override
    public R addDoctor(@Nonnull Map<String, String> map) {
        //
        final String phoneNumber = map.get("phoneNumber");
        final String password = map.get("password");
        final String recommendUserId = map.get("recommendUserId");

        //1. 账号新增 //todo 还没有注册接口.
        val now = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        val isAuthOk = true;
        if (!isAuthOk) {
            return R.error("账号注册失败-TODO-待开发");
        }
        //2.获取到专属code.
        val doctorCode = phoneNumber;
        //3.插入医生
        Map<String, String> docMap = new HashMap<>();
        docMap.put("doctorCode", doctorCode);
        docMap.put("recommendUserId", "");
        docMap.put("registerSourceCode", "WEBH5");
        docMap.put("registerSourceName", "网页H5");
        docMap.put("registerTime", now);
        final R doctorApiR = doctorInfoClient.addDoctorApi(docMap);
        //4 成功, 返回即可
        if (DUtil.isOk(doctorApiR)) {
            return doctorApiR;
        } else {
            //5 失败的话 ,回滚账号.
            return R.error("医生信息插入失败, 回滚账号系统-开发中");
        }
    }

    /**
     * 根据字典
     *
     * @param dicCode
     * @return
     */
    public String getName(@Nullable String dicCode) {
        if (StringUtils.isBlank(dicCode)) {
            return "";
        }
        final Dictionary dic = bdOrgClient.selectDicByCodeApi(dicCode);
        return dic != null ? dic.getName() : "";
    }

}

