package com.ruoyi.web.service.impl;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.controller.mapper.ShopMapper;
import com.ruoyi.web.controller.mapper.ShopTypeMapper;
import com.ruoyi.web.controller.mapper.WebConfigMapper;
import com.ruoyi.web.controller.tool.BigDecimalTool;
import com.ruoyi.web.entity.BntShop;
import com.ruoyi.web.entity.BntShopType;
import com.ruoyi.web.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class ShopService implements IShopService {
    @Autowired
    ShopMapper shopMapper;
    @Autowired
    AssociationSelectImpl associationSelect;
    @Autowired
    WebConfigMapper webConfigMapper;
    @Autowired
    ShopTypeMapper shopTypeMapper;
    @Override
    public TableDataInfo list(BntShop bntShop, LoginUser loginUser) {
        QueryWrapper<BntShop> bannerQueryWrapper=new QueryWrapper<BntShop>().orderByDesc("create_time");

        Page<Object> objects = PageHelper.startPage(bntShop.getPageNum(), bntShop.getPageSize());
        List<BntShop> bntBanners = shopMapper.selectList(bannerQueryWrapper);
        List<BntShopType> bntShopTypes = shopTypeMapper.selectList(new QueryWrapper<BntShopType>());
        
        for (int i = 0; i < bntBanners.size(); i++) {
            for (int j = 0; j < bntShopTypes.size(); j++) {
                if(bntShopTypes.get(j).getId()==bntBanners.get(i).getType()){
                    bntBanners.get(i).setTypeName(bntShopTypes.get(j).getNameZh());
                }
            }    
        }
        return associationSelect.toList(objects,bntBanners) ;
    }

    @Override
    public AjaxResult edit(BntShop bntShop, LoginUser loginUser) {
        String typeName = bntShop.getTypeName();
        BntShopType name_zh = shopTypeMapper.selectOne(new QueryWrapper<BntShopType>().eq("name_zh", typeName));
        bntShop.setType(name_zh.getId());
        shopMapper.updateById(bntShop);
        return AjaxResult.success();

    }

    @Override
    public AjaxResult add(BntShop bntShop, LoginUser loginUser) {
        bntShop.setCreateTime(new Date().getTime()+"");
        String typeName = bntShop.getTypeName();
        BntShopType name_zh = shopTypeMapper.selectOne(new QueryWrapper<BntShopType>().eq("name_zh", typeName));
        bntShop.setType(name_zh.getId());
        shopMapper.insert(bntShop);

        return AjaxResult.success();
    }

    @Override
    public AjaxResult delete(int id, LoginUser loginUser) {
        shopMapper.deleteById(id);
        return AjaxResult.success();

    }
}
