package com.drelephant.elephantadmin.business.module.client.database;

import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import club.zhcs.common.Result;

@FeignClient("basedata1")
public interface BdAreaRegionClient {
	
	@RequestMapping(
			value="/bdAreaRegion/deleteBdAreaRegion",
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Result deleteBdAreaRegion(Map<String, String> map);
}
