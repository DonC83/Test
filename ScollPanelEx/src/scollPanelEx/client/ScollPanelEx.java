package scollPanelEx.client;

import com.google.gwt.cell.client.ImageCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
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

        CellTable<Patterns> contentTable = createCellTable(createData());
//        CellTable<Patterns> contentTable = null;
        ScrollPanel sp3 = new ScrollPanel();

        if (contentTable == null) {
            HorizontalPanel hPanel = new HorizontalPanel();
            hPanel.setSize("720px", "200px");
            Label lblNoPatterns = new Label("No Patterns Found");
            lblNoPatterns.setStyleName("custom-grid-message");
            hPanel.add(lblNoPatterns);
            sp3.add(hPanel);
        } else {
            sp3.add(contentTable);
        }
        sp3.setSize("735px","200px");

//        CellTable<Patterns> headers = createCellTable(new ArrayList<Patterns>());
        CellTable<Patterns> headers = createHeaderTable();
//        HeaderPanel headerPanel = new HeaderPanel();
//        headerPanel.setHeaderWidget(headers);
//        headerPanel.setContentWidget(sp3);
//        headerPanel.setSize("735px", "200px");
//        headerPanel.setVisible(true);
//        RootPanel.get("main3").add(headerPanel);

        VerticalPanel vPanel = new VerticalPanel();
//        vPanel.setSize("900px", "200px");
        vPanel.add(headers);
        vPanel.add(sp3);
        vPanel.setStyleName("custom-grid");

        RootPanel.get("main4").add(vPanel);
//
//
//        List<String> headerNames = new ArrayList<String>();
//        headerNames.add(" ");
//        headerNames.add("Exchange");
//        headerNames.add("Symbol");
//        headerNames.add(" ");
//        headerNames.add("Interval");
//        headerNames.add("Pattern");
//        headerNames.add("Identified");
//        headerNames.add("Length");
//        headerNames.add("Quality");
//        headerNames.add("Type");

//        table.setColumnWidth(alertColumn, 20, Style.Unit.PX);
//        table.setColumnWidth(exchangeColumn, 100, Style.Unit.PX);
//        table.setColumnWidth(symbolColumn, 130, Style.Unit.PX);
//        table.setColumnWidth(directionColumn, 20, Style.Unit.PX);
//        table.setColumnWidth(intervalColumn, 70, Style.Unit.PX);
//        table.setColumnWidth(patternColumn, 140, Style.Unit.PX);
//        table.setColumnWidth(identifiedColumn, 55, Style.Unit.PX);
//        table.setColumnWidth(lengthCol, 55, Style.Unit.PX);
//        table.setColumnWidth(qualityCol, 55, Style.Unit.PX);
//        table.setColumnWidth(typeCol, 75, Style.Unit.PX);

//        CustomGrid cg = new CustomGrid(headerNames, 735, 200);
//        cg.setColumnWidth("Exchange", "140px");
//        cg.setColumnWidth("Exchange", "140px");
//        cg.setColumnWidth(0, "20px");
//        cg.setColumnWidth(1, "110px");
//        cg.setColumnWidth(2, "130px");
//        cg.setColumnWidth(3, "20px");
//        cg.setColumnWidth(4, "70px");
//        cg.setColumnWidth(5, "140px");
//        cg.setColumnWidth(6, "55px");
//        cg.setColumnWidth(7, "55px");
//        cg.setColumnWidth(8, "55px");
//        cg.setColumnWidth(9, "75px");
//        RootPanel.get("main5").add(cg);



    }


    String [] symbols = new String[]{"EURUSD", "USDEUR", "GBPUSD", "USDGBP", "AUDUSD", "USDAUD", "ZARUSD",
            "USDZAR", "JPYUSD", "USDJPY", "Australian Infrastructure Fund Unt/Ord", "Wotif.com Holdings Limited FPO",
            "Carsales.com Limited FPO"};
    String [] patterns = new String[]{"Inverse Head and Shoulders","Ascending Triangle", "Flag", "Falling Wedge",
            "Rising Wedge", "Triangle", "Channel Down", "Channel Up", "Pennant"};
    String [] intervals = new String[]{"15min","30min","60min","120min","240min","1440min"};
    String [] type = new String[]{"Completed", "Emerging", "Approaching"};

    String [] directions = new String[]{"/images/Down.PNG", "/images/downBlank.PNG", "/images/DownEast.PNG",
            "/images/Up.PNG", "/images/upBlank.PNG", "/images/UpEast.PNG"};

    String [] qualities = new String[]{"/images/Blue1.PNG", "/images/Blue2.PNG", "/images/Blue3.PNG", "/images/Blue4.PNG", "/images/Blue5.PNG",
            "/images/Blue6.PNG", "/images/Blue7.PNG", "/images/Blue8.PNG", "/images/Blue9.PNG", "/images/Blue10.PNG"};

    private List<Patterns> createData() {
        List<Patterns> patternsList = new ArrayList<Patterns>();
        Patterns p;
        DateTimeFormat df = DateTimeFormat.getFormat("MM-dd HH:mm");

        for (int i=0; i<1000; i++) {
            p = new Patterns();
            int sym = (int)(Math.random() * symbols.length);
            int pat = (int)(Math.random() * patterns.length);
            int inter = (int)(Math.random() * intervals.length);
            int tp = (int)(Math.random() * type.length);
            int dir = (int)(Math.random() * directions.length);
            int qual = (int)(Math.random() * qualities.length);
            p.setExchange("FOREX");
            p.setDirection(directions[dir]);
            p.setSymbol(symbols[sym]);
            p.setPattern(patterns[pat]);
            p.setInterval(intervals[inter]);
            p.setQuality(qualities[qual]);
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
        table.addColumn(alertColumn);


        TextColumn<Patterns> exchangeColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getExchange();
            }
        };
