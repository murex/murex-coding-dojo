package murex.dojo.coffeemachine.requests;

public interface ITeaRequestBuilder {

   ITeaRequestBuilder withSugar(int sugar);

   IRequest build();
}
