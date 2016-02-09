package murex.dojo.coffeemachine;

import murex.dojo.coffeemachine.requests.ChocolateRequest;
import murex.dojo.coffeemachine.requests.CoffeeRequest;
import murex.dojo.coffeemachine.requests.TeaRequest;

public final class PriceRequestVisitor implements IRequestVisitor {

   private double drinkPrice;

   public void visit(CoffeeRequest request) {
      drinkPrice = 0.6;
   }

   public void visit(ChocolateRequest request) {
      drinkPrice = 0.5;
   }

   public void visit(TeaRequest request) {
      drinkPrice = 0.4;
   }

   public double getDrinkPrice() {
      return drinkPrice;
   }
}
