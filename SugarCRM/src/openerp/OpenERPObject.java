package openerp;

import java.util.AbstractMap;
import java.util.List;
import java.util.Vector;

/**
 * Date: 2012/06/29
 * <p/>
 * The source, with you may it be old master.
 */
public class OpenERPObject {
   private OpenERPClient client;

   public OpenERPObject(OpenERPClient client)
           throws Exception
   {
      this.client = client;
      this.client.setDomain("object");
   }

   public Object[] search(Object[] where, String resource) throws Exception {
      Object[] params = { this.client.getDbName(), this.client.getUid(), this.client.getPassword(), resource, "search", where };

      Object res = this.client.execute(params);
      if ((res instanceof Object[])) {
         return (Object[])(Object[])res;
      }
      return null;
   }

   public AbstractMap read(int id, Object[] fields, String resource) throws Exception {
      List v = read(new Object[] { Integer.valueOf(id) }, fields, resource);
      if (v.size() == 1) {
         return (AbstractMap)v.get(0);
      }
      return null;
   }

   public List<AbstractMap> read(Object[] ids, Object[] fields, String resource) throws Exception {
      Object[] params = { this.client.getDbName(), this.client.getUid(), this.client.getPassword(), resource, "read", ids, fields };

      Object result = this.client.execute(params);
      if (!(result instanceof Object[])) {
         return null;
      }
      Object[] results = (Object[])(Object[])result;
      if (results.length < 1) {
         return null;
      }
      if (!(results[0] instanceof AbstractMap)) {
         return null;
      }
      return getVector(results);
   }

   public List<AbstractMap> searchRead(Object[] where, Object[] fields, String resource) throws Exception {
      Object[] results = search(where, resource);
      if ((results == null) || (results.length == 0)) {
         return null;
      }
      return read(results, fields, resource);
   }

   public Object create(AbstractMap map, String resource) throws Exception {
      Object[] params = { this.client.getDbName(), this.client.getUid(), this.client.getPassword(), resource, "create", map };

      return this.client.execute(params);
   }

   public Object update(Object[] ids, AbstractMap map, String resource) throws Exception {
      Object[] params = { this.client.getDbName(), this.client.getUid(), this.client.getPassword(), resource, "write", ids, map };

      return this.client.execute(params);
   }

   public Object execute(Object[] args) throws Exception {
      Object[] params = new Object[3 + args.length];
      params[0] = this.client.getDbName();
      params[1] = this.client.getUid();
      params[2] = this.client.getPassword();
      for (int i = 3; i < params.length; i++) {
         params[i] = args[(i - 3)];
      }
      return this.client.execute(params);
   }

   private List<AbstractMap> getVector(Object[] objs) {
      Vector vect = new Vector();
      for (Object obj : objs) {
         if ((obj instanceof AbstractMap)) {
            vect.add((AbstractMap)obj);
         }
      }
      return vect;
   }
}
