public class Fibonacci {

   public static long compute(int n) {
      if (n == 0) {
         return 0;
      }
      if (n == 1) {
         return 1;
      }

      long a = 0;
      long b = 1;
      long c = 0;
      for (int i = 2; i <= n; i++) {
         c = a + b;
         a = b;
         b = c;
      }

      return c;
   }

   public static long computeLessThanFourMillion()
   {
      int iteration=0;
      long result = 0;
      while (result<4000000)
      {
         result=compute(iteration);
         iteration++;

      }
       return result;
   }

   public static boolean checkeven(int n)
   {
      if (n%2 == 0)
         return true;
      else
      return false;
   }

}
