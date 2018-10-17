package com.drelephant.elephantadmin.business.elephantadmin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drelephant.elephantadmin.business.elephantadmin.client.DoctorClient;
import com.drelephant.elephantadmin.business.elephantadmin.client.HospitalClient;
import com.drelephant.elephantadmin.business.elephantadmin.service.HospitalService;
import com.drelephant.framework.base.common.R;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	DoctorClient doctorClient;
	
	@Autowired
	HospitalClient hospitalClient;
	
	@Override
//	@Transactional
	public R deleteHospital(String orgCode) {
		if (!doctorClient.checkDoctors(orgCode)) {
			// 删除 医院
			if (hospitalClient.deleteHospital(orgCode)) {
				return R.ok();
			} else {
				return R.error("删除医院信息失败");
			}
		} else {
			return R.error("不允许删除医院，医院下面有医生信息");
		}
		
	}
}
