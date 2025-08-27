package com.ruoyi.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.web.controller.mapper.WebConfigMapper;
import com.ruoyi.web.entity.BntWebConfig;
import com.ruoyi.web.service.IWebConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 订单 业务层处理
 * 
 * @author ruoyi
 */
@Service
public class WebConfigServiceImpl implements IWebConfigService
{
    private static final Logger log = LoggerFactory.getLogger(WebConfigServiceImpl.class);
    @Autowired
    WebConfigMapper webConfigMapper;
    @Override
    public List<BntWebConfig> loadConfig(BntWebConfig bntWebConfig) {
        List<BntWebConfig> name = webConfigMapper.selectList(new QueryWrapper<BntWebConfig>());
        return name;
    }

    @Override
    public BntWebConfig saveConfig(BntWebConfig bntWebConfig) {
        BntWebConfig bntWebConfig1 = webConfigMapper.selectById(bntWebConfig.getId());
        if(bntWebConfig1==null){
            //么有则新增
            webConfigMapper.insert(bntWebConfig);
        }else {
            webConfigMapper.updateById(bntWebConfig) ;
        }
        return bntWebConfig;
    }
}
