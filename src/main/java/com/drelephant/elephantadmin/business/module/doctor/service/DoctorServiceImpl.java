package com.drelephant.elephantadmin.business.module.doctor.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.drelephant.elephantadmin.business.module.client.database.BdOrgClient;
import com.drelephant.elephantadmin.business.module.client.doctor.DoctorInfoClient;
import com.drelephant.elephantadmin.business.module.client.store.StoreInfoClient;
import com.drelephant.elephantadmin.business.module.doctor.util.DUtil;
import com.drelephant.elephantadmin.business.module.doctor.util.Dictionary;
import com.drelephant.elephantadmin.business.module.doctor.util.DoctorInfoVo;
import com.drelephant.framework.base.common.R;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

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

    /**
     * 根据字典
     * @param dicCode
     * @return
     */
    public  String getName(@Nullable String dicCode) {
        if (StringUtils.isBlank(dicCode)) {
            return "";
        }
        final Dictionary dic = bdOrgClient.selectDicByCodeApi(dicCode);
        return dic != null ? dic.getName() : "";
    }

}

