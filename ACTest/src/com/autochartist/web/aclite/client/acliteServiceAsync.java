package com.autochartist.web.aclite.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface acliteServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
