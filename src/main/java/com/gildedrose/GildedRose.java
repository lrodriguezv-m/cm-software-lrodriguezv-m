package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (isNotAgedOrBackstagePasses(items[i])) {
                if (items[i].quality > 0) {
                    if (!isSulfuras(items[i])) {
                        reduceQuality(items[i]);
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    increaseQuality(items[i]);

                    if (isBackstage(items[i])) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                increaseQuality(items[i]);
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                increaseQuality(items[i]);
                            }
                        }
                    }
                }
            }

            if (!isSulfuras(items[i])) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!isAged(items[i])) {
                    if (!isBackstage(items[i])) {
                        if (items[i].quality > 0) {
                            if (!isSulfuras(items[i])) {
                                reduceQuality(items[i]);
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        increaseQuality(items[i]);
                    }
                }
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
