package murex.dojo.coffeemachine;

import murex.dojo.coffeemachine.requests.IRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoffeeMachineTest {

   @Test
   public void tea_without_sugar() {
      ICoffeeMachine coffeeMachine = new CoffeeMachine();
      IRequest request = DrinkFactory.getInstance().newTeaRequestBuilder().build();
      String result = coffeeMachine.process(request, 0.4);

      assertEquals("Drink maker makes 1 tea with no sugar - and therefore no stick", result);
   }

   @Test
   public void coffee_with_sugar_not_enough_money() {
      ICoffeeMachine coffeeMachine = new CoffeeMachine();
      IRequest request = DrinkFactory.getInstance().newCoffeeRequestBuilder().withSugar(1).build();
      String result = coffeeMachine.process(request, 0.4);

      assertEquals("Not enough money: 0.2 euros still missing", result);
   }

}
