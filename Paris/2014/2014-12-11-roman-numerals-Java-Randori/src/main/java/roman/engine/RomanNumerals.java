package roman.engine;

public class RomanNumerals {

   public static final String I = "I";
   public static final String X = "X";
   public static final String V = "V";
   public static final String L = "L";
   public static final String C = "C";
   public static final String D = "D";
   public static final String M = "M";

   public static String toRoman(int number) {
      return
        digitToRoman(number / 100, C, D, M) +
        digitToRoman((number % 100) / 10, X, L, C) +
        digitToRoman(number % 10, I, V, X);
   }

   private static String digitToRoman(int number, String unit, String half, String tenth) {
      if (number >= 10) {
         return tenth + digitToRoman(number - 10, unit, half, tenth);
      }

      if (number == 9) {
         return unit + tenth;
      }

      if (number >= 5) {
         return half + digitToRoman(number - 5, unit, half, tenth);
      }

      if (number == 4) {
         return unit + half;
      }

      if (number >= 1) {
         return unit + digitToRoman(number - 1, unit, half, tenth);
      }
      return "";
   }
}
