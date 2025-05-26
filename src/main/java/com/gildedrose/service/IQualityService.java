package com.gildedrose.service;

import com.gildedrose.Item;

public interface IQualityService {
    void expiredSellIn(Item item);
    boolean isNotAgedOrBackstagePasses(Item item);
    void reduceQualityForItem(Item item);
    void increaseQualityForItem(Item item);
    void updateQualityForSulfuras(Item item);
}
