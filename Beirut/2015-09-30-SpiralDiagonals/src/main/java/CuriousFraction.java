public class CuriousFraction {
   public static boolean check(int num, int denom) {
      double fractionValue = ((double) (num)) / (double) denom;

      int numUnit = num % 10;
      int numTenth = num / 10;

      int denomUnit = denom % 10;
      int denomTenth = denom / 10;

      //condition that compares all the numbers
      if (numUnit != denomUnit && numUnit != denomTenth && numTenth != denomUnit && numTenth != denomTenth) {
         return false;
      }

      if (num > denom) {
         return false;
      }

      double numDigitProduct = 1.0 * numUnit * numTenth;
      double denomDigitProduct = 1.0 * denomUnit * denomTenth;
      if (numDigitProduct / denomDigitProduct == fractionValue) {
         return true;
      }

      return false;
   }
}
