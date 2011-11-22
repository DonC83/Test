package scollPanelEx.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ScollPanelExServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
