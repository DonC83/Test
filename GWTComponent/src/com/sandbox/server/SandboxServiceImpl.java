package com.sandbox.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.sandbox.client.sandboxService;

public class SandboxServiceImpl extends RemoteServiceServlet implements sandboxService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}