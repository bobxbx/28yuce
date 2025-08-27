package com.ruoyi.web.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.entity.BntShop;


public interface IShopService {

    TableDataInfo list(BntShop bntShop, LoginUser loginUser);

    AjaxResult edit(BntShop bntShop, LoginUser loginUser);

    AjaxResult add(BntShop bntShop, LoginUser loginUser);

    AjaxResult delete(int id, LoginUser loginUser);
}
