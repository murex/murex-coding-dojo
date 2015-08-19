package coffee.machine;

public class Coffee implements Drink {

   public static final double PRICE = 0.6;

   public Coffee() {
   }

   public String message() {
      return "Drink maker makes 1 coffee ";
   }

   public double Price() {return PRICE;};


}
