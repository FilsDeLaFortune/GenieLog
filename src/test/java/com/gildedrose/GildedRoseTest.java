package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.name, is("foo"));
  }

  @Test
  @DisplayName("Test the format of ToString")
  void testToString() {
    Item element = new Item("foo", 0, 0);
    assertThat(element.toString(), is("foo, 0, 0"));
  }

  @Test
  @DisplayName("TestUpdateIfQualityNot0RandomName")
  void testUpdateIfQualityNot0RandomName() {
    Item element = new Item("Element", 5, 7);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(6));
  }

  @Test
  @DisplayName("TestUpdateIfQuality0RandomName")
  void testUpdateIfQuality0RandomName() {
    Item element = new Item("Element", 5, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }

  @Test
  @DisplayName("TestUpdateIfNameSulfurasAndQualitySup0")
  void testUpdateIfNameSulfurasAndQualitySup0() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 5, 4);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(4));
  }

  @Test
  @DisplayName("TestUpdateIfNameSulfurasAndQualityEqu0")
  void testUpdateIfNameSulfurasAndQualityEqu0() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 5, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(5));
  }

  @Test
  @DisplayName("TestUpdateIfNameAgedBrie")
  void testUpdateIfNameAgedBrie() {
    Item element = new Item("Aged Brie", 5, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(1));
  }

  @Test
  @DisplayName("TestUpdateIfNameBackstageSellInUnder6")
  void testUpdateIfNameBackstageSellInUnder6() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(3));
  }

  @Test
  @DisplayName("TestUpdateIfNameBackstageSellInUnder11")
  void testUpdateIfNameBackstageSellInUnder11() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(2));
  }

  @Test
  @DisplayName("TestUpdateIfNameBackstageQuality49SellInUnder11")
  void testUpdateIfNameBackstageQuality49SellInUnder11() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("TestUpdateIfNameBackstageQuality49SellInUpper11")
  void testUpdateIfNameBackstageQuality49SellInUpper11() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("TestUpdateIfNameBackstageQuality50")
  void testUpdateIfNameBackstageQuality50() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("TestUpdateIfNameBackstageQuality48SellInUnder6")
  void testUpdateIfNameBackstageQuality48SellInUnder6() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 48);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("TestUpdateIfNameAgedBrieSellInUnder0Quality48")
  void testUpdateIfNameAgedBrieSellInUnder0Quality48() {
    Item element = new Item("Aged Brie", -1, 48);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("TestUpdateIfNameAgedBrieSellInUnder0Quality51")
  void testUpdateIfNameAgedBrieSellInUnder0Quality51() {
    Item element = new Item("Aged Brie", -1, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("TestUpdateIfNameBackstageSellInUnder0Quality48")
  void testUpdateIfNameBackstageSellInUnder0Quality48() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 48);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }

  @Test
  @DisplayName("TestUpdateIfNameSulfurasSellInUnder0Quality2")
  void testUpdateIfNameSulfurasSellInUnder0Quality2() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", -1, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(2));
  }

  @Test
  @DisplayName("TestUpdateIfNameRandomSellInUnder0Quality2")
  void testUpdateIfNameRandomSellInUnder0Quality2() {
    Item element = new Item("Random", -1, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }

  @Test
  @DisplayName("TestUpdateIfNameConjuredSellInUnder0")
  void testUpdateIfNameConjuredSellInUnder0() {
    Item element = new Item("Conjured", -1, 20);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(16));
  }
  @Test
  @DisplayName("TestUpdateIfNameConjuredSellInUpper0")
  void testUpdateIfNameConjuredSellInUpper0() {
    Item element = new Item("Conjured", 2, 20);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(18));
  }
}
