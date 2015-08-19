package murex.dojo.coffeemachine;

import murex.dojo.coffeemachine.requests.IRequest;

public interface ICoffeeMachine {

   String process(IRequest request, double priceInEuros);
}
