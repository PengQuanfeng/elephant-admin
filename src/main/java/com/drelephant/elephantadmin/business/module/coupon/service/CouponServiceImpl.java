package com.drelephant.elephantadmin.business.module.coupon.service;

import com.drelephant.elephantadmin.business.module.client.coupon.CouponClient;
import com.drelephant.elephantadmin.business.module.client.database.BdOrgClient;
import com.drelephant.elephantadmin.business.module.client.store.StoreInfoClient;
import com.drelephant.elephantadmin.business.module.coupon.CouponLimitVo;
import com.drelephant.elephantadmin.business.module.coupon.util.BdServiceConfig;
import com.drelephant.elephantadmin.business.module.doctor.util.StoreInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponClient couponClient;
    @Autowired
    private StoreInfoClient storeInfoClient;
    @Autowired
    private BdOrgClient bdOrgClient;

    @Override
    public List<CouponLimitVo> listByCouponInfoCode(String couponInfoCode) {
        if (StringUtils.isBlank(couponInfoCode)) {
            return Collections.emptyList();
        }
        //1.先查出来limit list
        final List<CouponLimitVo> limitList = couponClient.listByCouponInfoCodeApi(couponInfoCode);
        if (limitList.isEmpty()) {
            return limitList;
        }
        //2.store
        StringBuilder sb = new StringBuilder();
        limitList.forEach(v -> {
            if (StringUtils.isNotBlank(v.getStores())) {
                sb.append(v.getStores()).append(",");
                String[] storeCodeArr = StringUtils.split(v.getStores(), ",");
                List<StoreInfo> storeInfoList = v.getStoreInfoList();
                for (String s : storeCodeArr) {
                    StoreInfo storeInfo = new StoreInfo();
                    storeInfo.setCode(s);
                    storeInfoList.add(storeInfo);
                }
            }
        });
        String storeCodeStr = sb.toString();
        if (StringUtils.isNotBlank(storeCodeStr)) {
            List<StoreInfo> storeInfoList = storeInfoClient.listByCodeInApi(storeCodeStr, "code,name");
            if (!storeInfoList.isEmpty()) {
                limitList.forEach(v -> {
                    List<StoreInfo> storeInfoList1 = v.getStoreInfoList();
                    storeInfoList1.forEach(v1 -> {
                        for (StoreInfo storeInfo : storeInfoList) {
                            if (StringUtils.equals(v1.getCode(), storeInfo.getCode())) {
                                v1.setName(storeInfo.getName());
                            }
                        }
                    });
                });
            }
        }
        //3. 子服务
        StringBuilder sb2 = new StringBuilder();
        limitList.forEach(v -> {
            if (StringUtils.isNotBlank(v.getServiceCode())) {
                sb2.append(v.getServiceCode()).append(",");
                String[] split = v.getServiceCode().split(",");
                List<BdServiceConfig> serviceConfigList = v.getBdServiceConfigList();
                for (String s : split) {
                    BdServiceConfig c = new BdServiceConfig();
                    c.setServiceCode(s);
                    serviceConfigList.add(c);
                }
            }
        });
        String serviceCodeStr = sb2.toString();
        if (StringUtils.isNotBlank(serviceCodeStr)) {
            //根据service查名称
            List<BdServiceConfig> serviceList = bdOrgClient.listByCodes2InStrApi(serviceCodeStr);
            if (serviceList.isEmpty()) {
                limitList.forEach(l -> {
                    List<BdServiceConfig> bdServiceConfigList = l.getBdServiceConfigList();
                    bdServiceConfigList.forEach(b -> {
                        for (BdServiceConfig bd : serviceList) {
                            if (StringUtils.equals(b.getServiceCode(), bd.getServiceCode())) {
                                b.setServiceName(bd.getServiceName());
                            }
                        }
                    });
                });
            }

        }
        //4检查
        StringBuilder sb3 = new StringBuilder();
        limitList.forEach(v->{
            String inspects = v.getInspects();
            if(StringUtils.isNotBlank(inspects)){

            }
        });
        return limitList;
    }
}
