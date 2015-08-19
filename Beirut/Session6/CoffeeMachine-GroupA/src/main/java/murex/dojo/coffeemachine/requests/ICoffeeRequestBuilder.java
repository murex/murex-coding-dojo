package murex.dojo.coffeemachine.requests;

public interface ICoffeeRequestBuilder {

   ICoffeeRequestBuilder withSugar(int sugar);
   ICoffeeRequestBuilder extraHot(int extraHot);

   IRequest build();
}
