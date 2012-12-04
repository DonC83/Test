package openerp;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 2012/07/05
 * <p/>
 * The source, with you may it be old master.
 */
public class OpenErpProductAPI {

    private OpenERPClient client;

   public OpenErpProductAPI(OpenERPClient client) {
      this.client = client;
   }

   public List<Integer> getProducts() {
      Object [] where = new Object[] {"id", ">",0};
      Object [] params = new Object [] {client.getDbName(), client.getUid(), client.getPassword(),
              "product.product", OpenERPClient.METHOD_SEARCH, new Object[]{where}};
      List<Integer> res = null;
      try {
         Object[] results = (Object[])(Object[])client.execute(params);
         if (results.length<1) {
            return null;
         }
         res = new ArrayList<Integer>();
         for (Object obj : results) {
            if (obj instanceof Integer) {
               res.add((Integer) obj);
            }
         }
      } catch (Exception e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
      return res;
   }


    public List<Object> getProducts(List<Integer> ids) throws Exception {
      Object [] fields = new Object[]{"id", "default_code", "name_template"};
      List<Object> productList = null;
      Object [] params = new Object [] {client.getDbName(), client.getUid(), client.getPassword(),
               "product.product", OpenERPClient.METHOD_READ, ids.toArray(), fields};

      Object [] results = (Object[])(Object[])client.execute(params);
      List<AbstractMap> res = new ArrayList<AbstractMap>();
       AbstractMap map;
      for(Object obj : results) {
         if (obj instanceof AbstractMap) {
            map = (AbstractMap)obj;
            System.out.println(map.get("id"));
            System.out.println(map.get("default_code"));
            System.out.println(map.get("name_template"));
         }
      }

      return productList;
   }


}
