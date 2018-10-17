package com.drelephant.elephantadmin.business.module.database.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drelephant.elephantadmin.business.module.client.database.BdOrgClient;
import com.drelephant.elephantadmin.business.module.client.doctor.DoctorInfoClient;
import com.drelephant.elephantadmin.business.module.database.service.HospitalService;
import com.drelephant.framework.base.common.R;

import club.zhcs.common.Result;

@Service
public class HospitalServiceImpl implements HospitalService {
	private static final Log logger = Logs.get();
	
	@Autowired
	DoctorInfoClient doctorInfoClient;
	
	@Autowired
	BdOrgClient bdOrgClient;
	
	@Override
	public R deleteHospital(String orgCode) {
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("orgCode", orgCode);
		if (logger.isDebugEnabled()) {
			logger.debug(map1);
		}
		boolean r1 = doctorInfoClient.checkDoctors(map1);
		if (logger.isDebugEnabled()) {
			logger.debug(r1);
		}
		if (!r1) {
			// 删除 医院
			Map<String, String> map2 = new HashMap<String, String>();
			map2.put("code", orgCode);
			if (logger.isDebugEnabled()) {
				logger.debug(map2);
			}
			Result r2 = bdOrgClient.deleteHospital(map2);
			if (logger.isDebugEnabled()) {
				logger.debug(r2.toString());
			}
			if (r2.isSuccess()) {
				return R.ok();
			} else {
				return R.error("删除医院信息失败");
			}
		} else {
			return R.error("不允许删除医院，医院下面有医生信息");
		}
	}
	
	@Override
	public R checkDoctors(String orgCode) {
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("orgCode", orgCode);
		if (logger.isDebugEnabled()) {
			logger.debug(map1);
		}
		boolean r1 = doctorInfoClient.checkDoctors(map1);
		if (logger.isDebugEnabled()) {
			logger.debug(r1);
		}
		if (r1) {
			return R.ok("医院下面有医生信息");
		} else {
			return R.error(1, "医院下面没有医生信息");
		}
		
	}
}
