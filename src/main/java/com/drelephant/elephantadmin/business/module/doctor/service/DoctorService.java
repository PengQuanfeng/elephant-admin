package com.drelephant.elephantadmin.business.module.doctor.service;

import com.drelephant.elephantadmin.business.module.doctor.util.DoctorInfoVo;
import com.drelephant.elephantadmin.business.module.doctor.util.StoreInfo;
import com.drelephant.framework.base.common.R;

import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;

/**
 * @author hanyf
 */
public interface DoctorService {

    /**
     * 获取医生未关联门店列表,分页
     *
     * @param doctorCode
     * @param current
     * @param pageSize
     * @return
     */
    R pageDoctorLinkedStore(String doctorCode, Integer current, Integer pageSize);

    /**
     * @param doctorInfoVo
     * @return
     */
    R updateDoctorInfo(@Nonnull DoctorInfoVo doctorInfoVo);

    /**
     * @param map
     * @return
     */
    R addDoctor(@Nonnull Map<String, String> map);

    /**
     * @param pageName
     * @param storeName
     * @param doctorCode
     * @return
     */
    List<StoreInfo> listStoreForService(String pageName, String storeName, String doctorCode);


}

