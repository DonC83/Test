package scollPanelEx.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("ScollPanelExService")
public interface ScollPanelExService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use ScollPanelExService.App.getInstance() to access static instance of ScollPanelExServiceAsync
     */
    public static class App {
        private static ScollPanelExServiceAsync ourInstance = GWT.create(ScollPanelExService.class);

        public static synchronized ScollPanelExServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
