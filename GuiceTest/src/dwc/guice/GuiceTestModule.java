package dwc.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import dwc.client.Class1;
import dwc.client.Class2;
import dwc.client.Class2Impl;
import dwc.client.Class3;

/**
 * Date: 2012/07/11
 * <p/>
 * The source, with you may it be old master.
 */
public class GuiceTestModule extends AbstractModule {
   @Override
   protected void configure() {
      bind(Class1.class).asEagerSingleton();
      bind(Class2.class).to(Class2Impl.class);
      bind(Class3.class).in(Scopes.SINGLETON);
   }
}
