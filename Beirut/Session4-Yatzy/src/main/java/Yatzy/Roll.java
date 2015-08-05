package Yatzy;

import com.google.common.collect.ImmutableList;

public class Roll {

   private final ImmutableList<Integer> dices;
   private final Category category;

   public Roll(Category category, Integer... dice) {
      this.category = category;
      dices = ImmutableList.copyOf(dice);
   }

   public int score() {
      return category.score(dices);
   }
}
