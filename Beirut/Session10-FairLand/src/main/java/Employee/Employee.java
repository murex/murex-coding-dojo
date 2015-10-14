package Employee;

import com.google.common.collect.Lists;

import java.util.List;

public final class Employee {

   private final int id;
   private final int salary;
   private final List<Integer> directReportsIds;
   private final int manager;
   private final int m;

   public Employee(int id, int salary, int manager, int m) {
      this.id = id;
      this.salary = salary;
      this.directReportsIds = Lists.newArrayList();
      this.manager=manager;
      this.m = m ;
   }

   public int salary() {
      return salary;
   }
   public int manager (){
      return manager;
   }

   public int getM() {
      return m;
   }

   public void addDirectReport(int employeeId) {
      directReportsIds.add(employeeId);
   }

   public List<Integer> directReports() {
      return directReportsIds;
   }
}
