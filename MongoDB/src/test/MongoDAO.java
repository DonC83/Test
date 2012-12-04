package test;

import com.mongodb.Mongo;

import java.net.UnknownHostException;

/**
 * Date: 2012/08/03
 * <p/>
 * The source, with you may it be old master.
 */
public class MongoDAO<T> {

   private Mongo mongo;

   public MongoDAO() throws UnknownHostException {
      mongo = new Mongo("localhost");
   }

   public void createRecord(T obj) {
      
   }
}
