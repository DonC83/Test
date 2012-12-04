package openerp;

import java.util.*;

/**
 * Date: 2012/07/02
 * <p/>
 * The source, with you may it be old master.
 */
public class OpenErpResAPI {


   private OpenERPClient client;

   public OpenErpResAPI(OpenERPClient client) throws Exception {
      this.client = client;
      this.client.setDomain("object");
   }

   public void createNewPartner(String name) {

      Map<String, String> data = new HashMap<String, String>();
      data.put("name", name);

      Object [] params = new Object [] {client.getDbName(), client.getUid(), client.getPassword(),
              "res.partner", OpenERPClient.METHOD_CREATE, data};
      try {
         client.execute(params);
      } catch (Exception e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
   }

   public void updatePartner(int id, String name) throws Exception {
      Map<String, String> data = new HashMap<String, String>();
            data.put("name", name);

      Object[] params = { this.client.getDbName(), this.client.getUid(), this.client.getPassword(), "res.partner", "write", new Object[]{id}, data };
      this.client.execute(params);
   }

   public List<AbstractMap> getPartner(int id) {
      Object [] fields = new Object[]{"name", "active", "employee", "supplier"};
      Object [] params = new Object [] {client.getDbName(), client.getUid(), client.getPassword(), "res.partner", "read", new Object[]{id}, fields};
      List<AbstractMap> res = null;
      try {
         Object[] results = (Object[])(Object[])client.execute(params);
         res = new ArrayList<AbstractMap>();
         for (Object obj : results) {
            if (obj instanceof AbstractMap) {
               res.add((AbstractMap)obj);
            }

         }
      } catch (Exception e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
      return res;
   }

   public Integer findPartner(String name) {
      Object [] where = new Object [] {"name", "=", name};
      Object [] params = new Object [] {client.getDbName(), client.getUid(), client.getPassword(),
              "res.partner", OpenERPClient.METHOD_SEARCH, new Object[] { where }};
      
      try {
         Object [] results = (Object[])(Object[])client.execute(params);
         if (results !=null){
            return (Integer)results[0];
         }
      } catch (Exception e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
      return null;
   }

}
