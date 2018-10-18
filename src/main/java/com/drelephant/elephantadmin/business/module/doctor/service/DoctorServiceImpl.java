package com.drelephant.elephantadmin.business.module.doctor.service;

import com.drelephant.elephantadmin.business.module.client.database.BdOrgClient;
import com.drelephant.elephantadmin.business.module.client.doctor.DoctorInfoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hanyf
 */
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private BdOrgClient bdOrgClient;
    @Autowired
    private DoctorInfoClient doctorInfoClient;


}

