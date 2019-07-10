package com.cw.cwcashiersystem.service;

import com.cw.cwcashiersystem.dto.GoodsDto;
import com.cw.cwcashiersystem.vo.Goods;

import java.util.List;
import java.util.Map;

public interface SettleService {
    Map<String, Object> settle(List<GoodsDto> goodsDtoList);

    List<Goods> getGoods();
}
