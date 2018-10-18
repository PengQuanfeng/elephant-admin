package com.drelephant.elephantadmin.business.module.doctor.util;

import com.baomidou.mybatisplus.plugins.Page;
import com.drelephant.framework.base.common.R;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.annotation.Nonnull;
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

    /**
     * @param br
     * @return
     */
    public static R brErrorMsg(@Nonnull BindingResult br) {
        ObjectError error = br.getAllErrors().get(0);
        return R.error(error.getObjectName() + error.getDefaultMessage());
    }

}
