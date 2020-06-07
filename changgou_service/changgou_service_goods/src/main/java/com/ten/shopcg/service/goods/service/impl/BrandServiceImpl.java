package com.ten.shopcg.service.goods.service.impl;

import com.changgou.goods.pojo.Brand;
import com.ten.shopcg.common.pojo.Result;
import com.ten.shopcg.service.goods.dao.BrandMapper;
import com.ten.shopcg.service.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findList() {
        List<Brand> brandList = brandMapper.selectAll();
        return brandList;
    }

    @Override
    public Brand findById(Integer id) {
        Brand brand = brandMapper.selectByPrimaryKey(id);
        return brand;
    }

    /**
     * 品牌新增
     *
     * @param brand
     */
    @Override
    @Transactional
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    /**
     * 修改品牌
     *
     * @param brand
     */
    @Override
    @Transactional
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKey(brand);
    }

    /**
     * 根据id删除品牌
     *
     * @param id
     */
    @Override
    @Transactional
    public void delById(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Brand> list(Map<String, Object> searchMap) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {
            //品牌名称模糊 like
            if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))) {
                criteria.andLike("name", "%" + searchMap.get("name") + "%");
            }
            if(searchMap.get("letter") != null && !"".equals(searchMap.get("letter"))){
                criteria.andEqualTo("letter",searchMap.get("letter"));
            }
        }
        return brandMapper.selectByExample(example);
    }


}
