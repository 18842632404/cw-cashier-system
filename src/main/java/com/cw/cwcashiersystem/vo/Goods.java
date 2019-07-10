package com.cw.cwcashiersystem.vo;

import lombok.Data;

@Data
public class Goods {

    public Goods() {
    }

    public Goods(Integer id, String name, Double price, Integer type, Integer imported) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.imported = imported;
    }

    // 主键
    private Integer id;

    // 商品名称
    private String name;

    // 商品价格
    private Double price;

    // 商品类型
    private Integer type;

    // 是否进口 1.进口 0.非进口
    private Integer imported;

}
