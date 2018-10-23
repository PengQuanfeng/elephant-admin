package com.drelephant.elephantadmin.business.module.store.service;

import com.drelephant.framework.base.common.R;

/**
 * @author zhou.fan
 * @date 2018/10/23 10:49
 * @description
 */
public interface StoreService {
    /**
     * 获取所有的科室以及组套
     * @param type
     * @return
     */
    R getAllPkgAndDept(String storeCode);
}
