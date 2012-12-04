package openerp;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 2012/07/02
 * <p/>
 * The source, with you may it be old master.
 */
public class Main {

   public static void main(String[] args) {

      try {
         OpenERPClient client = new OpenERPClient("http://192.168.0.8:8069/xmlrpc/","openerp2", "admin", "admin");
         OpenErpCrmAPI crmApi = new OpenErpCrmAPI(client);
//         crmApi.createLead("Quote", 1000d, "Finalise");
//
//         OpenErpResAPI resApi = new OpenErpResAPI(client);
//         resApi.createNewPartner("Hellfire");
//         resApi.findPartner("Hellfire");

//         List<AbstractMap> res = resApi.getPartner(3);
//         for (Map m : res) {
//            System.out.println(m.get("name"));
//         }

//         int id = resApi.findPartner("Hellfire2");
//         OpenERPObject obj = new OpenERPObject(client);
//
//         resApi.updatePartner(id, "Hellfire2");

         OpenErpProductAPI productAPI = new OpenErpProductAPI(client);
         List<Integer> ids = productAPI.getProducts();
         productAPI.getProducts(ids);
//         Object [] res2 = obj.search(new Object[]{new Object []{"name", "=", "Hellfire"}}, "res.partner");
//        / System.out.println(res2[0]);

      } catch (Exception e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
   }
}
