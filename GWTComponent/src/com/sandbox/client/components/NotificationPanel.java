package com.sandbox.client.components;

import com.google.gwt.event.dom.client.*;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.*;
import com.sandbox.client.model.Notification;

import java.util.List;

/**
 * GuruHut 2011 - May the source be with you young jedi !
 */
public class NotificationPanel extends PopupPanel {


    private VerticalPanel vPanel = new VerticalPanel();

    private VerticalPanel contentPanel = new VerticalPanel();

    private AcknowledgeInfoPanel ackPanel = new AcknowledgeInfoPanel();

    public NotificationPanel() {
        contentPanel.setStyleName("notif-content-panel");
        contentPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_TOP);

        vPanel.setStyleName("notif-panel");
        HorizontalPanel headerPanel = new HorizontalPanel();
        headerPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        headerPanel.setStyleName("notif-header-panel");

        Label lbl1 = new Label("Notifications");
        lbl1.setStyleName("notif-header-title");

        final Image imgClose = new Image("images/cross.png");
        imgClose.setStyleName("notif-close-img");
        imgClose.addClickHandler(new CloseClickHandler(this));
        imgClose.addMouseOverHandler(new MouseOverHandler() {
            @Override
            public void onMouseOver(MouseOverEvent event) {
                imgClose.setUrl("images/cross_hover.png");
            }
        });
        imgClose.addMouseOutHandler(new MouseOutHandler() {
            @Override
            public void onMouseOut(MouseOutEvent event) {
                imgClose.setUrl("images/cross.png");
            }
        });

        headerPanel.add(lbl1);
        headerPanel.add(imgClose);


        vPanel.add(headerPanel);
        vPanel.setCellHeight(headerPanel,"30px");

        vPanel.add(contentPanel);
        add(vPanel);
        setModal(true);
        center();
    }



    public void addNotifications(final List<Notification> notificationList) {

        boolean acknowledged = true;
        for (Notification n : notificationList) {
            if (!n.isAcknowledged()) {
                acknowledged = false;
            }
        }

        HorizontalPanel contentPanelHeader = new HorizontalPanel();
        contentPanelHeader.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
        contentPanelHeader.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
        final Label lbl1 = new Label("Acknowledge");
        lbl1.setStyleName("notif-ack-lbl");
        lbl1.addMouseOverHandler(new MouseOverHandler() {
            @Override
            public void onMouseOver(MouseOverEvent event) {
                ackPanel.showRelativeTo(lbl1);
            }
        });

        lbl1.addMouseOutHandler(new MouseOutHandler() {
            @Override
            public void onMouseOut(MouseOutEvent event) {
                ackPanel.hide();
            }
        });

        CheckBox chkBox = new CheckBox();
        chkBox.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
            @Override
            public void onValueChange(ValueChangeEvent<Boolean> event) {
                for (Notification n : notificationList) {
                    n.setAcknowledged(true);
                }
            }
        });

        contentPanelHeader.add(lbl1);
        contentPanelHeader.add(chkBox);
        contentPanel.add(contentPanelHeader);

        if (!acknowledged) {
            contentPanelHeader.setVisible(true);
        } else {
            contentPanelHeader.setVisible(false);
        }

//        int count = 0;
        for (Notification n : notificationList) {
            MessagePanel mp = new MessagePanel(n);
//            count++;
//            if (count % 2 == 0) {
                mp.setStyleName("notif-msg-panel");
//            } else {
//                mp.setStyleName("notif-msg-panel-alt");
//            }
            contentPanel.add(mp);
        }
    }



    class CloseClickHandler implements ClickHandler {

        private NotificationPanel nPanel;

        public CloseClickHandler(NotificationPanel nPanel) {
            this.nPanel = nPanel;
        }

        @Override
        public void onClick(ClickEvent clickEvent) {
            nPanel.hide();
        }
    }

    class AcknowledgeInfoPanel extends PopupPanel {

        public AcknowledgeInfoPanel() {
            setWidth("100px");
            setStyleName("notif-ack-popup");
            Label lblInfo = new Label("Checking on acknowledge will prevent this panel from showing on next login unless new notifications arrive.");
            add(lblInfo);
        }

    }


    class MessagePanel extends HorizontalPanel {

        private Label lblMsg;

        private CheckBox chkRead;

        public MessagePanel(final Notification notification) {
            setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
            lblMsg = new Label(notification.getMessage());
            chkRead = new CheckBox();
            chkRead.addValueChangeHandler(new ValueChangeHandler<Boolean>() {
                @Override
                public void onValueChange(ValueChangeEvent<Boolean> event) {
                    if (event.getValue()) {
                        //should call callback here to mark message as read in db
                        notification.setRead(true);
                        setStyleName("notif-msg-panel-alt");
                    } else {
                        //do the opposite here
                        notification.setRead(false);
                        setStyleName("notif-msg-panel");
                    }
                }
            });

            add(lblMsg);
            add(chkRead);

        }
    }

}
