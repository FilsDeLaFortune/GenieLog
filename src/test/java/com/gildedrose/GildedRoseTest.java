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
  @DisplayName("Test that the name is unchanged")
  void testToString() {
    Item element = new Item("foo", 0, 0);
    assertThat(element.toString(), is("foo, 0, 0"));
  }

  @Test
  @DisplayName("Test the update is doing is job")
  void testUpdateIfQualityNot0RandomName() {
    Item element = new Item("Element", 5, 7);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(6));
  }

  @Test
  @DisplayName("Test the update is doing is job")
  void testUpdateIfQuality0RandomName() {
    Item element = new Item("Element", 5, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }

  @Test
  @DisplayName("Test the update is doing is job")
  void testUpdateIfNameSulfurasAndQualitySup0() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 5, 4);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(4));
  }

  @Test
  @DisplayName("Test the update is doing is job")
  void testUpdateIfNameSulfurasAndQualityEqu0() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 5, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.sellIn, is(5));
  }

  @Test
  @DisplayName("Test the update is doing is job")
  void testUpdateIfNameAgedBrie() {
    Item element = new Item("Aged Brie", 5, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(1));
  }

  @Test
  @DisplayName("Test the update is doing is job")
  void testUpdateIfNameBackstageSellInUnder6() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(3));
  }

  @Test
  @DisplayName("Test the update is doing is job")
  void testUpdateIfNameBackstageSellInUnder11() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(2));
  }

  @Test
  @DisplayName("Test the update is doing is job")
  void testUpdateIfNameBackstageQuality49SellInUnder11() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("Test the update is doing is job")
  void testUpdateIfNameBackstageQuality49SellInUpper11() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 12, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("Test the update is doing is job")
  void testUpdateIfNameBackstageQuality50() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 8, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("Test the update is doing is job")
  void testUpdateIfNameBackstageQuality48SellInUnder6() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 48);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("Test the update is doing is job")
  void testUpdateIfNameAgedBrieSellInUnder0Quality48() {
    Item element = new Item("Aged Brie", -1, 48);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("Test the update is doing is job")
  void testUpdateIfNameAgedBrieSellInUnder0Quality51() {
    Item element = new Item("Aged Brie", -1, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(50));
  }

  @Test
  @DisplayName("Test the update is doing is job")
  void testUpdateIfNameBackstageSellInUnder0Quality48() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", -1, 48);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }

  @Test
  @DisplayName("Test the update is doing is job")
  void testUpdateIfNameSulfurasSellInUnder0Quality2() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", -1, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(2));
  }

  @Test
  @DisplayName("Test the update is doing is job")
  void testUpdateIfNameRandomSellInUnder0Quality2() {
    Item element = new Item("Random", -1, 2);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertThat(element.quality, is(0));
  }
}
