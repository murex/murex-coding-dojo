package murex.dojo.coffeemachine.requests;

import murex.dojo.coffeemachine.IRequestVisitor;

public interface IRequest {

   int getSugarQuantity();

   String getDrinkName();

   void accept(IRequestVisitor visitor);
}
