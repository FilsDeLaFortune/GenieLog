package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch(item.name){
                case "Sulfuras, Hand of Ragnaros": 
                    continue;
                case "Aged Brie":
                    item.quality++;
                    item.sellIn--;
                    if(item.sellIn<0){
                        item.quality++;
                    }
                    break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    item.quality++;
                    if(item.sellIn<11){
                        item.quality++;
                    }
                    if(item.sellIn<6){
                        item.quality++;
                    }
                    item.sellIn--;
                    if(item.sellIn<0){
                        item.quality=0;
                    }
                    break;

                default:
                    item.quality--;
                    item.sellIn--;
                    if(item.sellIn<0){
                        item.quality--;
                    }
                    break;
            }
            if(item.quality>=50){
                item.quality = 50;
            }
            if(item.quality<0){
                item.quality=0;
            }
        }
    }
}