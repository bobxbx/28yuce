package com.ruoyi.web.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.controller.mapper.ChargeSettingMapper;
import com.ruoyi.web.controller.mapper.ShopMapper;
import com.ruoyi.web.controller.mapper.WebConfigMapper;
import com.ruoyi.web.entity.BntChargeSetting;
import com.ruoyi.web.entity.BntShop;
import com.ruoyi.web.service.IChargeSettingService;
import com.ruoyi.web.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ChargeSettingService implements IChargeSettingService {

    @Autowired
    AssociationSelectImpl associationSelect;
    @Autowired
    WebConfigMapper webConfigMapper;
    @Autowired
    ChargeSettingMapper chargeSettingMapper;
    @Override
    public TableDataInfo list(BntChargeSetting bntChargeSetting, LoginUser loginUser) {
        QueryWrapper<BntChargeSetting> bannerQueryWrapper=new QueryWrapper<BntChargeSetting>().orderByDesc("create_time");

        Page<Object> objects = PageHelper.startPage(bntChargeSetting.getPageNum(), bntChargeSetting.getPageSize());
        List<BntChargeSetting> bntBanners = chargeSettingMapper.selectList(bannerQueryWrapper);

        return associationSelect.toList(objects,bntBanners) ;
    }

    @Override
    public AjaxResult edit(BntChargeSetting bntShop, LoginUser loginUser) {
        chargeSettingMapper.updateById(bntShop);
        return AjaxResult.success();

    }

    @Override
    public AjaxResult add(BntChargeSetting bntShop, LoginUser loginUser) {
        bntShop.setCreateTime(new Date().getTime()+"");
        chargeSettingMapper.insert(bntShop);

        return AjaxResult.success();
    }

    @Override
    public AjaxResult delete(BntChargeSetting bntShop, LoginUser loginUser) {
        chargeSettingMapper.deleteById(bntShop);
        return AjaxResult.success();

    }


}
