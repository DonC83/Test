package cellTableExample.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CellTableExampleServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
