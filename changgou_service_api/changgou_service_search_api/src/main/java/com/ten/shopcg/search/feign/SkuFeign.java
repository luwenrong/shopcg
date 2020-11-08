package com.ten.shopcg.search.feign;

import com.ten.shopcg.goods.pojo.Sku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author ten.lu
 * @title
 * @date 2020-11-06 0:50
 */

@FeignClient(name = "goods")
public interface SkuFeign {
    @GetMapping("/sku/spu/{spuId}")
    public List<Sku> findSkuListBySpuId(@PathVariable("spuId") String spuId) ;
}
