package murex.dojo.coffeemachine.requests;

import murex.dojo.coffeemachine.DrinkFactory;
import murex.dojo.coffeemachine.requests.IRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChocolateRequestTest {

   @Test
   public void chocolate_without_sugar() {
      IRequest chocolateRequest = DrinkFactory.getInstance().newChocolateRequestBuilder()
        .build();

      assertEquals(0, chocolateRequest.getSugarQuantity());
      assertEquals("Chocolate", chocolateRequest.getDrinkName());
   }

   @Test
   public void chocolate_with_sugar() {
      IRequest chocolateRequest = DrinkFactory.getInstance().newChocolateRequestBuilder()
        .withSugar(2)
        .build();

      assertEquals(2, chocolateRequest.getSugarQuantity());
      assertEquals("Chocolate", chocolateRequest.getDrinkName());
   }
}
