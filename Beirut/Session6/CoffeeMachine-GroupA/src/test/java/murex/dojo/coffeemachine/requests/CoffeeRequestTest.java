package murex.dojo.coffeemachine.requests;

import murex.dojo.coffeemachine.DrinkFactory;
import murex.dojo.coffeemachine.requests.IRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoffeeRequestTest {

   @Test
   public void coffee_without_sugar() {
      IRequest coffeeRequest = DrinkFactory.getInstance().newCoffeeRequestBuilder()
        .build();

      assertEquals(0, coffeeRequest.getSugarQuantity());
      assertEquals("Coffee", coffeeRequest.getDrinkName());
   }

   @Test
   public void coffee_with_sugar() {
      IRequest coffeeRequest = DrinkFactory.getInstance().newCoffeeRequestBuilder()
        .withSugar(2)
        .build();

      assertEquals(2, coffeeRequest.getSugarQuantity());
      assertEquals("Coffee", coffeeRequest.getDrinkName());
   }
}
