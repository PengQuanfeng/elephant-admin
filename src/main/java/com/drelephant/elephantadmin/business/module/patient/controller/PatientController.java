package com.drelephant.elephantadmin.business.module.patient.controller;

import com.drelephant.elephantadmin.business.module.doctor.util.DUtil;
import com.drelephant.elephantadmin.business.module.patient.service.PatientService;
import com.drelephant.framework.base.common.R;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author admin
 */
@RestController
@RequestMapping("patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    /**
     * @param data
     * @return
     */
    @PostMapping("/addPattientAccount")
    public R regPatientForWeb(@RequestBody Map<String, String> data) {

        return null;
    }


}
