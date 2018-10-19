package com.drelephant.elephantadmin.business.module.patient.service;

import com.drelephant.framework.base.common.R;

import java.util.Map;

/**
 * @author hyf
 */
public interface PatientService {

    /**
     * 新增用户, 后台, 注册用户(患者)
     * 业务代码.
     *
     * @param data data
     * @return R
     */
    R regPatientForWeb(Map<String, String> data);
}
