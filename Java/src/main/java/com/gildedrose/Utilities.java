package com.gildedrose;

public class Utilities {

    public static void increaseItemQuality(Item item) {
        increaseItemQuality(item, 1);
    }

    public static void increaseItemQuality(Item item, int inc) {
        for (int i = 1; i <= inc; i++) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

    public static void increaseUnsoldBrieQuality(Item item) {
        if (item.sellIn < 0 && item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    public static void decreaseItemQuality(Item item) {
        if (item.sellIn <= 0) {
            item.quality = item.quality - 2;
        } else {
            item.quality = item.quality - 1;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }
    }

    public static void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    public static void updateBackstagePassesQuality(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;
        } else if (item.sellIn < 6) {
            increaseItemQuality(item, 3);
        } else if (item.sellIn < 11) {
            increaseItemQuality(item, 2);
        } else {
            increaseItemQuality(item);
        }
    }

    public static void updateConjuredCakeQuality(Item item) {
        if (item.sellIn <= 0) {
            item.quality = item.quality - 4;
        } else {
            item.quality = item.quality - 2;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }
    }
}
