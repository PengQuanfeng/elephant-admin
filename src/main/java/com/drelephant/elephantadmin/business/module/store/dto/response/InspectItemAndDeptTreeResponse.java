package com.drelephant.elephantadmin.business.module.store.dto.response;

import java.util.List;

/**
 * @author zhou.fan
 * @date 2018/10/23 16:07
 * @description
 */
public class InspectItemAndDeptTreeResponse {
    /**
     * 科室编码
     */
    private String deptCode;
    /**
     * 科室名称
     */
    private String deptName;

    private List<InspectItemAndDeptListResponse> inspectItemAndDeptListResponses;

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

    public List<InspectItemAndDeptListResponse> getInspectItemAndDeptListResponses() {
        return inspectItemAndDeptListResponses;
    }

    public void setInspectItemAndDeptListResponses(List<InspectItemAndDeptListResponse> inspectItemAndDeptListResponses) {
        this.inspectItemAndDeptListResponses = inspectItemAndDeptListResponses;
    }
}
