package com.drelephant.elephantadmin.business.module.store.service.impl;

import com.drelephant.elephantadmin.business.module.client.inspect.InspectItemClient;
import com.drelephant.elephantadmin.business.module.client.store.StoreInspectPkgClient;
import com.drelephant.elephantadmin.business.module.store.dto.response.InspectItemAndDeptListResponse;
import com.drelephant.elephantadmin.business.module.store.dto.response.InspectItemAndDeptTreeResponse;
import com.drelephant.elephantadmin.business.module.store.dto.response.StoreInspectPkgResponse;
import com.drelephant.elephantadmin.business.module.store.service.StoreService;
import com.drelephant.elephantadmin.business.module.util.CollectionUtil;
import com.drelephant.elephantadmin.business.module.util.Result;
import com.drelephant.framework.base.common.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhou.fan
 * @date 2018/10/23 10:49
 * @description
 */
@Service
public class StoreServiceImpl implements StoreService {
    private static final Logger LOG = LoggerFactory.getLogger(StoreServiceImpl.class);
    @Autowired
    private InspectItemClient inspectPkgClient;
    @Autowired
    private StoreInspectPkgClient storeInspectPkgClient;

    @Override
    public R getAllPkgAndDept(String storeCode) {
        Result<List<InspectItemAndDeptListResponse>> pKg = inspectPkgClient.getAllItemAndDept();
        if (!pKg.checkCode()) {
            LOG.error("查询科室及组套失败， msg :{}", pKg.getMsg());
            return R.error(pKg.getMsg());
        }
        Result<List<StoreInspectPkgResponse>> pkgByStoreCode = storeInspectPkgClient.getPkgByStoreCode(storeCode);
        if (!pkgByStoreCode.checkCode()) {
            LOG.error("根据门店查询组套失败， msg :{}", pkgByStoreCode.getMsg());
            return R.error(pkgByStoreCode.getMsg());
        }
        List<InspectItemAndDeptListResponse> data = pKg.getData();
        if (CollectionUtils.isEmpty(data)) {
            LOG.warn("当前科室以及组套没有数据。");
            return R.error("当前科室以及组套没有数据");
        }
        List<StoreInspectPkgResponse> pkgByStoreCodeData = pkgByStoreCode.getData();
        Map<String, StoreInspectPkgResponse> storeInspectPkgResponseMap = pkgByStoreCodeData.stream()
                .collect(Collectors.toMap(StoreInspectPkgResponse::getItemCode, Function.identity()));
        data.forEach(c -> {
            StoreInspectPkgResponse storeInspectPkgResponse = storeInspectPkgResponseMap.get(c.getCode());
            if (null != storeInspectPkgResponse) {
                c.setStoreItemCode(storeInspectPkgResponse.getStoreItemCode());
                c.setPrice(storeInspectPkgResponse.getPrice());
            }
        });
        ArrayList<InspectItemAndDeptListResponse> responses = data.parallelStream().collect(
                Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(
                        Comparator.comparing(InspectItemAndDeptListResponse::getDeptCode))), ArrayList::new));

        List<InspectItemAndDeptTreeResponse> inspectItemAndDeptTreeResponses =
                CollectionUtil.copyCollectionAs(responses, InspectItemAndDeptTreeResponse.class);
        Map<String, List<InspectItemAndDeptListResponse>> deptGroup = data.stream()
                .collect(Collectors.groupingBy(InspectItemAndDeptListResponse::getDeptCode));
        inspectItemAndDeptTreeResponses.forEach(c -> c.setInspectItemAndDeptListResponses(deptGroup.get(c.getDeptCode())));
        return R.ok().put("list", inspectItemAndDeptTreeResponses);
    }
}
