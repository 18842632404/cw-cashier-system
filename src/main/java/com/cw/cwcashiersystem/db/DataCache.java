package com.cw.cwcashiersystem.db;

import com.cw.cwcashiersystem.vo.Goods;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataCache {

    private final static List<Goods> GOODS_LIST = new ArrayList<>();
    private final static Map<Integer, Goods> GOODS_MAP = new HashMap<>();
    private final static Map<Integer, String> TYPE_MAP = new HashMap<>();
    private final static List<Integer> EXEMPTION_DUTY_LIST = new ArrayList<>();

    /**
     * 这里模拟四种情况：
     *  1.巧克力-》免税
     *  2.巧克力（进口）-》免基本消费税，需缴纳进口税
     *  3.洗碗布-》需缴纳基本消费税
     *  4.洗碗布（进口）-》需缴纳基本消费税和进口税
     */
    static {
        GOODS_LIST.add(new Goods(1, "巧克力", 56.56, 1, 0));
        GOODS_LIST.add(new Goods(2, "巧克力（进口）", 128.83, 1, 1));
        GOODS_LIST.add(new Goods(3, "洗碗布", 6.66, 2, 0));
        GOODS_LIST.add(new Goods(4, "洗碗布（进口）", 13.55, 2, 1));
        GOODS_LIST.forEach(var -> GOODS_MAP.put(var.getId(), var));
        TYPE_MAP.put(1, "食品");
        TYPE_MAP.put(2, "生活用品");
        TYPE_MAP.put(3, "书籍");
        TYPE_MAP.put(4, "药品");
        Collections.addAll(EXEMPTION_DUTY_LIST, 1, 3, 4);
    }

    public List<Goods> getGoodsList() {
        return GOODS_LIST;
    }

    public Goods getGoodsById(Integer id) {
        return GOODS_MAP.get(id);
    }

    public List<Integer> getExemptionDutyList() {
        return EXEMPTION_DUTY_LIST;
    }
}
