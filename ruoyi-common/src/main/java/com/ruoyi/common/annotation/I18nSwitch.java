package com.ruoyi.common.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface I18nSwitch {
    /**
     * 是否强制要求请求头包含language
     */
    boolean required() default true;
}