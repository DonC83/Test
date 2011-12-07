package com.autochartist.web.aclite.client;

import com.autochartist.web.aclite.client.ui.grids.CustomDataGrid;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class aclite implements EntryPoint {


    String [] symbols = new String[]{"EURUSD", "USDEUR", "GBPUSD", "USDGBP", "AUDUSD", "USDAUD", "ZARUSD",
            "USDZAR", "JPYUSD", "USDJPY", "Australian Infrastructure Fund Unt/Ord", "Wotif.com Holdings Limited FPO",
            "Carsales.com Limited FPO"};
    String [] patterns = new String[]{"Inverse Head and Shoulders","Ascending Triangle", "Flag", "Falling Wedge",
            "Rising Wedge", "Triangle", "Channel Down", "Channel Up", "Pennant"};
    Integer [] intervals = new Integer[]{15, 30, 60, 120, 240, 1440};
    String [] type = new String[]{"Completed", "Emerging", "Approaching"};

    Integer [] directions = new Integer[]{1,2,-1,-2,0};


    Double [] qualities = new Double[] {0.1d,0.122d,0.33d,0.44,0.57,0.63d,0.77,0.82,0.94};


    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {

        CustomDataGrid.TableData td = new CustomDataGrid.TableData();
        DateTimeFormat df = DateTimeFormat.getFormat("MM-dd HH:mm");

        List<CustomDataGrid.TableData> tableDataList = new ArrayList<CustomDataGrid.TableData>();
        for (int i=0; i<1000; i++) {
            td = new CustomDataGrid.TableData();
            int sym = (int)(Math.random() * symbols.length);
            int pat = (int)(Math.random() * patterns.length);
            int inter = (int)(Math.random() * intervals.length);
            int tp = (int)(Math.random() * type.length);
            int dir = (int)(Math.random() * directions.length);
            int qual = (int)(Math.random() * qualities.length);
            td.setExchange("FOREX");
            td.setDirection(directions[dir]);
            td.setSymbol(symbols[sym]);
            td.setPattern(patterns[pat]);
            td.setInterval(intervals[inter]);
            td.setQuality(qualities[qual]);
            td.setType(type[tp]);
            td.setLength((int) (Math.random() * 200));

            td.setIdentified(df.format(new Date(System.currentTimeMillis() - ((int) Math.random() * 800000))));
            tableDataList.add(td);
        }



        CustomDataGrid cdg = new CustomDataGrid("720px", "300px");
        cdg.setTableData(tableDataList);

        RootPanel.get("appContainer").add(cdg);

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
