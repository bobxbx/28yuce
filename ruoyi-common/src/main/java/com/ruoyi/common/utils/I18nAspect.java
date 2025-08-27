package com.ruoyi.common.utils;



import com.ruoyi.common.annotation.I18nSwitch;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.exception.ServiceException;

import com.ruoyi.common.utils.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@Aspect
@Component
public class I18nAspect {

    // 若依默认中文配置
    private static final Locale DEFAULT_LOCALE = Locale.SIMPLIFIED_CHINESE;

    @Around("@annotation(i18nSwitch)")
    public Object around(ProceedingJoinPoint joinPoint, I18nSwitch i18nSwitch) throws Throwable {
        // 获取当前请求
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes == null) {
            return joinPoint.proceed(); // 非Web请求直接放行
        }

        HttpServletRequest request = attributes.getRequest();
        Locale originalLocale = LocaleContextHolder.getLocale();

        try {
            // 解析语言设置
            String langHeader = request.getHeader("language");
            Locale targetLocale = parseLocale(langHeader, i18nSwitch.required());

            // 设置临时Locale
            LocaleContextHolder.setLocale(targetLocale);

            return joinPoint.proceed();
        } finally {
            // 恢复原始Locale
            LocaleContextHolder.setLocale(originalLocale);
        }
    }

    private Locale parseLocale(String langHeader, boolean required) {
        if (StringUtils.isEmpty(langHeader)) {
            if (required) {
                throw new ServiceException("language header required", 400);
            }
            return DEFAULT_LOCALE;
        }

        switch (langHeader.toLowerCase()) {
            case "en":
                return Locale.ENGLISH;
            case "cn":
                return Locale.SIMPLIFIED_CHINESE;
            case "es":
                return new Locale("es", "ES");
            case "ru":
                return new Locale("ru", "RU");
            case "zh":
                return Locale.TRADITIONAL_CHINESE;
            default:
                if (required) {
                    throw new ServiceException("unsupported language: " + langHeader, 400);
                }
                return DEFAULT_LOCALE;
        }
    }
}