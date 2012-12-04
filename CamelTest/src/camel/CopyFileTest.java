package camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 * Date: 2012/06/21
 * <p/>
 * The source, with you may it be old master.
 */
public class CopyFileTest {

   public static void main(String[] args) throws Exception {
      CamelContext context = new DefaultCamelContext();
      context.addRoutes(new RouteBuilder() {
         @Override
         public void configure() throws Exception {
            from("file:/Users/donovan/test/folder1?noop=true").to("file:/Users/donovan/test/folder2");
         }
      });

      context.start();

      Thread.sleep(10000);

      context.stop();
   }


}
