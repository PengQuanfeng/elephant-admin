package com.drelephant.elephantadmin.business.module.doctor.util;

import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 数据字典类
 * </p>
 *
 * @author com.drelephant
 * @since 2018-10-09
 */

@Data
public class Dictionary implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 类型编码
     */
    private String typeCode;
    /**
     * 值
     */
    private String value;
    /**
     * 父级编码
     */
    private String parentCode;
    /**
     * 描述
     */
    private String description;

}
