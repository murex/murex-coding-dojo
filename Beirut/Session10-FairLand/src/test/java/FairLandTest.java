import Employee.Employee;
import org.fest.assertions.api.Assertions;
import org.junit.Test;

public class FairLandTest {
   @Test
   public void
   when_a_company_has_one_employee_then_it_is_the_ceo() {
      Company company = new Company.Builder(1, 395).build();

      Assertions.assertThat(company.employeesToKeep()).isEqualTo(1);
   }

   @Test
   public void
   when_a_company_has_six_employees_we_should_keep_only_three() {
      Company company = new Company.Builder(6, 5).withSalaryData(10, 1, 3, 17).withManagerData(5, 2, 7, 19).build();
      Assertions.assertThat(company.employeesToKeep()).isEqualTo(3);
   }

@Test
public void
when_a_company_has_two_employees_we_should_keep_them_for_now() {
   Company company = new Company.Builder(2, 5).withSalaryData(10, 1, 3, 17).withManagerData(5, 2, 7, 19).build();
   Assertions.assertThat(company.employeesToKeep()).isEqualTo(2);
}

}
