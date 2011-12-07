package com.autochartist.web.aclite.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("acliteService")
public interface acliteService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

    /**
     * Utility/Convenience class.
     * Use acliteService.App.getInstance() to access static instance of acliteServiceAsync
     */
    public static class App {
        private static acliteServiceAsync ourInstance = GWT.create(acliteService.class);

        public static synchronized acliteServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
