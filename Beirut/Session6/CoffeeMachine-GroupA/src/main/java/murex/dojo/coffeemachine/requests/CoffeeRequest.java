package murex.dojo.coffeemachine.requests;

import murex.dojo.coffeemachine.IRequestVisitor;

public final class CoffeeRequest implements IRequest {

   private final int sugar;

   public CoffeeRequest(Builder builder) {
      sugar = builder.sugar;
   }

   public int getSugarQuantity() {
      return sugar;
   }

   public String getDrinkName() {
      return "Coffee";
   }

   public void accept(IRequestVisitor visitor) {
      visitor.visit(this);
   }

   public static final class Builder implements ICoffeeRequestBuilder {

      private int sugar;
      private int extraHot;

      public ICoffeeRequestBuilder withSugar(int sugar) {
         this.sugar = sugar;
         return this;
      }

      public ICoffeeRequestBuilder extraHot(int extraHot) {
         this.extraHot = extraHot;
         return this;
      }

      public IRequest build() {
         return new CoffeeRequest(this);
      }
   }
}
