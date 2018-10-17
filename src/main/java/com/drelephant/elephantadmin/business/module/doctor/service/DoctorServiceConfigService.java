package com.drelephant.elephantadmin.business.module.doctor.service;

import com.drelephant.elephantadmin.business.module.client.doctor.DoctorServiceConfigClient;
import com.drelephant.framework.base.common.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hanyf
 */
@Service
public class DoctorServiceConfigService {
    @Autowired
    private DoctorServiceConfigClient doctorServiceConfigClient;

    public R updateAverage(String code, String averageTimeCode) {
        //todo averageTimeName
        String averageTimeName = "0000000000000";

        final Map<String, String> map = new HashMap<>(3);
        map.put("code",code);
        map.put("averageTimeCode",averageTimeCode);
        map.put("averageTimeName",averageTimeName);
        return doctorServiceConfigClient.updateAverage(map);
    }

}

