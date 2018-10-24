package com.drelephant.elephantadmin.business.module.store.dto.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhou.fan
 * @date 2018/10/24 14:17
 * @description
 */
@ApiModel
public class StorePkgAndDeptQueryRequest {
    @ApiModelProperty(value = "类型（JY/JC）",required = true)
    private String categoryCode;
    @ApiModelProperty("门店编码")
    private String storeCode;

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
}
