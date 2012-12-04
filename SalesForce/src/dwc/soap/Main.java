package dwc.soap;

import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.SaveResult;
import com.sforce.soap.enterprise.sobject.Contact;
import com.sforce.soap.enterprise.sobject.SObject;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

/**
 * Date: 2012/07/12
 * <p/>
 * The source, with you may it be old master.
 */
public class Main {

   public static void main(String[] args) {
      ConnectorConfig connector = new ConnectorConfig();
      connector.setUsername("donovan@guruhut.com");
      connector.setPassword("helmet9853mZoLEOBLbD6xq5Je18UO4AD6");
//      connector.setTraceMessage(true);

      
      try {
         EnterpriseConnection connection = Connector.newConnection(connector);

         QueryResult result = connection.query("SELECT Id, FirstName, LastName, AccountId, Account.Name FROM Contact WHERE AccountId!=NULL ORDER BY CreatedDate DESC LIMIT 5");

         Contact c;
         if (result.getSize()>0) {
            for (SObject sObj : result.getRecords()) {
               c = (Contact)sObj;
               System.out.println(c.getId());
               System.out.println(c.getFirstName());
               System.out.println(c.getLastName());
               System.out.println(c.getAccountId());
               System.out.println(c.getAccount().getName());
            }
         }

         c = new Contact();
         c.setFirstName("Donovan");
         c.setLastName("Chong");
         c.setPhone("(27)82 963-1429");

         SObject [] obj = new SObject[1];
         obj[0] = c;

//         SaveResult[] saveResults = connection.create(obj);
//         System.out.println(saveResults[0]);
//
         
      } catch (ConnectionException e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
   }
}
