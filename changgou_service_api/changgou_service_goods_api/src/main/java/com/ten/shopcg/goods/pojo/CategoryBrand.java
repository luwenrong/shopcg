package com.ten.shopcg.goods.pojo;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ten.lu
 * @title
 * @date 2020-06-28 1:35
 */
@Table(name = "tb_category_brand")
public class CategoryBrand {
    @Id
    private Integer categoryId;
    @Id
    private Integer brandId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}
