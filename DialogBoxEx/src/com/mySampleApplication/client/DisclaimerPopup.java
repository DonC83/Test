package com.mySampleApplication.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Date: 2012/04/06
 * <p/>
 * The source, with you may it be old master.
 */
public class DisclaimerPopup extends DialogBox {

    private Button btnAcceptSubmit = new Button();

    public DisclaimerPopup() {
        this.setGlassEnabled(true);
        this.setAnimationEnabled(true);
        this.setModal(true);

        this.setTitle("Disclaimer");
        init();

    }

    private void init() {

        HTML content = new HTML();
        content.setText("By submitting the query you hereby agree that the client has provided consent to perform this query to the selected underwriters");

        btnAcceptSubmit.setText("Accept & Submit");


        VerticalPanel vPanel = new VerticalPanel();


        vPanel.add(content);
        vPanel.add(btnAcceptSubmit);

        this.setWidget(vPanel);

    }

    public Button getBtnAcceptSubmit() {
        return btnAcceptSubmit;
    }
}
