package com.cw.cwcashiersystem.service.impl;

import com.cw.cwcashiersystem.db.DataCache;
import com.cw.cwcashiersystem.dto.GoodsDto;
import com.cw.cwcashiersystem.service.SettleService;
import com.cw.cwcashiersystem.util.CalUtil;
import com.cw.cwcashiersystem.vo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SettleServiceImpl implements SettleService {

    private final DataCache dataCache;

    @Autowired
    public SettleServiceImpl(DataCache dataCache) {
        this.dataCache = dataCache;
    }

    @Override
    public Map<String, Object> settle(List<GoodsDto> goodsDtoList) {
        Map<String, Object> rsMap = new HashMap<>();
        double salesTaxes = 0.00;
        double total = 0.00;
        Goods goods;
        List<Integer> exemptionDutyList = dataCache.getExemptionDutyList();
        for (GoodsDto goodsDto : goodsDtoList) {
            goods = dataCache.getGoodsById(goodsDto.getId());
            salesTaxes += CalUtil.calTax(goodsDto, goods, exemptionDutyList);
            total += goodsDto.getQuantity() * goods.getPrice() + salesTaxes;
        }
        rsMap.put("salesTaxes", CalUtil.truncate(salesTaxes));
        rsMap.put("total", CalUtil.truncate(total));
        rsMap.put("goodsData", goodsDtoList);
        return rsMap;
    }

    @Override
    public List<Goods> getGoods() {
        return dataCache.getGoodsList();
    }
}
