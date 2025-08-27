package com.ruoyi.web.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.entity.BntShop;
import com.ruoyi.web.entity.BntWithdrawOrder;


public interface IWithdrawService {

    TableDataInfo list(BntWithdrawOrder bntShop, LoginUser loginUser);

    AjaxResult edit(BntWithdrawOrder bntShop, LoginUser loginUser);

}
