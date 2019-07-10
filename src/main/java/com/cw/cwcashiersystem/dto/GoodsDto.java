package com.cw.cwcashiersystem.dto;

import lombok.Data;

@Data
public class GoodsDto {

    private Integer id;

    private Integer quantity;

    private String name;

    private Double totalPrice;

    private Double price;
}
