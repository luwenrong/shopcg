package com.ten.shopcg.service.goods.service;

import com.changgou.goods.pojo.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {

    /**
     * 查询列表数据
     *
     * @return
     */
    List<Brand> findList();

    /**
     * 根据ID 查询品牌数据
     */
    Brand findById(Integer id);

    /**
     * 品牌新增
     */
    void add(Brand brand);

    /**
     * 修改品牌
     */
    void update(Brand brand);

    /**
     * 删除品牌
     */
    void delById(Integer id);

    /**
     * 品牌列表条件查询
     */
    List<Brand> list(Map<String,Object> searchMap);
}