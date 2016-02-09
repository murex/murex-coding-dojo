package murex.dojo.coffeemachine.requests;

import murex.dojo.coffeemachine.IRequestVisitor;
import murex.dojo.coffeemachine.PriceRequestVisitor;

public final class TeaRequest implements IRequest {

   private final int sugar;

   public TeaRequest(Builder builder) {
      sugar = builder.sugar;
   }

   public int getSugarQuantity() {
      return sugar;
   }

   public String getDrinkName() {
      return "Tea";
   }

   public void accept(IRequestVisitor visitor) {
      visitor.visit(this);
   }

   public static class Builder implements ITeaRequestBuilder {

      private int sugar;

      public IRequest build() {
         return new TeaRequest(this);
      }

      public ITeaRequestBuilder withSugar(int sugar) {
         this.sugar = sugar;
         return this;
      }
   }
}
