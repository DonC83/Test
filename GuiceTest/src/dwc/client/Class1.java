package dwc.client;

import javax.inject.Inject;

/**
 * Date: 2012/07/11
 * <p/>
 * The source, with you may it be old master.
 */
public class Class1 {
   @Inject
   private Class2 class2;

   @Inject
   private Class3 class3;

   public Class1() {
      System.out.println(class2);
      System.out.println(class3);

   }

   public void doSomething() {
      System.out.println(class2);
      System.out.println(class3);
   }
}
