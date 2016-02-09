import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

public class Dependency {

   private ImmutableMap<String, List<String>> dependencies;
   private Set<String> popped = Sets.newHashSet() ;

   public Dependency(ImmutableMap<String, List<String>> dependencies) {
      this.dependencies = dependencies;
   }

   public Set<String> compute(String source) {
      Set<String> result = resolveDependencies(source);
      result.remove(source) ;
      return result ;
   }


   private Set<String> resolveDependencies(String source) {
      Set<String> result = Sets.newHashSet();

      if(!popped.contains(source)) {
         popped.add(source) ;
         if (dependencies.get(source) != null) {
            for (String dependency : dependencies.get(source)) {
               result.add(dependency);
               result.addAll(resolveDependencies(dependency));
            }
         }
         return result;
      }
      return result;

   }

}
