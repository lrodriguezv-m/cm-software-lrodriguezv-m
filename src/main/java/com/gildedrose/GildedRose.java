package com.gildedrose;

import com.gildedrose.service.IQualityService;
import com.gildedrose.service.impl.QualityServiceImpl;

class GildedRose {
    Item[] items;
    IQualityService qualityService;

    public GildedRose(Item[] items) {
        this.items = items;
        qualityService = new QualityServiceImpl();
    }

    public void updateQuality() {
        for (Item item : items) {
            if (qualityService.isNotAgedOrBackstagePasses(item)) {
                qualityService.reduceQualityForItem(item);
            } else {
                qualityService.increaseQualityForItem(item);
            }

            qualityService.updateQualityForSulfuras(item);

            if (item.sellIn < 0) {
                qualityService.expiredSellIn(item);
            }
        }
    }
}
