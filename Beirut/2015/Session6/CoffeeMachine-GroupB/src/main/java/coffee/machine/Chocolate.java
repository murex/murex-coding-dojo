package coffee.machine;

public class Chocolate implements Drink {
   public static final double PRICE = 0.5;

   public String message() {
      return "Drink maker makes 1 chocolate ";
   }

   public double Price() {return PRICE;};
}
