package com.gildedrose;

public class AgedBrie extends FluentItem {
   @Override
   protected int quality() {
      if (overdue()) {
         return item.quality + 2;
      }
      return item.quality + 1;
   }

   public AgedBrie(Item item) {
      super(item);
   }
}
