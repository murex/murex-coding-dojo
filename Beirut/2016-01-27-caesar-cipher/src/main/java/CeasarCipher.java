public class CeasarCipher {

   public static final int ALPHABETS_SIZE = 26;

   public static String compute(String message, int k) {
      String result = "";
      for(int i=0;i<message.length();i++){

         result = result + encryptChar(message.charAt(i),k);
      }

      return result;
   }

   public static String shift(int k, char c, char base){
      return String.valueOf((char) ((((c + k) - base) % ALPHABETS_SIZE) + base));
   }

   private static String encryptChar(char c,int k) {
      if (isLowerCase(c)) {
         return  shift(k, c,  'a');
      }
      if(isUpperCase(c))
      {
         return shift(k, c,  'A');
      }
      else
      {
         return  c+ "" ;
      }
   }

   private static boolean isLowerCase(char c) {
      return c <= 'z' && c >= 'a' ;
   }

   private static boolean isUpperCase(char c) {
      return c <= 'Z' && c >= 'A' ;
   }
}
