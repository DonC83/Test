package client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2012/06/20
 * <p/>
 * The source, with you may it be old master.
 */
public class ClientTest {

   public static void main(String[] args) throws UnsupportedEncodingException {


      DefaultHttpClient httpClient = new DefaultHttpClient();


      List<NameValuePair> formparams = new ArrayList<NameValuePair>();
      formparams.add(new BasicNameValuePair("username", "grant@guruhut.com"));
      formparams.add(new BasicNameValuePair("password", "grant"));
      UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
      HttpPost httppost = new HttpPost("http://localhost:8080/ajax_login");
      httppost.setEntity(entity);


//      try {
//         HttpResponse response = httpClient.execute(httppost);
//         System.out.println(response.getStatusLine().getStatusCode());
//         List<Cookie> cookies = httpClient.getCookieStore().getCookies();
//         for (Cookie c : cookies) {
//            System.out.println(c.getValue());
//            System.out.println(c.getName());
//         }
//      } catch (IOException e) {
//         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//      }

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