//        exchangeColumn.setSortable(true);

        table.addColumn(exchangeColumn);

        TextColumn<Patterns> symbolColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getSymbol();
            }
        };
        table.addColumn(symbolColumn);

        Column<Patterns, String> directionColumn = new Column<Patterns, String>(new ImageCell()) {
            @Override
            public String getValue(Patterns object) {
                return object.getDirection();
            }
        };
        table.addColumn(directionColumn);



        TextColumn<Patterns> intervalColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getInterval();
            }
        };
        table.addColumn(intervalColumn);

        TextColumn<Patterns> patternColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getPattern();
            }
        };
        table.addColumn(patternColumn);


        TextColumn<Patterns> identifiedColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getIdentified();
            }
        };
        table.addColumn(identifiedColumn);

        TextColumn<Patterns> lengthCol = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getLength();
            }
        };
        table.addColumn(lengthCol);



        Column<Patterns, String> qualityCol = new Column<Patterns, String>(new ImageCell()) {
            @Override
            public String getValue(Patterns object) {
                return object.getQuality();
            }
        };
        table.addColumn(qualityCol);


        TextColumn<Patterns> typeCol = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getType();
            }
        };
        table.addColumn(typeCol);

        table.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.DISABLED);

        final SingleSelectionModel<Patterns> selectionModel = new SingleSelectionModel<Patterns>();
        table.setSelectionModel(selectionModel);
        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler(){

            public void onSelectionChange(SelectionChangeEvent event) {
                System.out.println(selectionModel.getSelectedObject().toString());
            }
        });

        table.setWidth("720px", true);

        table.setColumnWidth(alertColumn, 20, Style.Unit.PX);
        table.setColumnWidth(exchangeColumn, 80, Style.Unit.PX);
        table.setColumnWidth(symbolColumn, 120, Style.Unit.PX);
        table.setColumnWidth(directionColumn, 20, Style.Unit.PX);
        table.setColumnWidth(intervalColumn, 70, Style.Unit.PX);
        table.setColumnWidth(patternColumn, 140, Style.Unit.PX);
        table.setColumnWidth(identifiedColumn, 70, Style.Unit.PX);
        table.setColumnWidth(lengthCol, 60, Style.Unit.PX);
        table.setColumnWidth(qualityCol, 65, Style.Unit.PX);
        table.setColumnWidth(typeCol, 75, Style.Unit.PX);



        if (data.size()>0) {
            table.setRowData(data);
            selectionModel.setSelected(data.get(0), true);
        } else {
            return null;
        }

        return table;
    }

    private CellTable<Patterns> createHeaderTable() {
        CellTable.Resources resources = GWT.create(TableResources.class);
        CellTable<Patterns> table = new CellTable<Patterns>(0, resources);

        TextColumn<Patterns> alertColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getAlert();
            }
        };
        table.addColumn(alertColumn, ".");


        TextColumn<Patterns> exchangeColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getExchange();
            }
        };
//        exchangeColumn.setSortable(true);

        table.addColumn(exchangeColumn, "Exchange");


        TextColumn<Patterns> symbolColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getSymbol();
            }
        };
        table.addColumn(symbolColumn, "Symbol");


        TextColumn<Patterns> directionColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getDirection();
            }
        };
        table.addColumn(directionColumn, ".");


        TextColumn<Patterns> intervalColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getInterval();
            }
        };
        table.addColumn(intervalColumn, "Interval");

        TextColumn<Patterns> patternColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getPattern();
            }
        };
        table.addColumn(patternColumn, "Pattern");


        TextColumn<Patterns> identifiedColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getIdentified();
            }
        };
        table.addColumn(identifiedColumn, "Identified");



        TextColumn<Patterns> lengthCol = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getLength();
            }
        };
        table.addColumn(lengthCol, "Length");



        TextColumn<Patterns> qualityCol = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getQuality();
            }
        };
        table.addColumn(qualityCol, "Quality");


        TextColumn<Patterns> typeCol = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getType();
            }
        };
        table.addColumn(typeCol, "Type");

        TextColumn<Patterns> blank = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getType();
            }
        };
        

//        table.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.DISABLED);
//
//        final SingleSelectionModel<Patterns> selectionModel = new SingleSelectionModel<Patterns>();
//        table.setSelectionModel(selectionModel);
//        selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler(){
//
//            public void onSelectionChange(SelectionChangeEvent event) {
//                System.out.println(selectionModel.getSelectedObject().toString());
//            }
//        });

        table.setWidth("735px", true);

        table.setColumnWidth(alertColumn, 20, Style.Unit.PX);
        table.setColumnWidth(exchangeColumn, 80, Style.Unit.PX);
        table.setColumnWidth(symbolColumn, 120, Style.Unit.PX);
        table.setColumnWidth(directionColumn, 20, Style.Unit.PX);
        table.setColumnWidth(intervalColumn, 70, Style.Unit.PX);
        table.setColumnWidth(patternColumn, 140, Style.Unit.PX);
        table.setColumnWidth(identifiedColumn, 70, Style.Unit.PX);
        table.setColumnWidth(lengthCol, 60, Style.Unit.PX);
        table.setColumnWidth(qualityCol, 65, Style.Unit.PX);
        table.setColumnWidth(typeCol, 90, Style.Unit.PX);





        return table;
    }

}
