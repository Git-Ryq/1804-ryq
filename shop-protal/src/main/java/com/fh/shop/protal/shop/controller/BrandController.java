package com.fh.shop.protal.shop.controller;

import com.fh.common.ServerResponse;
import com.fh.util.SendHttpClient;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@PropertySource(value = "classpath:fh-url.properties")
public class BrandController {

    @Value("${goodstype.findlist.url}")
    private String goodstypeListUrl;

    @Value("${brand.findlist.url}")
    private String brandListUrl;

    @Value("${goods.add.url}")
    private String goodsAddUrl;

    @Value("${goods.list.url}")
    private String goodsListUrl;

    @GetMapping("/brand/list")
    public ServerResponse findBrand(Integer id){
        String result = SendHttpClient.sendGet(goodstypeListUrl+id, null, null,true);
        Gson gson =new Gson();
        ServerResponse serverResponse = gson.fromJson(result, ServerResponse.class);
        System.out.println(result);
        return  serverResponse;
    }
    @GetMapping("/goods/findGoods")
    public ServerResponse findGoods(){
        String result = SendHttpClient.sendGet(brandListUrl, null, null,true);
        Gson gson=new Gson();
        ServerResponse serverResponse = gson.fromJson(result, ServerResponse.class);
        return serverResponse;
    }
    @PostMapping("/brand/add")
    public ServerResponse addGoods(@RequestParam Map goods){
        String result = SendHttpClient.sendPost(goodsAddUrl, goods, null,true);
        System.out.println(result);
        return ServerResponse.success();
    }


    @GetMapping("/brands")
    public ServerResponse brandList(){
        String result = SendHttpClient.sendGet(goodsListUrl, null, null,true);
        Gson gson=new Gson();
        ServerResponse serverResponse = gson.fromJson(result, ServerResponse.class);
        System.out.println(result);
        return serverResponse;
    }
}
