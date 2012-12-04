package quartz;

/**
 * Date: 2012/06/26
 * <p/>
 * The source, with you may it be old master.
 */
public class ResourceTest {

   public static void main(String[] args) {
      System.out.println(ResourceTest.class.getClassLoader().getResource("quartz.properties"));
      System.out.println(ResourceTest.class.getClassLoader().getResource("events/x.properties"));
      System.out.println(ResourceTest.class.getClassLoader().getResource("h.html"));
      System.out.println(ResourceTest.class.getClassLoader().getResource("y.xml"));
      System.out.println(ResourceTest.class.getClassLoader().getResource("a.json"));
      System.out.println(ResourceTest.class.getClassLoader().getResource("a.a"));
      System.out.println(ResourceTest.class.getClassLoader().getResource("b.txt"));
   }
}
