package openerp;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 * Date: 2012/06/28
 * <p/>
 * The source, with you may it be old master.
 */
public class OpenErpAPI {


   public static void main(String[] args) {
      OpenErpAPI api = new OpenErpAPI("192.168.0.27","openerp2", 8069, "admin", "admin");
//      List<String> dbs = api.getDatabaseList();
//      for (String s : dbs) {
//         System.out.println(dbs);
//      }

//      api.createNewPartner("Dexter");
//      api.createNewLead("Quotation", 2000.00, "Sale");
//      List<Integer> ids = new ArrayList<Integer>();
//      ids.add(1);
//      ids.add(2);
      api.getLead(1);

//      try {
//         OpenERPClient client = new OpenERPClient("http://192.168.0.27:8069/xmlrpc/", "openerp2", "admin", "admin");
//         OpenERPObject obj = new OpenERPObject(client);
//         Map m = obj.read(1, new Object[]{"name", "planned_revenue", "title_action"}, "crm.lead");
//         System.out.println(m.get("name"));
//      } catch (Exception e) {  
//         e.printStackTrace();
//      }

   }


   private static final String MODULE_COMMON = "common";
   private static final String MODULE_DB = "db";
   private static final String MODULE_OBJECT = "object";

   private XmlRpcClient client;
   private XmlRpcClientConfigImpl clientConfig;

   private String dbName;
   private String password;
   private int userId;
   private String baseURL;


   public OpenErpAPI(String host, String dbName, int port, String username, String password) {

      this.dbName = dbName;
      this.password = password;

      this.baseURL = "http://" + host + ":" + port + "/xmlrpc/";
      clientConfig = new XmlRpcClientConfigImpl();
      clientConfig.setEnabledForExtensions(true);
      client = new XmlRpcClient();
      this.userId = this.login(username, password);
   }


   protected Object execute(Object[] params) throws Exception {
      return client.execute("execute", params);
   }

   protected Object login(Object[] params) throws Exception {
      return client.execute("login", params);
   }

   protected Object report(Object[] params) throws Exception {
      return client.execute("report", params);
   }

   protected Object report_get(Object[] params) throws Exception {
      return client.execute("report_get", params);
   }


   public List<String> getDatabaseList() {
      List<String> dbs = new ArrayList<String>();
      try {
         clientConfig.setServerURL(new URL(baseURL + this.dbName));
         client.setConfig(clientConfig);
         Object [] result = (Object[])client.execute("list", new Object[]{});
         for (Object obj : result) {
            if (obj instanceof String) {
               dbs.add((String)obj);
            }
         }
      } catch (XmlRpcException e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      } catch (MalformedURLException e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
      return dbs;
   }

   private Integer login(String username, String password) {
      Integer id = null;
      Object[] params = new Object[] {dbName, username, password};
      try {
         clientConfig.setServerURL(new URL(baseURL + MODULE_COMMON));
         client.setConfig(clientConfig);
         id = (Integer)client.execute("login", params);
      } catch (XmlRpcException e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      } catch (MalformedURLException e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
      return id;
   }

   public void createNewPartner(String name) {

      Map<String, String> data = new HashMap<String, String>();
      data.put("name", name);

      Object[] params = new Object [] {dbName, userId, password, "res.partner", "create", data};
      try {
         this.execute(params, MODULE_OBJECT);
      } catch (MalformedURLException e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      } catch (XmlRpcException e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
   }

   public void createNewLead(String opportunity, Double expectedRevenue, String nextAction) {
      Map<String, Object> data = new HashMap<String, Object>();
      data.put("name", opportunity);
      data.put("planned_revenue", expectedRevenue);
      data.put("title_action", nextAction);

      Object [] params = new Object [] {dbName, userId, password, "crm.lead", "create", data };
      try {
         this.execute(params, MODULE_OBJECT);
      } catch (MalformedURLException e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      } catch (XmlRpcException e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
   }

   public List<AbstractMap> getLead(int id) {
      Object [] fields = new Object[]{"name", "planned_revenue", "title_action"};
      Object [] params = new Object [] {dbName, userId, password, "crm.lead", "read", new Object[]{id}, fields};
      List<AbstractMap> res = null;
      try {
         Object[] results = (Object[])(Object[])this.execute(params, MODULE_OBJECT);
         res = new ArrayList<AbstractMap>();
         for (Object obj : results) {
            if (obj instanceof AbstractMap) {
               res.add((AbstractMap)obj);
            }
         }
      } catch (MalformedURLException e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      } catch (XmlRpcException e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
      return res;
   }



   private Object execute(Object [] params, String module) throws MalformedURLException, XmlRpcException {
      clientConfig.setServerURL(new URL(baseURL + module));
      client.setConfig(clientConfig);
      return client.execute("execute", params);
   }

}
