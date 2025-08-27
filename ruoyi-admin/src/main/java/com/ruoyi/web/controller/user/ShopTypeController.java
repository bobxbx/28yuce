package com.ruoyi.web.controller.user;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.web.entity.BntShop;
import com.ruoyi.web.entity.BntShopType;
import com.ruoyi.web.service.IShopService;
import com.ruoyi.web.service.IShopTypeService;
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
@RequestMapping("/defi/shopType")
public class ShopTypeController extends BaseController {
    @Autowired
    private IShopTypeService iShopService;


    @PostMapping("/list")
    public AjaxResult list(@RequestBody BntShopType bntShop)
    {
        return   iShopService.list(bntShop,getLoginUser());
    }
    @PostMapping("/lists")
    public AjaxResult list()
    {
        return   iShopService.list(new BntShopType(),getLoginUser());
    }
    @PostMapping("/edit")
    public AjaxResult edit(@RequestBody BntShopType bntShop)
    {
        return  iShopService.edit(bntShop,getLoginUser());
    }
    @PostMapping("/add")
    public AjaxResult add(@RequestBody BntShopType bntShop)
    {
        return  iShopService.add(bntShop,getLoginUser());
    }


}
