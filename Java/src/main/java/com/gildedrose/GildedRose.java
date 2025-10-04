package com.gildedrose;

import java.util.Arrays;
import java.util.Objects;

class GildedRose {
    Item[] items;

    public GildedRose() {}

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
        }
    }

    public void updateItemQuality(Item item) {
        if (item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }
        else if (item.name.equals("Aged Brie")) {
            Utilities.increaseItemQuality(item);
            Utilities.decreaseSellIn(item);
            Utilities.increaseUnsoldBrieQuality(item);
        }
        else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            Utilities.updateBackstagePassesQuality(item);
            Utilities.decreaseSellIn(item);
        }
        else if (item.name.equals("Conjured Mana Cake")) {
            Utilities.updateConjuredCakeQuality(item);
            Utilities.decreaseSellIn(item);
        } else {
            Utilities.decreaseItemQuality(item);
            Utilities.decreaseSellIn(item);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GildedRose that = (GildedRose) o;
        return Objects.deepEquals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(items);
    }
}
