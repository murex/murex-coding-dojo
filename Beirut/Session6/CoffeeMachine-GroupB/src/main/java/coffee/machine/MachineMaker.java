package coffee.machine;

public class MachineMaker {
   public static String make(DrinkOrder myOrder) {
      boolean isValid = validateDrinkPrice(myOrder.OrderType().Price(), myOrder.getMoney());
      if(isValid) {
         return myOrder.OrderType().message() + myOrder.SugarMsg();
      }
      else {

         return "Insufficient money - required = "+(myOrder.OrderType().Price() - myOrder.getMoney());
      }
   }

   public static boolean validateDrinkPrice(double drinkPrice, double money) {
      if(money == drinkPrice){
         return true;
      }
      return false;
   }

   public static String printmsg(String testString) {
      return testString;
   }

}