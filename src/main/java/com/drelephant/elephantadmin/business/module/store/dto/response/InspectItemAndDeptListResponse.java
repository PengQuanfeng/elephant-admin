package com.drelephant.elephantadmin.business.module.store.dto.response;

import org.apache.commons.lang3.StringUtils;
import java.math.BigDecimal;

/**
 * @author zhou.fan
 * @date 2018/10/23 14:02
 * @description
 */
public class InspectItemAndDeptListResponse {
    /**
     * 项目编码
     */
    private String code;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 品类编码
     */
    private String categoryCode;
    /**
     * 品类名称
     */
    private String categoryName;
    /**
     * 科室编码
     */
    private String deptCode;
    /**
     * 科室名称
     */
    private String deptName;

    private String storeItemCode;

    private BigDecimal price;

    private boolean unrelatedStore;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public boolean isUnrelatedStore() {
        return StringUtils.isNotBlank(storeItemCode) && null != price;
    }

    public String getStoreItemCode() {
        return storeItemCode;
    }

    public void setStoreItemCode(String storeItemCode) {
        this.storeItemCode = storeItemCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
