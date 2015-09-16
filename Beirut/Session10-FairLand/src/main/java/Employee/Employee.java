package Employee;

import com.google.common.collect.Lists;

import java.util.List;

public final class Employee {

   private final int id;
   private final int salary;
   private final List<Integer> directReportsIds;
   private final int manager;

   public Employee(int id, int salary, int manager) {
      this.id = id;
      this.salary = salary;
      this.directReportsIds = Lists.newArrayList();
      this.manager=manager;
   }

   public int salary() {
      return salary;
   }
   public int manager (){
      return manager;
   }
}
