package openerp;

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.URL;
import java.util.Map;

/**
 * Date: 2012/06/29
 * <p/>
 * The source, with you may it be old master.
 */
public class OpenERPClient extends XmlRpcClient {

   public static final String METHOD_READ = "read";
   public static final String METHOD_CREATE = "create";
   public static final String METHOD_SEARCH = "search";
   public static final String METHOD_UPDATE = "write";


   private String server;
   private String dbName;
   private String username;
   private String password;
   private Integer uid;
   private XmlRpcClientConfigImpl config;

   public OpenERPClient(String server, String dbName, String username, String password)
           throws Exception {
      this.server = server;
      this.dbName = dbName;
      this.username = username;
      this.password = password;
      this.config = new XmlRpcClientConfigImpl();
      this.config.setServerURL(new URL(getServer() + "common"));
      setConfig(this.config);
      Object[] params = { getDbName(), getUsername(), getPassword() };
      Object res = login(params);
      if (!res.toString().equals("false"))
         this.uid = Integer.valueOf(Integer.parseInt(res.toString()));
   }

   public String getServer() {
      return server;
   }

   public void setServer(String server) {
      this.server = server;
   }

   public String getDbName() {
      return dbName;
   }

   public void setDbName(String dbName) {
      this.dbName = dbName;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public Integer getUid() {
      return uid;
   }

   public void setUid(Integer uid) {
      this.uid = uid;
   }

   protected void setDomain(String domain) throws Exception {
      this.config.setServerURL(new URL(this.server + domain));
   }

   public Object execute(Object[] params) throws Exception {
      return execute("execute", params);
   }

   private Object login(Object[] params) throws Exception {
      return execute("login", params);
   }

   public Object report(Object[] params) throws Exception {
      return execute("report", params);
   }

   public Object report_get(Object[] params) throws Exception {
      return execute("report_get", params);
   }

//   public  Object [] getParams(String resource, String method, Map data) {
//      Object [] params = new Object [] {getDbName(), getUid(), getPassword(),
//              resource, method, data};
//      return params;
//   }
//
//   public  Object [] getParams(String resource, String method, Map data, Object [] fields) {
//      Object [] params = new Object [] {getDbName(), getUid(), getPassword(),
//              resource, method, data, fields};
//      return params;
//   }


}
