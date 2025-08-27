package com.ruoyi.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.controller.mapper.ShopMapper;
import com.ruoyi.web.controller.mapper.ShopTypeMapper;
import com.ruoyi.web.controller.mapper.WebConfigMapper;
import com.ruoyi.web.entity.BntShop;
import com.ruoyi.web.entity.BntShopType;
import com.ruoyi.web.service.IShopService;
import com.ruoyi.web.service.IShopTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ShopTypeService implements IShopTypeService {
    @Autowired
    ShopTypeMapper shopTypeMapper;
    @Autowired
    AssociationSelectImpl associationSelect;
    @Autowired
    WebConfigMapper webConfigMapper;

    @Override
    public AjaxResult list(BntShopType bntShop, LoginUser loginUser) {
        QueryWrapper<BntShopType> bannerQueryWrapper=new QueryWrapper<BntShopType>();

        List<BntShopType> bntBanners = shopTypeMapper.selectList(bannerQueryWrapper);

        return  AjaxResult.success(bntBanners);
    }

    @Override
    public AjaxResult edit(BntShopType bntShop, LoginUser loginUser) {

        shopTypeMapper.updateById(bntShop);
        return AjaxResult.success();

    }

    @Override
    public AjaxResult add(BntShopType bntShop, LoginUser loginUser) {

        shopTypeMapper.insert(bntShop);

        return AjaxResult.success();
    }


}
