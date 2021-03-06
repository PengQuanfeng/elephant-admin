package com.drelephant.elephantadmin.business.module.patient.service;

import com.drelephant.elephantadmin.business.module.client.patient.PatientClient;
import com.drelephant.elephantadmin.business.module.doctor.util.DUtil;
import com.drelephant.framework.base.common.R;
import lombok.val;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nonnull;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author hyf
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientClient patientClient;

    @Override
    public R regPatientForWeb(Map<String, String> data) {
        val phoneNumber = data.get("phoneNumber");
        val password = data.get("password");
        val storeCode = data.get("storeCode");
        val storeName = data.get("storeName");

        if (DUtil.isAnyBlank(password, phoneNumber)) {
            return R.error("手机号或密码无效");
        }
        if (StringUtils.length(phoneNumber) > 16) {
            return R.error("手机号码太长");
        }
        if (StringUtils.isNotBlank(storeCode) && StringUtils.isBlank(storeName)) {
            return R.error("选择门店后, 门店名称为必须参数");
        }

        //1.注册账号 --todo 没有接口
        val now = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());

        val authOk = true;
        if (!authOk) {
            return R.error("账号注册失败");
        }// 这个应该注册中心返回给我.
        final String userCode = phoneNumber;
        //2. 插入患者信息., 需要传入参数: userCode,phoneNumber,
        // storeCode,storeName,registerTime,registerSourceCode,registerSourceName

        Map<String, String> patientInfo = new HashMap<>();
        patientInfo.put("userCode", userCode);
        patientInfo.put("phoneNumber", phoneNumber);
        patientInfo.put("storeCode", storeCode);
        patientInfo.put("storeName", storeName);
        patientInfo.put("registerTime", now);
        patientInfo.put("registerSourceCode", "WEBH5");
        patientInfo.put("registerSourceName", "网页H5");
        final R patientApiR = patientClient.addPatientForAdminApi(patientInfo);
        if (DUtil.isOk(patientApiR)) {
            return patientApiR;
        } else {
            //5 失败的话 ,回滚账号.
            return R.error("用户信息插入失败-开发中" + patientApiR.get("msg"));
        }
    }

    @Override
    public R resetUserPasswordForAdmin(@Nonnull String userCode) {
        //todo 并没有重置密码的接口
        boolean isOk = new Random().nextInt(10) > 5;
        if (isOk) {
            return R.ok();
        }
        return R.error("密码重置失败");
    }

}
