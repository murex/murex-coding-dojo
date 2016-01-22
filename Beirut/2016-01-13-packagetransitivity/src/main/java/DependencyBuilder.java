import java.util.Arrays;
import java.util.List;

import com.google.common.collect.ImmutableMap;

public class DependencyBuilder {
   ImmutableMap.Builder<String, List<String>> dependenciesMap = ImmutableMap.builder();

   private DependencyBuilder(){

   }

   public static DependencyBuilder dependencyBuilder(){
      return new DependencyBuilder();
   }

   public DependencyBuilder addDependency(String source, String... dependencies) {
      dependenciesMap.put(source, Arrays.asList(dependencies));
      return this;
   }


   public Dependency build() {
      return new Dependency(dependenciesMap.build());
   }
}
