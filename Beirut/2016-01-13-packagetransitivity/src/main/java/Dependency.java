import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

public class Dependency {

   Set<String> result = Sets.newHashSet();
   private ImmutableMap<String, List<String>> dependencies;

   public Dependency(ImmutableMap<String, List<String>> dependencies) {
      this.dependencies = dependencies;
   }

   public Set<String> compute(String source) {
      return resolveDependencies(source);
   }

   private Set<String> resolveDependencies(String source) {
      Set<String> result = Sets.newHashSet();
      if(dependencies.get(source) != null){
         for (String dependency : dependencies.get(source)) {
            result.add(dependency);
            result.addAll(resolveDependencies(dependency));
         }
      }
      return result;
   }
}
