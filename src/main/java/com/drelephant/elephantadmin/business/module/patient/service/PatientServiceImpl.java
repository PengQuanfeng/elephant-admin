package com.drelephant.elephantadmin.business.module.patient.service;

import com.drelephant.elephantadmin.business.module.client.database.BdOrgClient;
import com.drelephant.elephantadmin.business.module.doctor.util.DUtil;
import com.drelephant.framework.base.common.R;
import lombok.val;
import lombok.var;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author hyf
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired

    private BdOrgClient bdOrgClient;

    @Override
    public R regPatientForWeb(Map<String, String> data) {
        val phoneNumber = data.get("phoneNumber");
        val password = data.get("password");
        val storeCode = data.get("storeCode");

        if (DUtil.isAnyBlank(password, phoneNumber)) {
            return R.error("手机号或密码无效");
        }

        //1.注册账号 --todo 没有接口
        val authOk = true;
        if (!authOk) {
            return R.error("账号注册失败");
        }
        //2. 插入患者信息.
        var storeName = "";
        if(StringUtils.isNotBlank(storeCode)){
            //todo 还没有..
            storeName = "注册门店名称-开发中";
        }




        return null;
    }
}
