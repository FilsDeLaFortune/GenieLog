package com.gildedrose;

public class Item {

    public String name;

    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name    = name;
        this.sellIn  = sellIn;
        this.quality = quality;
    }

    public void updateQuality(){
        if(this.name.equals("Sulfuras, Hand of Ragnaros")) return;
        this.sellIn--;
        switch(this.name){
            case "Conjured":
                this.quality -= this.sellIn<0 ? 4:2;
                break;
            case "Aged Brie":
                this.quality++;
                if(this.sellIn<0)  this.quality++;
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                this.quality++;
                if(this.sellIn<10) this.quality++;
                if(this.sellIn<5)  this.quality++;
                if(this.sellIn<0)  this.quality=0;
                break;
            default:
                this.quality--;
                if(this.sellIn<0) this.quality--;
                break;
        }
        if(this.quality >= 50) this.quality = 50;
        if(this.quality <   0) this.quality =  0;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
