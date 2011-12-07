package com.autochartist.web.aclite.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.autochartist.web.aclite.client.acliteService;

public class acliteServiceImpl extends RemoteServiceServlet implements acliteService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}