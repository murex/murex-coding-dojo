package murex.dojo.coffeemachine;

import murex.dojo.coffeemachine.requests.ChocolateRequest;
import murex.dojo.coffeemachine.requests.CoffeeRequest;
import murex.dojo.coffeemachine.requests.IChocolateRequestBuilder;
import murex.dojo.coffeemachine.requests.ICoffeeRequestBuilder;
import murex.dojo.coffeemachine.requests.ITeaRequestBuilder;
import murex.dojo.coffeemachine.requests.TeaRequest;

public class DrinkFactory {

   private static DrinkFactory INSTANCE = new DrinkFactory();

   private DrinkFactory() {
   }

   public static DrinkFactory getInstance() {
      return INSTANCE;
   }

   public ITeaRequestBuilder newTeaRequestBuilder() {
      return new TeaRequest.Builder();
   }

   public IChocolateRequestBuilder newChocolateRequestBuilder() {
      return new ChocolateRequest.Builder();
   }

   public ICoffeeRequestBuilder newCoffeeRequestBuilder() {
      return new CoffeeRequest.Builder();
   }
}
