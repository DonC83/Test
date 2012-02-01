package cellTableExample.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("CellTableExampleService")
public interface CellTableExampleService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use CellTableExampleService.App.getInstance() to access static instance of CellTableExampleServiceAsync
     */
    public static class App {
        private static CellTableExampleServiceAsync ourInstance = GWT.create(CellTableExampleService.class);

        public static synchronized CellTableExampleServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
