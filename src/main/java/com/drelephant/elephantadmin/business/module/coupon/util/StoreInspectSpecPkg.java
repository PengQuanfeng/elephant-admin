package com.drelephant.elephantadmin.business.module.coupon.util;

import lombok.Data;

import java.io.Serializable;
@Data
public class StoreInspectSpecPkg implements Serializable {
    /**
     * 专项检查包名称
     */
    private String name;
    /**
     * 专项检查包编码
     */
    private String code;

}
