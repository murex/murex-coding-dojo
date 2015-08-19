package coffee.machine;

public class DrinkOrder {
   private final Drink drinkType;
   private final double money;
   private final Sugar sugar;

   public DrinkOrder(Drink drinkType) {
      this.drinkType = drinkType;
      this.sugar = new Sugar(0);
      this.money=0;
   }

   public DrinkOrder(Drink drinkType, int sugarCubes) {
      this.drinkType = drinkType;
      this.sugar = new Sugar(sugarCubes);
      this.money=0;
   }

   public DrinkOrder(Drink drinkType, double money) {
      this.drinkType = drinkType;
      this.sugar = new Sugar(0);
      this.money = money;
   }

   public Drink OrderType() { return drinkType; }

   public String SugarMsg() {
      return this.sugar.getSugarMessage();
   }

   public double getMoney() {
      return money;
   }
}
