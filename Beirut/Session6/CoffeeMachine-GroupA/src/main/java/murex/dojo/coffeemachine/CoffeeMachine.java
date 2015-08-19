package murex.dojo.coffeemachine;

import murex.dojo.coffeemachine.requests.IRequest;

public class CoffeeMachine implements ICoffeeMachine {

   private double getDrinkPrice(IRequest request) {
      PriceRequestVisitor visitor = new PriceRequestVisitor();

      request.accept(visitor);

      return visitor.getDrinkPrice();
   }

   public String process(IRequest request, double priceInEuros) {
      double drinkPrice = getDrinkPrice(request);
      final int sugarQuantity = request.getSugarQuantity();

      return priceInEuros >= drinkPrice ? new StringBuilder("Drink maker makes 1 ")
        .append(request.getDrinkName().toLowerCase())
        .append(" with ")
        .append(sugarQuantity > 0 ? sugarQuantity + " sugar and a stick" : "no sugar - and therefore no stick")
        .toString() :
        "Not enough money: " + Math.round((drinkPrice - priceInEuros) * 10)/10. + " euros still missing";
   }
}
