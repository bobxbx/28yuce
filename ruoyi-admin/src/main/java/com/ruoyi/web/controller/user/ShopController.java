package com.ruoyi.web.controller.user;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.entity.BntShop;
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
@RequestMapping("/defi/shop")
public class ShopController extends BaseController {
    @Autowired
    private IShopService iShopService;


    @PostMapping("/list")
    public TableDataInfo list(@RequestBody BntShop bntShop)
    {
        return   getDataTables(iShopService.list(bntShop,getLoginUser()));
    }
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody BntShop bntShop)
    {
        return  iShopService.edit(bntShop,getLoginUser());
    }
    @PostMapping("/add")
    public AjaxResult add(@RequestBody BntShop bntShop)
    {
        return  iShopService.add(bntShop,getLoginUser());
    }
    @PostMapping("/delete")
    public AjaxResult delete(@RequestBody int id)
    {
        return  iShopService.delete(id,getLoginUser());
    }


}
