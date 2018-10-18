package com.drelephant.elephantadmin.business.module.doctor.service;

import com.drelephant.framework.base.common.R;

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


}

