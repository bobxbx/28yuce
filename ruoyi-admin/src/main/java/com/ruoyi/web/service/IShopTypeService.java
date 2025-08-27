package com.ruoyi.web.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.entity.BntShop;
import com.ruoyi.web.entity.BntShopType;


public interface IShopTypeService {

    AjaxResult list(BntShopType bntShop, LoginUser loginUser);

    AjaxResult edit(BntShopType bntShop, LoginUser loginUser);

    AjaxResult add(BntShopType bntShop, LoginUser loginUser);

}
