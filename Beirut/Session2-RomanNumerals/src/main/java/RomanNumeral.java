import com.google.common.collect.ImmutableMap;

/**
 * Coding Dojo Session
 * Given a positive integer number (eg 42) determine its Roman numeral representation as a String (eg "XLII").
 * http://cyber-dojo.org/setup/show/
 * Date: 22/07/2015
 **/
public class RomanNumeral {

   private static final String I = "I";
   private static final String V = "V";
   private static final String X = "X";
   private static final String L = "L";
   private static final String C = "C";
   private static final String D = "D";

   private static final ImmutableMap<Integer, String> ARABIC_TO_ROMAN = arabicToRomans();

   private static ImmutableMap<Integer, String> arabicToRomans() {
      return ImmutableMap.<Integer, String>builder().put(1, I).put(5, V).put(10, X).put(50, L).put(100, C).put(500, D).build();
   }

   public static String convertNumber(int number) {
      if (ARABIC_TO_ROMAN.containsKey(number)) {
         return ARABIC_TO_ROMAN.get(number);
      }
      if (number < 40) {
         return getLetters(number / 10, X) + convertFrom1to9(number % 10, 1, 5, 10);
      } else {
         return getLetters(number / 100, C) + convertFrom1to9(number % 100, 10, 50, 100);
      }
   }

   private static String convertFrom1to9(int number, int unit, int middle, int top) {
      String result;
      if (number < (middle - unit)) {
         result = getLetters(number, ARABIC_TO_ROMAN.get(unit));
      } else if (number == (middle - unit)) {
         result = ARABIC_TO_ROMAN.get(unit) + ARABIC_TO_ROMAN.get(middle);
      } else if (number == (top - unit)) {
         result = ARABIC_TO_ROMAN.get(unit) + ARABIC_TO_ROMAN.get(top);
      } else {
         result = ARABIC_TO_ROMAN.get(middle) + getLetters(number - middle, ARABIC_TO_ROMAN.get(unit));
      }
      return result;
   }

   public static String getLetters(int num, String letter) {
      String ones = "";
      while (num-- > 0)
         ones += letter;
      return ones;
   }
}
