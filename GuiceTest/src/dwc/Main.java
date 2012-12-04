package dwc;

import com.google.inject.Guice;
import com.google.inject.Injector;
import dwc.client.Class1;
import dwc.guice.GuiceTestModule;

/**
 * Date: 2012/07/11
 * <p/>
 * The source, with you may it be old master.
 */
public class Main {

   public static void main(String[] args) {
      Injector injector = Guice.createInjector(new GuiceTestModule());
      Class1 class1 = injector.getInstance(Class1.class);
      System.out.println(class1);
      class1.doSomething();
   }
}
