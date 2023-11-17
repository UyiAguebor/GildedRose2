package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {


    @Test
    void normalItem() {
        Item[] items = new Item[] { new Item("foo", 10, 0) };
        GildedRose app = new GildedRose(items);
        GildedRose app2 = new GildedRose(items);
        int days = 54;

        for(int i = 0;i < days;i++){
            app.updateQuality();
            app2.updateQuality2();
        }

        assertEquals(app2.items[0].quality, app.items[0].quality);
        assertEquals(app2.items[0].sellIn,app.items[0].sellIn);
    }

    @Test
    void AgedBrie(){
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        GildedRose app2 = new GildedRose(items);
        int days = 50;

        for(int i = 0;i < days;i++){
            app.updateQuality();
            app2.updateQuality2();
        }

        assertEquals(app2.items[0].quality, app.items[0].quality);
        assertEquals(app2.items[0].sellIn,app.items[0].sellIn);

    }

    @Test
    void Sulfuras(){
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 2, 10) };
        GildedRose app = new GildedRose(items);
        GildedRose app2 = new GildedRose(items);
        int days = 50;

        for(int i = 0;i < days;i++){
            app.updateQuality();
            app2.updateQuality2();
        }

        assertEquals(app2.items[0].quality, app.items[0].quality);
        assertEquals(app2.items[0].sellIn,app.items[0].sellIn);
    }
    @Test
    void backStagePasses(){
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 30, 0) };
        GildedRose app = new GildedRose(items);
        GildedRose app2 = new GildedRose(items);
        int days = 25;

        for(int i = 0;i < days;i++){
            app.updateQuality();
            app2.updateQuality2();
        }

        assertEquals(app2.items[0].quality, app.items[0].quality);
        assertEquals(app2.items[0].sellIn,app.items[0].sellIn);
    }

    @Test
    void testConjuredItemUpdate() {
        // Arrange
        Item conjuredItem = new Item("Conjured Mana Cake", 5, 30);
        GildedRose app = new GildedRose(new Item[]{conjuredItem});

        int days = 10;
        for(int i  = 0;i < days;i++){
        app.updateQuality();
        }

        assertEquals(2, conjuredItem.quality);
        assertEquals(-5, conjuredItem.sellIn);
    }
}
