package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }



    public void checkIfSpecial(Item item){
        switch (item.name){
            case "Aged Brie":
                getAgedBrieQuality(item);
                break;

            case "Backstage passes to a TAFKAL80ETC concert":
                getPassQuality(item);
                break;

            case "Conjured Mana Cake":
                getConjuredQuality(item);
                break;

            case "Sulfuras, Hand of Ragnaros": break;

            default:
                getDefaultQuality(item);
                break;
        }
    }

    private static void getDefaultQuality(Item item) {
        if(item.sellIn < 0){
            item.quality -=2;}else {
            item.quality-=1;}
        if(item.quality < 0){
            item.quality = 0;}
        item.sellIn--;
    }

    private static void getConjuredQuality(Item item) {
        if(item.sellIn < 0){
            item.quality -=4;}else {
            item.quality-=2;}
        if(item.quality < 0){
            item.quality = 0;}
        item.sellIn--;
    }

    private static void getPassQuality(Item item) {
        if (item.sellIn <= 10 && item.sellIn > 5){
            item.quality += 2;}else if (item.sellIn <= 5){
            item.quality += 3;}else {
            item.quality += 1;}
        if(item.quality > 50){
            item.quality = 50;}
        item.sellIn--;
    }

    private static void getAgedBrieQuality(Item item) {
        if(item.sellIn < 0){
            item.quality +=2;}else {
            item.quality++;}
        if(item.quality > 50){
            item.quality = 50;}
        item.sellIn--;
    }

    public void updateQuality() {
        for(Item item: items){
            checkIfSpecial(item);
        }
    }

    public void updateQuality2() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Aged Brie")
                && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
}
