package com.gildedrose;

public class ConcertPasses extends FluentItem {
   protected ConcertPasses(Item item) {
      super(item);
   }

   @Override
   protected int quality() {
      if (overdue()) {
         return 0;
      }
      if (item.sellIn <= FIVE_DAYS) {
         return item.quality + 3;
      }
      if (item.sellIn <= TEN_DAYS) {
         return item.quality + 2;
      }

      return item.quality + 1;
   }
}
