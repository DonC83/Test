package sugarcrm;

import com.google.gson.Gson;
import org.codehaus.jackson.map.util.JSONPObject;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

/**
 * Date: 2012/06/27
 * <p/>
 * The source, with you may it be old master.
 */
public class SugarAPI {


   private static final String baseURL = "http://localhost/sugarcrm/service/v2/rest.php";

   public String login(String username, String password) throws Exception {
      String password1 = encryptPassword(password);

      JSONObject jso = new JSONObject();
      jso.put("user_name", username);
      jso.put("password", password1);

      JSONObject jso2 = new JSONObject();
      jso2.put("user_auth", jso);
      jso2.put("application", "application_name");

      String data = httpCall("login", jso2);
      Gson gson = new Gson();
      Map<String, String> results = gson.fromJson(data, Map.class);

      return results.get("id");
   }

   public String logout(String session) throws Exception {
      JSONObject jso = new JSONObject();
      jso.put("session", session);
      return httpCall("logout", jso);
   }

   public void getFieldModules(String session, String moduleName, List<String> fields) throws Exception {
      JSONObject jso = new JSONObject();
      jso.put("session", session);
      jso.put("module_name", moduleName);
      jso.put("fields", fields.toArray());

      String data = httpCall(baseURL + "?method=get_field_modules&input_type=json&response_type=json&rest_data=" + jso.toString());
      System.out.println(data);

   }

   public String getServerInfo() throws Exception {
      String data = httpCall(baseURL + "?method=get_server_info");
      return data;
   }

   private String httpCall(String method, JSONObject data) throws Exception {
      String url = baseURL + "?method=" + method + "&input_type=json&response_type=json&rest_data=" + data.toString();
      System.out.println(url);
      return httpCall(url);
   }

   private String httpCall(String urlStr) throws Exception {
      URL url = new URL(urlStr);
      HttpURLConnection conn =
              (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
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

   private String encryptPassword(String password) {
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


   public String setCustomer(String sessionId, String firstName, String lastName) throws Exception {
      JSONObject data = new JSONObject();
      JSONObject firstNameValue = new JSONObject();
      JSONObject lastNameValue = new JSONObject();

      firstNameValue.put("name", "first_name");
      firstNameValue.put("value", firstName);

      lastNameValue.put("name", "last_name");
      lastNameValue.put("value", lastName);

      JSONArray jsonArray = new JSONArray();
      jsonArray.put(firstNameValue);
      jsonArray.put(lastNameValue);

      data.put("session", sessionId);
      data.put("module_name", "Contacts");
      data.put("name_value_list", jsonArray);

      String res = httpCall("set_entry", data);
      Gson gson = new Gson();
      Map<String, String> results = gson.fromJson(res, Map.class);

      return results.get("id");
   }

   public void getContact(String sessionId, String id) throws Exception {
      JSONObject jso = new JSONObject();
      jso.put("session", sessionId);
      jso.put("module_name", "Contacts");
      jso.put("id", id);
      jso.put("select_fields", new JSONArray());
      jso.put("link_to_field_names_array", new JSONArray());
      String s = httpCall("get_entry", jso);
      System.out.println(s);
   }

   public void updateContact(String sessionId, String id, String phoneMobile) throws Exception {
      JSONObject data = new JSONObject();
      JSONObject firstNameValue = new JSONObject();
      JSONObject lastNameValue = new JSONObject();

      firstNameValue.put("name", "id");
      firstNameValue.put("value", id);

      lastNameValue.put("name", "phone_mobile");
      lastNameValue.put("value", phoneMobile);

      JSONArray jsonArray = new JSONArray();
      jsonArray.put(firstNameValue);
      jsonArray.put(lastNameValue);

      data.put("session", sessionId);
      data.put("module_name", "Contacts");
      data.put("name_value_list", jsonArray);

      String res = httpCall("set_entry", data);
      System.out.println(res);
      Gson gson = new Gson();
      Map<String, String> results = gson.fromJson(res, Map.class);

//      return results.get("id");
   }

   public void getContacts(String sessionId) throws Exception {
      JSONObject data = new JSONObject();
      data.put("session", sessionId);
      data.put("module_name", "Contacts");
      data.put("query", "contacts.first_name='Bruce'");
      System.out.println(httpCall("get_entry_list", data));
   }

}
