package sugarcrm;


/**
 * Date: 2012/06/27
 * <p/>
 * The source, with you may it be old master.
 */
public class Main {

   public static void main(String[] args) {
      SugarAPI sugarAPI = new SugarAPI();
      String session;
      try {
         session = sugarAPI.login("admin", "helmet");
         System.out.println("session=" + session   );
         System.out.println(sugarAPI.getServerInfo());
//         sugarAPI.getFieldModules(session, "sales", new ArrayList<String>());

         String id = sugarAPI.setCustomer(session, "Bruce", "Chong");
         sugarAPI.getContact(session, id);
         sugarAPI.updateContact(session, id, "27829641429");
         sugarAPI.getContacts(session);
         System.out.println(sugarAPI.logout(session));
      } catch (Exception e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
   }
}
