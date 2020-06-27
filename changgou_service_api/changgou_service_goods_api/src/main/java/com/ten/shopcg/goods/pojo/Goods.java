package com.ten.shopcg.goods.pojo;

import java.util.List;

/**
 * @author ten.lu
 * @title
 * @date 2020-06-26 10:57
 */
public class Goods {
    private Spu spu;
    private List<Sku> skuList;

    public Spu getSpu() {
        return spu;
    }

    public void setSpu(Spu spu) {
        this.spu = spu;
    }

    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }
}
