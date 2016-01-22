public class Speller {

   public static String spell(int number) {
      if (Constants.NUMBERS.containsKey(number)) {
         return Constants.NUMBERS.get(number);
      } else if (number < 100) {
         int tensDigit = number / 10;
         int unitDigit = number % 10;

         return Constants.NUMBERS.get(tensDigit * 10) + " " + Constants.NUMBERS.get(unitDigit);
      } else {
         int hundredDigit = number / 100;
         int modulo = number % 100;

         return Constants.NUMBERS.get(hundredDigit) + " " + Constants.HUNDRED + (modulo == 0 ? "" : " and " + spell(modulo));
      }
   }

}
