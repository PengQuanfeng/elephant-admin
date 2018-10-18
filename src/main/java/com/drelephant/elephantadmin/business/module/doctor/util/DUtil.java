package com.drelephant.elephantadmin.business.module.doctor.util;

import com.baomidou.mybatisplus.plugins.Page;

import javax.annotation.Nullable;

public final class DUtil {

    /**
     * 创建默认page对象
     *
     * @param current
     * @param pageSize
     * @return
     */
    public static Page createPage(@Nullable Integer current, @Nullable Integer pageSize) {
        return new Page<>(current == null ? 1 : current, pageSize == null ? 15 : pageSize);
    }


}
