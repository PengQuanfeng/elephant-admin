package com.drelephant.elephantadmin.business.module.patient.service;

import com.drelephant.framework.base.common.R;

import javax.annotation.Nonnull;
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

    /**
     * 管理员重置指定用户的密码.
     *
     * 权限交由网关check.此处不做校验.
     *
     * @param userCode 账号,医生或者普通用户都行
     * @return R
     */
    R resetUserPasswordForAdmin(@Nonnull String userCode);
}
