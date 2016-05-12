import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ImmutableListMultimap;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class Agent {

   private static Instrumentation inst;

   public static void premain(final String agentArgs, Instrumentation inst){
      Agent.inst = inst;
      System.out.printf("premain called");

      inst.addTransformer(new ClassFileTransformer() {
         public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
            ClassPool cp = ClassPool.getDefault();
            try {
               if(className.equals("Application")){
                  final CtClass ctClass = cp.get("Application");
                  final CtMethod ctMethod = ctClass.getDeclaredMethod("hello");
                  ctMethod.insertBefore("return \"Bye\";");
                  classfileBuffer = ctClass.toBytecode();
                  ctClass.detach();
               }
            } catch (Exception e) {
               e.printStackTrace();
            }

            return classfileBuffer;
         }
      });
   }

   public static void packagesClasses(){
      final ImmutableListMultimap<String, Class> index = FluentIterable.of(inst.getAllLoadedClasses()).index(new Function<Class, String>() {
         public String apply(Class input) {
            return input.getPackage().getName();
         }
      });


   }


}
