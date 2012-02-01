package cellTableExample.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import cellTableExample.client.CellTableExampleService;

public class CellTableExampleServiceImpl extends RemoteServiceServlet implements CellTableExampleService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}