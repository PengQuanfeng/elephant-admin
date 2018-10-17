package com.drelephant.elephantadmin.business.module.client.doctor;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("doctor")
public interface DoctorInfoClient {
	
	@RequestMapping(
			value="/doctorInfo/isOrgUsed",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public boolean checkDoctors(Map<String, String> map);
}
