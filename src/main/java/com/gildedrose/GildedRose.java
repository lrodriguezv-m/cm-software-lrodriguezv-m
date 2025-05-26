package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (isNotAgedOrBackstagePasses(item)) {
                reduceQualityForItem(item);
            } else {
                increaseQualityForItem(item);
            }

            updateQualityForSulfuras(item);

            if (item.sellIn < 0) {
                expiredSellIn(item);
            }
        }
    }

    private void expiredSellIn(Item item) {
        if (!isAged(item)) {
            if (!isBackstage(item)) {
                if (item.quality > 0) {
                    if (!isSulfuras(item)) {
                        reduceQuality(item);
                    }
                }
            } else {
                item.quality = 0;
            }
        } else {
            if (item.quality < 50) {
                increaseQuality(item);
            }
        }
    }

    private void updateQualityForSulfuras(Item item) {
        if (!isSulfuras(item)) {
            item.sellIn = item.sellIn - 1;
        }
    }

    private void increaseQualityForItem(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);
            increaseQualityItemBackstage(item);
        }
    }

    private void increaseQualityItemBackstage(Item item) {
        if (isBackstage(item)) {
            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    increaseQuality(item);
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    increaseQuality(item);
                }
            }
        }
    }
    private void reduceQualityForItem(Item item) {
        if (item.quality > 0) {
            if (!isSulfuras(item)) {
                reduceQuality(item);
            }
        }
    }

    private boolean isBackstage(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAged(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isNotAgedOrBackstagePasses(Item item) {
        return !item.name.equals("Aged Brie") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void reduceQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }
}
