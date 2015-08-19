package murex.dojo.coffeemachine.requests;

public interface IChocolateRequestBuilder {

   IChocolateRequestBuilder withSugar(int sugar);

   IRequest build();
}
