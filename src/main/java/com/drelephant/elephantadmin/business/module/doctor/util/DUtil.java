package com.drelephant.elephantadmin.business.module.doctor.util;

import com.baomidou.mybatisplus.plugins.Page;
import com.drelephant.framework.base.common.R;
import org.apache.commons.lang.StringUtils;
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

    public static boolean isAnyBlank(String... strs) {
        if (strs == null || strs.length == 0) {
            return true;
        }
        for (String str : strs) {
            if (StringUtils.isBlank(str)) {
                return true;
            }
        }

        return false;
    }


    public static boolean isOk(R r) {
        if (r == null) {
            return false;
        }
        if (StringUtils.equals(r.get("code").toString(), "0")) {
            return true;
        }
        return false;
    }

}
