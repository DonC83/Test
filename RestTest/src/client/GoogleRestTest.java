package client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.core.MediaType;

/**
 * Date: 2012/06/21
 * <p/>
 * The source, with you may it be old master.
 */
public class GoogleRestTest {

   public static void main(String[] args) {
      ClientConfig cc = new DefaultClientConfig();
      cc.getClasses().add(JacksonJsonProvider.class);

      Client client = Client.create(cc);

      client.addFilter(new HTTPBasicAuthFilter("donovan@guruhut.com", "helmet"));
      WebResource resource = client.resource("http://localhost:8080/eapi/users/1000");

      ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);

      String s = response.getEntity(String.class);
      System.out.println(s);
   }


}
