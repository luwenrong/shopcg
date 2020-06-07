package com.ten.shopcg.service.goods.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/demo")
@RestController  //包含 @controller  @responseBody
public class DemoController {

    @GetMapping("/test")
    public String demo(){
        return "demo test";
    }
}
