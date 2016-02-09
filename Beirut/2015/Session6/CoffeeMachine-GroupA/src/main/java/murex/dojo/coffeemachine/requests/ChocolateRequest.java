package murex.dojo.coffeemachine.requests;

import murex.dojo.coffeemachine.IRequestVisitor;

public final class ChocolateRequest implements IRequest {

   private final int sugar;

   public ChocolateRequest(Builder builder) {
      sugar = builder.sugar;
   }

   public int getSugarQuantity() {
      return sugar;
   }

   public String getDrinkName() {
      return "Chocolate";
   }

   public void accept(IRequestVisitor visitor) {
      visitor.visit(this);
   }

   public static final class Builder implements IChocolateRequestBuilder {

      private int sugar;

      public IChocolateRequestBuilder withSugar(int sugar) {
         this.sugar = sugar;
         return this;
      }

      public IRequest build() {
         return new ChocolateRequest(this);
      }
   }
}
