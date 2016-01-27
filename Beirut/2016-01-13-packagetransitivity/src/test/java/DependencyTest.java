import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Collections;
import java.util.Set;

import org.fest.assertions.api.IterableAssert;
import org.junit.Test;

import com.google.common.collect.Sets;

public class DependencyTest {

   @Test
   public void it_should_return_empty_dependencies_for_a_single_package(){
      assertDependencies("A", DependencyBuilder.dependencyBuilder(), Collections.EMPTY_SET);
   }

   @Test
   public void it_should_return_child_for_source_with_single_dependency(){
      DependencyBuilder dependencyBuilder = DependencyBuilder.dependencyBuilder()
        .addDependency("A", "B","C");
      assertDependencies("A", dependencyBuilder, Sets.newHashSet("B", "C"));
   }

   @Test
   public void it_should_return_dependencies_for_source_with_2_levels_dependency_with_one_dependency_each(){
      DependencyBuilder dependencyBuilder = DependencyBuilder.dependencyBuilder()
        .addDependency("A", "B")
        .addDependency("B","C");
      assertDependencies("A", dependencyBuilder,Sets.newHashSet("B", "C") );
   }

   @Test
   public void it_should_return_child_of_child_for_source_with_2_level_dependency_with_two_dependencies(){
      DependencyBuilder dependencyBuilder = DependencyBuilder.dependencyBuilder()
        .addDependency("A", "B","D")
        .addDependency("D","C");
      assertDependencies("A", dependencyBuilder, Sets.newHashSet("B", "D", "C"));
   }

   @Test
   public void it_should_avoid_cycles(){
      DependencyBuilder dependencyBuilder = DependencyBuilder.dependencyBuilder()
        .addDependency("A", "B")
        .addDependency("B","A");
      assertDependencies("A", dependencyBuilder, Sets.newHashSet("B"));
   }


   @Test
   public void acceptance_test(){
      DependencyBuilder dependencyBuilder = DependencyBuilder.dependencyBuilder()
        .addDependency("A", "B", "C")
        .addDependency("B", "C", "E")
        .addDependency("C", "G")
        .addDependency("D", "A", "F")
        .addDependency("E", "F")
        .addDependency("F", "H");

      assertDependencies("A", dependencyBuilder, Sets.newHashSet("B", "C", "E", "F", "G", "H"));
   }

   private IterableAssert assertDependencies(String source, DependencyBuilder dependencyBuilder, Set expected) {
      return assertThat(dependencyBuilder.build().compute(source)).isEqualTo(expected);
   }

}
