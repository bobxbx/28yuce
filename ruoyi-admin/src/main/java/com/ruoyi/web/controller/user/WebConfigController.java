package com.ruoyi.web.controller.user;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.web.entity.BntWebConfig;
import com.ruoyi.web.service.IWebConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户信息
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/defi/webConfig")
public class WebConfigController extends BaseController {
    @Autowired
    private IWebConfigService iWebConfigService;
    /**
     * 载入配置内容
     */
    @PostMapping("/loadConfig")
    public AjaxResult loadConfig(BntWebConfig bntWebConfig)
    {

        List<BntWebConfig> bntWebConfigs = iWebConfigService.loadConfig(bntWebConfig);
        return success(bntWebConfigs);
    }
    /**
     * 保存配置内容
     */
    @PostMapping("/saveConfig")
    public AjaxResult saveConfig(@RequestBody BntWebConfig bntWebConfig)
    {

        return success(iWebConfigService.saveConfig(bntWebConfig));

    }

}
