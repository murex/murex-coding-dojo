package Yatzy;

import com.google.common.collect.ImmutableList;

public enum Category {
   CHANCE {
      @Override
      public int score(ImmutableList<Integer> dices) {
         int sum = 0;
         for (int dice : dices) {
            sum += dice;
         }
         return sum;
      }
   }, FOURS {
      @Override
      public int score(ImmutableList<Integer> dices) {
         return scoreByNumber(dices, 4);
      }
   }, THREES {
      @Override
      public int score(ImmutableList<Integer> dices) {
         return scoreByNumber(dices, 3);
      }
   },
   YATZY {
      @Override
      public int score(ImmutableList<Integer> dices) {
         for (int i = 1; i < dices.size(); i++) {
            if (dices.get(i).intValue() != dices.get(0)) {
               return 0;
            }
         }
         return 50;
      }
   };

   private static int scoreByNumber(ImmutableList<Integer> dices, int number) {
      int count = 0;
      for (Integer dice : dices) {
         if (dice == number) {
            count += number;
         }
      }
      return count;
   }

   public int score(ImmutableList<Integer> dices) {
      return 0;
   }
}
