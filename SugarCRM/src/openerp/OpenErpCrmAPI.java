package openerp;

import org.apache.xmlrpc.client.XmlRpcClient;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2012/07/02
 * <p/>
 * The source, with you may it be old master.
 */
public class OpenErpCrmAPI {

   private OpenERPClient client;

   public OpenErpCrmAPI(OpenERPClient client) throws Exception {
      this.client = client;
      this.client.setDomain("object");
   }

   public void createLead(String opportunity, Double expectedRevenue, String nextAction) {
      Map<String, Object> data = new HashMap<String, Object>();
      data.put("name", opportunity);
      data.put("planned_revenue", expectedRevenue);
      data.put("title_action", nextAction);

      Object [] params = new Object [] {client.getDbName(), client.getUid(), client.getPassword(),
              "crm.lead", "create", data };
      try {
         client.execute(params);
      } catch (Exception e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
   }

}
