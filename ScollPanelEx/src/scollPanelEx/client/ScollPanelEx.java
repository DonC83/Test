package scollPanelEx.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class ScollPanelEx implements EntryPoint {

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        ScrollPanel sp = new ScrollPanel();

//        String s = "";
//        for (int i=0; i<100; i++) {
//            s += "This is line " + i + "\n";
//        }
//
//        sp.add(new HTML(s));
//        sp.setSize("200px", "100px");
//
//        RootPanel.get("main1").add(sp);
//
//        ScrollPanel sp2 = new ScrollPanel(createCellTable(createData()));
//        sp2.setSize("900px", "200px");
//        RootPanel.get("main2").add(sp2);
//
        ScrollPanel sp3 = new ScrollPanel(createCellTable(createData()));
        sp3.setSize("720px","200px");

        CellTable<Patterns> headers = createCellTable(new ArrayList<Patterns>());
        HeaderPanel headerPanel = new HeaderPanel();
        headerPanel.setHeaderWidget(headers);
        headerPanel.setContentWidget(sp3);
        headerPanel.setSize("720px", "200px");
        headerPanel.setVisible(true);
        RootPanel.get("main3").add(headerPanel);

        VerticalPanel vPanel = new VerticalPanel();
//        vPanel.setSize("900px", "200px");
        vPanel.add(headers);
        vPanel.add(sp3);
        RootPanel.get("main4").add(vPanel);

    }


    String [] symbols = new String[]{"EURUSD", "USDEUR", "GBPUSD", "USDGBP", "AUDUSD", "USDAUD", "ZARUSD", "USDZAR", "JPYUSD", "USDJPY"};
    String [] patterns = new String[]{"Inverse Head and Shoulders","Ascending Triangle", "Flag", "Falling Wedge",
            "Rising Wedge", "Triangle", "Channel Down", "Channel Up", "Pennant"};
    String [] intervals = new String[]{"15min","30min","60min","120min","240min","1440min"};
    String [] type = new String[]{"Completed", "Emerging", "Approaching"};




    private List<Patterns> createData() {
        List<Patterns> patternsList = new ArrayList<Patterns>();
        Patterns p;
        DateTimeFormat df = DateTimeFormat.getFormat("MM-dd HH:mm");

        for (int i=0; i<100; i++) {
            p = new Patterns();
            int sym = (int)(Math.random() * symbols.length);
            int pat = (int)(Math.random() * patterns.length);
            int inter = (int)(Math.random() * intervals.length);
            int tp = (int)(Math.random() * type.length);
            p.setExchange("FOREX");
            p.setSymbol(symbols[sym]);
            p.setPattern(patterns[pat]);
            p.setInterval(intervals[inter]);
            p.setType(type[tp]);
            p.setLength(String.valueOf((int)(Math.random() * 200)));

            p.setIdentified(df.format(new Date(System.currentTimeMillis()-((int)Math.random()*500000))));

            p.setHidden1("hidden1 " + i);
            p.setHidden2("hidden2 " + i);

            patternsList.add(p);
        }


        return patternsList;
    }


    interface TableResources extends CellTable.Resources {

        @Source({CellTable.Style.DEFAULT_CSS, "tablestyles.css"})
        CellTable.Style cellTableStyle();
    }


    private CellTable<Patterns> createCellTable(List<Patterns> data) {
        CellTable.Resources resources = GWT.create(TableResources.class);
        CellTable<Patterns> table = new CellTable<Patterns>(data.size(), resources);

        TextColumn<Patterns> alertColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getAlert();
            }
        };
        table.addColumn(alertColumn, "");
        table.setColumnWidth(alertColumn, "20px");

        TextColumn<Patterns> exchangeColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getExchange();
            }
        };
        exchangeColumn.setSortable(true);

        table.addColumn(exchangeColumn, "Exchange");
        table.setColumnWidth(exchangeColumn, "70px");
        table.addColumnStyleName(1, "grid-headercell");


        TextColumn<Patterns> symbolColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getSymbol();
            }
        };
        table.addColumn(symbolColumn, "Symbol");
        table.setColumnWidth(exchangeColumn, "130px");

        TextColumn<Patterns> directionColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getDirection();
            }
        };
        table.addColumn(directionColumn, "");
        table.setColumnWidth(exchangeColumn, "20px");


        TextColumn<Patterns> intervalColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getInterval();
            }
        };
        table.addColumn(intervalColumn, "Interval");
        table.setColumnWidth(intervalColumn, "70px");

        TextColumn<Patterns> patternColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getPattern();
            }
        };
        table.addColumn(patternColumn, "Pattern");
        table.setColumnWidth(patternColumn, "140px");

        TextColumn<Patterns> identifiedColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getIdentified();
            }
        };
        table.addColumn(identifiedColumn, "Identified");
        table.setColumnWidth(patternColumn, "50px");


        TextColumn<Patterns> lengthCol = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getLength();
            }
        };
        table.addColumn(lengthCol, "Length");
        table.setColumnWidth(patternColumn, "50px");



        TextColumn<Patterns> qualityCol = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getQuality();
            }
        };
        table.addColumn(qualityCol, "Quality");
        table.setColumnWidth(patternColumn, "50px");


        TextColumn<Patterns> typeCol = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getType();
            }
        };
        table.addColumn(typeCol, "Type");
        table.setColumnWidth(patternColumn, "52px");

        table.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.DISABLED);

        final SingleSelectionModel<Patterns> selectionModel = new SingleSelectionModel<Patterns>();
        table.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler(){

            public void onSelectionChange(SelectionChangeEvent event) {
                System.out.println(selectionModel.getSelectedObject().toString());
            }
        });


        table.setWidth("100%", false);
        table.setRowData(data);
        if (data.size()>0)
            selectionModel.setSelected(data.get(0), true);
        return table;
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
