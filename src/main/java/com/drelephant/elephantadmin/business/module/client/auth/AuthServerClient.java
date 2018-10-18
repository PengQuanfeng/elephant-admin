package com.drelephant.elephantadmin.business.module.client.auth;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * @author hyf
 */
@FeignClient("authserver")
public interface AuthServerClient {

    //TODO 还没有.

}
