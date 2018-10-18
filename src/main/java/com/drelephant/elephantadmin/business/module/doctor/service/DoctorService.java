package com.drelephant.elephantadmin.business.module.doctor.service;

import com.drelephant.elephantadmin.business.module.doctor.util.DoctorInfoVo;
import com.drelephant.framework.base.common.R;

import javax.annotation.Nonnull;

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
     *
     * @param doctorInfoVo
     * @return
     */
    R updateDoctorInfo(@Nonnull DoctorInfoVo doctorInfoVo);

}

