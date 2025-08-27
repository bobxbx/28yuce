package com.ruoyi.web.controller.user;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.entity.BntChargeSetting;
import com.ruoyi.web.entity.BntShop;
import com.ruoyi.web.service.IChargeSettingService;
import com.ruoyi.web.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户信息
 *
 * @author ruoyi
 */
@RestController
@RequestMapping("/defi/chargeSetting")
public class ChargeSettingController extends BaseController {
    @Autowired
    private IChargeSettingService iChargeSettingService;


    @PostMapping("/list")
    public TableDataInfo list(@RequestBody BntChargeSetting bntChargeSetting)
    {
        return   getDataTables(iChargeSettingService.list(bntChargeSetting,getLoginUser()));
    }
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody BntChargeSetting bntChargeSetting)
    {
        return  iChargeSettingService.edit(bntChargeSetting,getLoginUser());
    }
    @PostMapping("/add")
    public AjaxResult add(@RequestBody BntChargeSetting bntChargeSetting)
    {
        return  iChargeSettingService.add(bntChargeSetting,getLoginUser());
    }
    @PostMapping("/delete")
    public AjaxResult delete(@RequestBody BntChargeSetting bntChargeSetting)
    {
        return  iChargeSettingService.delete(bntChargeSetting,getLoginUser());
    }


}
