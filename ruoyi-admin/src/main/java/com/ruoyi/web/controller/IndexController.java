package com.ruoyi.web.controller;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.Method;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ruoyi.common.annotation.I18nSwitch;
import com.ruoyi.common.annotation.RepeatSubmit;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.web.controller.mapper.ShopMapper;
import com.ruoyi.web.controller.mapper.ShopTypeMapper;
import com.ruoyi.web.controller.mapper.WebConfigMapper;
import com.ruoyi.web.controller.tool.HtmlParserUtil;
import com.ruoyi.web.core.config.JwtUtil;
import com.ruoyi.web.entity.BntShop;
import com.ruoyi.web.entity.BntShopType;
import com.ruoyi.web.entity.BntWebConfig;
import com.ruoyi.web.entity.LotteryData;
import com.ruoyi.web.service.impl.IndexService;
import com.ruoyi.web.service.impl.RedisService;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户信息
 *
 * @author ruoyi
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class IndexController {
    @Autowired
    IndexService indexService;
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private ServerConfig serverConfig;
    @Autowired
    RedisService redisService;
    @Autowired
    WebConfigMapper webConfigMapper;
    @Autowired
    ShopMapper shopMapper;
    @Autowired
    ShopTypeMapper shopTypeMapper;

    /**
     * ton网络充值返回接口
     * @param httpServletRequest
     * @return
     */
    @Transactional
    @PostMapping("/loadConfig")
    public AjaxResult loadConfig( HttpServletRequest httpServletRequest)
    {
        String type = webConfigMapper.selectOne(new QueryWrapper<BntWebConfig>().eq("type", 1)).getContent();
        return AjaxResult.success(JSONObject.parseObject(type));
    }

    /**
     * ton网络充值返回接口
     * @param httpServletRequest
     * @return
     */
    @Transactional
    @GetMapping("/getForecastByType")
    public String getForecastByType( HttpServletRequest httpServletRequest)
    {
        String game = httpServletRequest.getParameter("game");
        String type = httpServletRequest.getParameter("type");
        HttpRequest httpRequest=new HttpRequest("https://ky9988.cc/data/get/getForecastByType?game="+game+"&type="+type);
        httpRequest.header("Cookie","PHPSESSID=f5e13c4455c514b4add537889671e384; ad_18=1; mi_on=0; ad_on=1");
        httpRequest.header("Host","ky9988.cc");
        httpRequest.header("Accept-Encoding","gzip, deflate, br, zstd");
        httpRequest.header("Accept","*/*");
        httpRequest.header("X-Requested-With","XMLHttpRequest");
        httpRequest.setMethod(Method.GET);
        HttpResponse execute = httpRequest.execute();
        return execute.body();

    }
    @Transactional
    @GetMapping("/urls")
    public LotteryData urls( HttpServletRequest httpServletRequest) throws Exception {
        String game = httpServletRequest.getParameter("url");
//        HttpRequest httpRequest=new HttpRequest(game);
//        httpRequest.header("Cookie","PHPSESSID=f5e13c4455c514b4add537889671e384; ad_18=1; mi_on=0; ad_on=1");
//        httpRequest.header("Host","ky9988.cc");
//        httpRequest.header("Accept-Encoding","gzip, deflate, br, zstd");
//        httpRequest.header("Accept","*/*");
//        httpRequest.header("X-Requested-With","XMLHttpRequest");
//        httpRequest.setMethod(Method.GET);
//        HttpResponse execute = httpRequest.execute();
//        return execute.body();
        // 1. 读取 HTML 内容
        String html = HtmlParserUtil.getHtmlContent(game);
        System.out.println(html);
        // 2. 提取 appData 的 JSON 字符串
        String appDataJson = HtmlParserUtil.extractAppDataJson(html);
        // 3. JSON 转 Java 对象（LotteryData）
        return JSON.parseObject(appDataJson, LotteryData.class);
    }


}
