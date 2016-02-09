import java.math.BigInteger;

public class FactorialDigitSum {

   private static final int ZERO = 0;
   private static final int ONE = 1;
   private static final BigInteger TEN = bigInteger(10);

   public static BigInteger factorialOf(int number) {
      if (number == ZERO) {
         return BigInteger.ONE;
      }
      return bigInteger(number).multiply(factorialOf(number - ONE));
   }

   public static BigInteger sumOfDigits(BigInteger number) {
      if (number.compareTo(TEN) < ZERO) {
         return number;
      }
      return sumOfDigits(number.divide(TEN)).add(number.mod(TEN));
   }

   protected static BigInteger bigInteger(int number) {
      return bigInteger(String.valueOf(number));
   }

   protected static BigInteger bigInteger(String stringValue) {
      return new BigInteger(stringValue);
   }

   public static BigInteger sumOfFactorialDigits(int number) {
      return sumOfDigits(factorialOf(number));
   }
}
