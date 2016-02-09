package murex.dojo.coffeemachine;

import murex.dojo.coffeemachine.requests.ChocolateRequest;
import murex.dojo.coffeemachine.requests.CoffeeRequest;
import murex.dojo.coffeemachine.requests.TeaRequest;

public interface IRequestVisitor {

   void visit(CoffeeRequest request);

   void visit(ChocolateRequest request);

   void visit(TeaRequest request);
}
