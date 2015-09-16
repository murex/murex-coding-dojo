import Employee.Employee;
import com.google.common.collect.Lists;

import java.util.List;

public class Company {

   private final int numberOfEmployees;
   private final int salaryDifference;

   private Company(Builder builder) {
      this.numberOfEmployees = builder.numberOfEmployees;
      this.salaryDifference = builder.salaryDifference;
   }

   public void addManager(Employee employee) {

   }

   public int employeesToKeep() {
      return 1;
   }

   private static final class SalaryData {
      private int s0;
      private int as;
      private int cs;
      private int rs;


      public SalaryData(int s0, int as, int cs, int rs) {
         this.s0 = s0;
         this.as = as;
         this.cs = cs;
         this.rs = rs;
      }
   }

   private static final class ManagerData {
      private int m0;
      private int am;
      private int cm;
      private int rm;


      public ManagerData(int m0, int am, int cm, int rm) {
         this.m0 = m0;
         this.am = am;
         this.cm = cm;
         this.rm = rm;
      }
   }

   public static final class Builder {

      private final int numberOfEmployees;
      private final int salaryDifference;
      private SalaryData salaryData;
      private ManagerData managerData;

      public Builder(int numberOfEmployees, int salaryDifference) {
         this.numberOfEmployees = numberOfEmployees;
         this.salaryDifference = salaryDifference;
      }

      public Builder withSalaryData(int s0, int as, int cs, int rs) {
         this.salaryData = new SalaryData(s0, as, cs, rs);
         return this;
      }

      public Builder withManagerData(int m0, int am, int cm, int rm) {
         this.managerData = new ManagerData(m0, am, cm, rm);
         return this;
      }

      public Company build() {
         List<Employee> employees = Lists.newArrayList();
         employees.add(new Employee(0, salaryData.s0,managerData.m0));

         for (int employeeId = 1; employeeId < numberOfEmployees; employeeId++) {
            Employee previousEmployee = employees.get(employeeId-1);

            int salary = (previousEmployee.salary() * salaryData.as + salaryData.cs) % salaryData.rs;
            int manager = ((previousEmployee.manager()* managerData.am + managerData.cm) & managerData.rm) % employeeId;
            Employee currentEmployee = new Employee(employeeId, salary, manager);
            employees.add(currentEmployee);

         }
         Company company = new Company(this);

         return company;

      }
   }
}
