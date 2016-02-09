package murex.dojo.coffeemachine;

import murex.dojo.coffeemachine.requests.ChocolateRequest;
import murex.dojo.coffeemachine.requests.CoffeeRequest;
import murex.dojo.coffeemachine.requests.TeaRequest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DrinkFactoryTest {

   @Test
   public void drink_factory_should_not_be_null() {
      assertNotNull(DrinkFactory.getInstance());
   }

   @Test
   public void drink_factory_should_build_a_tea_request() {
      assertEquals(TeaRequest.Builder.class, DrinkFactory.getInstance().newTeaRequestBuilder().getClass());
   }

   @Test
   public void drink_factory_should_build_a_coffee_request() {
      assertEquals(CoffeeRequest.Builder.class, DrinkFactory.getInstance().newCoffeeRequestBuilder().getClass());
   }

   @Test
   public void drink_factory_should_build_a_chocolate_request() {
      assertEquals(ChocolateRequest.Builder.class, DrinkFactory.getInstance().newChocolateRequestBuilder().getClass());
   }
}
