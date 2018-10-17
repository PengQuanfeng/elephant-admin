package com.drelephant.elephantadmin.business.elephantadmin.client;

import java.util.HashMap;
import java.util.Map;

import org.nutz.log.Log;
import org.nutz.log.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class HospitalClient {
	private static final Log logger = Logs.get();
	
    @Autowired
    private RestTemplate restTemplate;
    
    public boolean deleteHospital(String orgCode) {
    	try {
        	HttpHeaders headers = new HttpHeaders();
        	headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        	ObjectMapper mapper = new ObjectMapper();
        	Map<String, String> params= new HashMap<String, String>();
        	params.put("code", orgCode);
        	String value = mapper.writeValueAsString(params);
        	HttpEntity<String> requestEntity = new HttpEntity<String>(value, headers);

        	String url = "http://basedata/bdOrg/deleteOneHosStatus";
    		if (logger.isDebugEnabled()) {
    			logger.debug("调用接口: " + url + ", 提交的参数: " + params);
    		}
    		String returnedValues = restTemplate.postForEntity(url, requestEntity, String.class).getBody();
    		if (logger.isDebugEnabled()) {
    			logger.debug("接口返回值: " + returnedValues);
    		}
    		return "true".equalsIgnoreCase(returnedValues);
    	} catch (Exception e) {
    		throw new RuntimeException(e);
    	}
    }
}
