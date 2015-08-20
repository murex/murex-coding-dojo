package com.gildedrose;

public class FluentItem {
   public static final String CONCERT_PASSES = "Backstage passes to a TAFKAL80ETC concert";
   public static final String AGED_BRIE = "Aged Brie";
   public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
   public static final int MAX_QUALITY = 50;
   public static final int TEN_DAYS = 10;
   public static final int FIVE_DAYS = 5;
   public static final int SELLIN_DAY = 0;
   protected final Item item;

   protected FluentItem(Item item) {
      this.item = item;
   }

   public static FluentItem from(Item item) {
      switch (item.name) {
      case AGED_BRIE:
         return new AgedBrie(item);
      case CONCERT_PASSES:
         return new ConcertPasses(item);
      case SULFURAS:
         return new Sulfuras(item);
      default:
         return new FluentItem(item);
      }
   }

   protected void update() {
      setQuality(quality());
      decrementSellIn();
   }

   protected int quality() {
      if (overdue()) {
         return item.quality - 2;
      }
      return item.quality - 1;
   }

   private void setQuality(int quality) {
      item.quality = Math.max(0, Math.min(MAX_QUALITY, quality));
   }

   private void decrementSellIn() {
      item.sellIn = item.sellIn - 1;
   }

   protected boolean overdue() {
      return item.sellIn <= SELLIN_DAY;
   }

}
