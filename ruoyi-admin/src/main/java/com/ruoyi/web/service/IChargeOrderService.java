package com.ruoyi.web.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.entity.BntChargeOrder;
import com.ruoyi.web.entity.BntChargeSetting;


public interface IChargeOrderService {

    TableDataInfo list(BntChargeOrder bntChargeOrder, LoginUser loginUser);

    AjaxResult edit(BntChargeOrder bntChargeOrder, LoginUser loginUser);

}
