package com.drelephant.elephantadmin.business.module.doctor.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.drelephant.elephantadmin.business.module.client.doctor.DoctorInfoClient;
import com.drelephant.elephantadmin.business.module.client.store.StoreInfoClient;
import com.drelephant.elephantadmin.business.module.doctor.util.DUtil;
import com.drelephant.framework.base.common.R;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hanyf
 */
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private StoreInfoClient storeInfoClient;
    @Autowired
    private DoctorInfoClient doctorInfoClient;

    @Override
    public R pageDoctorLinkedStore(String doctorCode, Integer current, Integer pageSize) {
        final Page page = DUtil.createPage(current, pageSize);
        //1.首先, 查询出未关联的门店
        final List<String> unStoreList = doctorInfoClient.listDoctorUnLinkedStoreCode(doctorCode);
        String unCodes = "";
        if (!unStoreList.isEmpty()) {
            unCodes = StringUtils.join(unStoreList, ",");
        } else {
            unCodes = "00";
        }
        unStoreList.clear();
        //2.查询所有门店 not in 的 , page分页
        final Page storeInfoPage = storeInfoClient.pageByCodeNotInApi(unCodes, page.getCurrent(), page.getSize());
        return R.ok().put("total", storeInfoPage.getTotal()).put("list", storeInfoPage.getRecords());
    }

}

