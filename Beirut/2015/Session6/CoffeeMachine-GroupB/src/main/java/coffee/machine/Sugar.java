package coffee.machine;

public class Sugar {
   private final int sugarCubes;

   public Sugar(int sugarCubes) {
      this.sugarCubes = sugarCubes;
   }

   public String getSugarMessage(){
      if(sugarCubes==0){
         return "with no sugar and therefore no stick";
      }
      return "with "+ sugarCubes+ " sugars with stick";
   }
}
