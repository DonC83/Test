package sugarcrm;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Date: 2012/06/27
 * <p/>
 * The source, with you may it be old master.
 */
public class ApiIntegrate {

   public static void main(String[] args) {
      ClientConfig cc = new DefaultClientConfig();
      cc.getClasses().add(JacksonJsonProvider.class);

      Client client = Client.create(cc);

      WebResource resource = client.resource("http://localhost/sugarcrm/service/v2/rest.php");


      MultivaluedMap formData = new MultivaluedMapImpl();
      formData.add("method", "login");
      formData.add("input_type", "json");
      formData.add("response_type", "json");
      formData.add("username", "donovan");
      formData.add("password", "helmet");
      String restdata = "{\"user_auth\":{\"user_name\":\"admin\",\"password\":\"17b9183a08e7111fc6a38a4354fa6e92\"},\"application\":\"application_name\"}";
      formData.add("rest_data", restdata);



      ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, formData);


      try {
         Gson gson = new Gson();
         String s = login("admin", "helmet", "http://localhost/sugarcrm/service/v2/rest.php");
         System.out.println(s);
         JsonObject obj = gson.fromJson(s, JsonObject.class);
         System.out.println(obj.get("id"));

      } catch (Exception e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
   }


   public static String httpPost(String urlStr) throws Exception {
      URL url = new URL(urlStr);
      HttpURLConnection conn =
              (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("POST");
      conn.setDoOutput(true);
      conn.setDoInput(true);
      conn.setUseCaches(false);
      conn.setAllowUserInteraction(false);
      conn.setRequestProperty("Content-Type",
              "application/x-www-form-urlencoded");

      if (conn.getResponseCode() != 200) {
         throw new IOException(conn.getResponseMessage());
      }
      // Buffer the result into a string
      BufferedReader rd = new BufferedReader(
              new InputStreamReader(conn.getInputStream()));
      StringBuilder sb = new StringBuilder();
      String line;
      while ((line = rd.readLine()) != null) {
         sb.append(line);
      }
      rd.close();

      conn.disconnect();
      return sb.toString();
   }

   public static String login(String userName, String password, String baseURL) throws Exception {
      String password1 = encryptor(password);

      JSONObject jso = new JSONObject();
      jso.put("user_name", userName);
      jso.put("password", password1);

      JSONObject jso2 = new JSONObject();
      jso2.put("user_auth", jso);
      jso2.put("application", "application_name");

      String mockdata = jso2.toString();
      String data = null;
      String baseurl = baseURL;


      System.out.println(baseurl+"?method=login&input_type=json&response_type=json&rest_data="+mockdata);

      data = httpPost(baseurl+"?method=login&input_type=json&response_type=json&rest_data="+mockdata);


//      String sessionid = jsondata.getString("id");

//      return sessionid;
      return data;
   }

   public static String encryptor(String password)
   {
      String pwd = password;

      String temppass = null;

      byte[] defaultBytes = pwd.getBytes();
      try{
         MessageDigest algorithm = MessageDigest.getInstance("MD5");
         algorithm.reset();
         algorithm.update(defaultBytes);
         byte messageDigest[] = algorithm.digest();

         StringBuffer hexString = new StringBuffer();
         for (int i=0;i<messageDigest.length;i++) {
            hexString.append(String.format("%02x", 0xFF & messageDigest[i])); // formatting to have the leading zeros
         }
         temppass = hexString.toString();
      }catch(NoSuchAlgorithmException e){
         System.out.println("No Such Algorithm found");
      }

      return temppass;
   }


}
