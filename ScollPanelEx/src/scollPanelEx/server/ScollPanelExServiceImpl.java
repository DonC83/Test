package scollPanelEx.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import scollPanelEx.client.ScollPanelExService;

public class ScollPanelExServiceImpl extends RemoteServiceServlet implements ScollPanelExService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}