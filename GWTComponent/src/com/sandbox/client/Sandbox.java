package com.sandbox.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.sandbox.client.components.CustomGrid;
import com.sandbox.client.components.DynaTable;
import com.sandbox.client.components.NotificationPanel;
import com.sandbox.client.model.Notification;

import java.util.ArrayList;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class Sandbox implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        VerticalPanel vPanel = new VerticalPanel();

//        Label lbl1 = new Label("notifications");
//
//        final List<Notification> nList = new ArrayList<Notification>();
//        nList.add(new Notification(11,"This is a test message 1"));
//        nList.add(new Notification(21,"This is a test message 2"));
//        nList.add(new Notification(31,"This is a test message 3"));
//        nList.add(new Notification(41,"This is a test message 4"));
//
//        lbl1.addClickHandler(new ClickHandler() {
//            public void onClick(ClickEvent event) {
//                NotificationPanel np = new NotificationPanel();
//                np.addNotifications(nList);
//                np.addCloseHandler(new CloseHandler<PopupPanel>() {
//                    @Override
//                    public void onClose(CloseEvent<PopupPanel> event) {
//
//                    }
//                });
//            }
//        });
//
//        vPanel.add(lbl1);

//        DynaTable dt = new DynaTable();
//        vPanel.add(dt);

//        HeaderPanel headerPanel = new HeaderPanel();
//
//
//        headerPanel.setHeaderWidget(new Label("bdjfklsafa"));
//
//        headerPanel.setContentWidget(new Label("content"));
//
//        headerPanel.setFooterWidget(new Label("footer"));

        HeaderPanel headerPanel = new CustomGrid().getHeaderPanel();

        // Assume that the host HTML has elements defined whose
        // IDs are "slot1", "slot2".  In a real app, you probably would not want
        // to hard-code IDs.  Instead, you could, for example, search for all
        // elements with a particular CSS class and replace them with widgets.
        //
        RootPanel.get("main").add(headerPanel);
    }

    private static class MyAsyncCallback implements AsyncCallback<String> {
        private Label label;

        public MyAsyncCallback(Label label) {
            this.label = label;
        }

        public void onSuccess(String result) {
            label.getElement().setInnerHTML(result);
        }

        public void onFailure(Throwable throwable) {
            label.setText("Failed to receive answer from server!");
        }
    }
}
