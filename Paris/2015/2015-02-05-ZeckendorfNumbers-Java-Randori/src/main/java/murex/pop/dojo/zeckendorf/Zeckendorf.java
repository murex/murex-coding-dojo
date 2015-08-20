package murex.pop.dojo.zeckendorf;

public class Zeckendorf {

   private static final int[] FIBONACCI_LIST = new int[] { 1, 2, 3, 5, 8, 13, 21 };

   public static String translate(int number) {
      return Integer.toString(translateToInt(number));
   }

   private static int translateToInt(int number) {
      if (number == 0) {
         return 0;
      }
      int closestFibo = getClosestFibonacci(number);
      return getValue(closestFibo) + translateToInt(number - closestFibo);

   }

   private static int getValue(int number) {
      for (int i = 0; i < FIBONACCI_LIST.length; i++) {
         if (number == FIBONACCI_LIST[i]) {
            return (int) Math.pow(10, i);
         }
      }
      throw new UnsupportedOperationException();
   }

   private static int getClosestFibonacci(int number) {
      for (int i = 1; i < FIBONACCI_LIST.length; i++) {
         if (number < FIBONACCI_LIST[i]) {
            return FIBONACCI_LIST[i - 1];
         }
      }
      throw new UnsupportedOperationException();
   }

}
