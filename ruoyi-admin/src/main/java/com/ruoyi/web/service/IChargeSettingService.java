package com.ruoyi.web.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.entity.BntChargeSetting;
import com.ruoyi.web.entity.BntShop;


public interface IChargeSettingService {

    TableDataInfo list(BntChargeSetting bntChargeSetting, LoginUser loginUser);

    AjaxResult edit(BntChargeSetting bntChargeSetting, LoginUser loginUser);

    AjaxResult add(BntChargeSetting bntChargeSetting, LoginUser loginUser);

    AjaxResult delete(BntChargeSetting bntChargeSetting, LoginUser loginUser);
}
