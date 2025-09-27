package com.gildedrose;

import java.util.Objects;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(){}

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    public void setSellIn(int sellIn) {
        this.sellIn = sellIn;
    }

    @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return sellIn == item.sellIn && quality == item.quality && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sellIn, quality);
    }
}
