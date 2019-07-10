package com.cw.cwcashiersystem.util;

import com.cw.cwcashiersystem.dto.GoodsDto;
import com.cw.cwcashiersystem.vo.Goods;

import java.text.DecimalFormat;
import java.util.List;

public class CalUtil {

    private final static Double NORMAL_TAX = 0.10D;
    private final static Double IMPORT_TAX = 0.05D;
    private static final double ROUND_OFF = 0.05D;

    public static double calTax(GoodsDto goodsDto, Goods goods, List<Integer> exemptionDutyList) {
        double totalTax = 0.00;
        // 如果当前商品类型不在免税名单里面
        if (!exemptionDutyList.contains(goods.getType())) {
            totalTax += NORMAL_TAX;
        }
        // 如果当前商品是进口的
        if (goods.getImported().equals(1)) {
            totalTax += IMPORT_TAX;
        }
        // 向0.05取整
        double tax = roundoff(goods.getPrice() * totalTax);
        double allTax = tax * goodsDto.getQuantity();
        // 保留两位
        double totalPrice = truncate(goods.getPrice()*goodsDto.getQuantity()+allTax);
        goodsDto.setTotalPrice(totalPrice);
        return  allTax;
    }

    private static double roundoff(double value) {
        return (int)(value / ROUND_OFF + 0.5) * 0.05;
    }

    public static double truncate(double value) {
        String result = new DecimalFormat("#.00").format(value);
        return Double.parseDouble(result);
    }
}
