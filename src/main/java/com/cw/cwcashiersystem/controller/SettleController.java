package com.cw.cwcashiersystem.controller;

import com.alibaba.fastjson.JSON;
import com.cw.cwcashiersystem.dto.GoodsDto;
import com.cw.cwcashiersystem.service.SettleService;
import com.cw.cwcashiersystem.vo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class SettleController {

    private final SettleService settleService;

    @Autowired
    public SettleController(SettleService settleService) {
        this.settleService = settleService;
    }

    @PostMapping("settle")
    public Map<String, Object> settle(@RequestBody List<GoodsDto> goodsDtoList) {
        return settleService.settle(goodsDtoList);
    }

    @GetMapping("getGoods")
    public List<Goods> getGoods() {
        return settleService.getGoods();
    }
}
