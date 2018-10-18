package com.drelephant.elephantadmin.business.module.patient.service;

import com.drelephant.framework.base.common.R;

import java.util.Map;

/**
 * @author hyf
 */
public interface PatientService {


    R regPatientForWeb(Map<String, String> data);
}
