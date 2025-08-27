package com.ruoyi.web.service;

import com.ruoyi.web.entity.BntWebConfig;

import java.util.List;

/**
 * 会员业务层
 */
public interface IWebConfigService {
    /**
     * 根据条件分页查询充值配置
     *
     * @param
     * @return 用户信息集合信息
     */
    public List<BntWebConfig> loadConfig(BntWebConfig bntWebConfig);

    /**
     * 根据条件分页查询充值配置
     *
     * @param
     * @return 用户信息集合信息
     */
    public BntWebConfig saveConfig(BntWebConfig bntWebConfig);

}
