package com.drelephant.elephantadmin.business.module.coupon.service;

import com.drelephant.elephantadmin.business.module.client.coupon.CouponClient;
import com.drelephant.elephantadmin.business.module.client.patient.PatientClient;
import com.drelephant.elephantadmin.business.module.coupon.util.CouponPkgExtractVo;
import com.drelephant.elephantadmin.business.module.doctor.util.DUtil;
import com.drelephant.framework.base.common.R;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;

/**
 * CouponServiceImpl.
 *
 * @author yf
 */
@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponClient client;
    @Autowired
    private PatientClient patientClient;

    @Override
    public R extract(CouponPkgExtractVo vo) {
        String phoneNumber = vo.getReceivePhoneNumber();
        if (StringUtils.isNotBlank(phoneNumber)) {
            R r = patientClient.getPatientInfoByCode(phoneNumber);
            Object o = r.get("data");
            if (o != null) {
                LinkedHashMap<String, String> user = (LinkedHashMap<String, String>) o;
                //获取吧亲
                vo.setReceiverName(user.get("userName"));
                vo.setReceiverIdCardNum(user.get("idCardCode"));
                vo.setReceivePhoneNumber(phoneNumber);
                vo.setReceiveUserCode(phoneNumber);
            }
        }
        return client.extract(vo);
    }
}
