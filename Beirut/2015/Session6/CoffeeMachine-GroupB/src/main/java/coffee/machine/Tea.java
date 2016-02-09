package coffee.machine;

public class Tea implements Drink {
   public static final double PRICE = 0.4;

   public String message() {
      return "Drink maker makes 1 tea ";
   }

   public double Price() {return PRICE;};
}