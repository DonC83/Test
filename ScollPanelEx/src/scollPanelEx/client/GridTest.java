package scollPanelEx.client;

import com.google.gwt.cell.client.ImageCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.*;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import java.util.Comparator;
import java.util.List;

/**
 * The source, with you may it be old master
 * Date: 2011/11/23
 */
public class GridTest {

    private CustomCellTable<Patterns> table;

    private TextColumn<Patterns> exchangeColumn;

    private TextColumn<Patterns> identifiedColumn;

    private TextColumn<Patterns> symbolColumn;

    private TextColumn<Patterns> intervalColumn;

    private Column<Patterns, String> qualityCol;

    private TextColumn<Patterns> typeCol;

    interface TableResources extends CellTable.Resources {

        @Source({CellTable.Style.DEFAULT_CSS, "tablestyles.css"})
        CellTable.Style cellTableStyle();
    }


    public CustomCellTable<Patterns> createCellTable(List<Patterns> data) {
        CellTable.Resources resources = GWT.create(TableResources.class);
        table = new CustomCellTable<Patterns>(data.size(), resources);

        TextColumn<Patterns> alertColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getAlert();
            }
        };
        table.addColumn(alertColumn);


        exchangeColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getExchange();
            }
        };
//        exchangeColumn.setSortable(true);

        table.addColumn(exchangeColumn);

        symbolColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getSymbol();
            }
        };
        table.addColumn(symbolColumn);
        symbolColumn.setSortable(true);

        Column<Patterns, String> directionColumn = new Column<Patterns, String>(new ImageCell()) {
            @Override
            public String getValue(Patterns object) {
                return object.getDirection();
            }
        };
        table.addColumn(directionColumn);


        intervalColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getInterval();
            }
        };
        table.addColumn(intervalColumn);
        intervalColumn.setSortable(true);

        TextColumn<Patterns> patternColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getPattern();
            }
        };
        table.addColumn(patternColumn);


        identifiedColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getIdentified();
            }
        };
        table.addColumn(identifiedColumn);
        identifiedColumn.setSortable(true);

        TextColumn<Patterns> lengthCol = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getLength();
            }
        };
        table.addColumn(lengthCol);


        qualityCol = new Column<Patterns, String>(new ImageCell()) {
            @Override
            public String getValue(Patterns object) {
                return object.getQuality();
            }
        };
        table.addColumn(qualityCol);


        typeCol = new TextColumn<Patterns>() {
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

        table.setWidth("718px", true);

        table.setColumnWidth(alertColumn, 20, Style.Unit.PX);
        table.setColumnWidth(exchangeColumn, 80, Style.Unit.PX);
        table.setColumnWidth(symbolColumn, 120, Style.Unit.PX);
        table.setColumnWidth(directionColumn, 20, Style.Unit.PX);
        table.setColumnWidth(intervalColumn, 70, Style.Unit.PX);
        table.setColumnWidth(patternColumn, 140, Style.Unit.PX);
        table.setColumnWidth(identifiedColumn, 70, Style.Unit.PX);
        table.setColumnWidth(lengthCol, 60, Style.Unit.PX);
        table.setColumnWidth(qualityCol, 65, Style.Unit.PX);
        table.setColumnWidth(typeCol, 73, Style.Unit.PX);



        ListDataProvider<Patterns> dataProvider = new ListDataProvider<Patterns>();
        dataProvider.setList(data);
        if (data.size()>0) {
//            table.setRowData(data);
            dataProvider.addDataDisplay(table);
        } else {
            return null;
        }

        List patternsList = dataProvider.getList();

        ColumnSortEvent.ListHandler<Patterns> columnSortHandler = new ColumnSortEvent.ListHandler<Patterns>(patternsList);
        columnSortHandler.setComparator(symbolColumn,
                new Comparator<Patterns>() {
                    public int compare(Patterns o1, Patterns o2) {
                        if (o1 == o2) {
                            return 0;
                        }
                        if (o1 != null) {
                            return (o2 != null) ? o1.getSymbol().compareTo(o2.getSymbol()) : 1;
                        }
                        return -1;
                    }
                });

        columnSortHandler.setComparator(intervalColumn,
                new Comparator<Patterns>() {
                    public int compare(Patterns o1, Patterns o2) {
                        if (o1 == o2) {
                            return 0;
                        }
                        if (o1 != null) {
                            return (o2 != null) ? o1.getInterval().compareTo(o2.getInterval()) : 1;
                        }
                        return -1;
                    }
                });


        columnSortHandler.setComparator(identifiedColumn,
                new Comparator<Patterns>() {
                    public int compare(Patterns o1, Patterns o2) {
                        if (o1 == o2) {
                            return 0;
                        }
                        if (o1 != null) {
                            return (o2 != null) ? o1.getIdentified().compareTo(o2.getIdentified()) : 1;
                        }
                        return -1;
                    }
                });


        columnSortHandler.setComparator(typeCol,
                new Comparator<Patterns>() {
                    public int compare(Patterns o1, Patterns o2) {
                        if (o1 == o2) {
                            return 0;
                        }
                        if (o1 != null) {
                            return (o2 != null) ? o1.getType().compareTo(o2.getType()) : 1;
                        }
                        return -1;
                    }
                });



        table.addColumnSortHandler(columnSortHandler);
        table.getColumnSortList().push(symbolColumn);

        selectionModel.setSelected(data.get(0), true);
        return table;
    }

    public CellTable<Patterns> createHeaderTable() {
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
        identifiedColumn.setSortable(true);

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



    private class HeaderClickHandler implements ClickHandler {

        private Column<?, ?> headerColumn;

        private Label colLabel;


        HeaderClickHandler(Label colLabel, Column<?,?> headerColumn) {
            this.colLabel = colLabel;
            this.headerColumn = headerColumn;
        }

        public void onClick(ClickEvent event) {
            resetHeaderStyles();
            table.sortColumn(headerColumn);
            if (table.isSortAscending()) {
                colLabel.setStyleName("custom-grid-lbl-asc");
            } else {
                colLabel.setStyleName("custom-grid-lbl-desc");
            }
        }
    }

    private Label heading1;
    private Label heading2;
    private Label heading3;
    private Label heading4;
    private Label heading5;
    private Label heading6;
    private Label heading7;
    private Label heading8;
    private Label heading9;
    private Label heading10;


    private void resetHeaderStyles() {
        heading1.setStyleName("custom-grid-nolbl");
        heading2.setStyleName("custom-grid-lbl");
        heading3.setStyleName("custom-grid-lbl");
        heading4.setStyleName("custom-grid-nolbl");
        heading5.setStyleName("custom-grid-lbl");
        heading6.setStyleName("custom-grid-lbl");
        heading7.setStyleName("custom-grid-lbl");
        heading8.setStyleName("custom-grid-lbl");
        heading9.setStyleName("custom-grid-lbl");
        heading10.setStyleName("custom-grid-lbl");
    }

    public HorizontalPanel genHeaders() {
        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.setStyleName("custom-grid-header");

        heading1 = new Label(".");
        heading2 = new Label("Exchange");
        heading2.addClickHandler(new HeaderClickHandler(heading2, exchangeColumn));

        heading3 = new Label("Symbol");
        heading3.addClickHandler(new HeaderClickHandler(heading3, symbolColumn));


        heading4 = new Label(".");
        heading5 = new Label("Interval");
        heading5.addClickHandler(new HeaderClickHandler(heading5, intervalColumn));
        heading6 = new Label("Pattern");
        heading7 = new Label("Identified");
        heading7.addClickHandler(new HeaderClickHandler(heading7, identifiedColumn));

        heading8 = new Label("Length");
        heading9 = new Label("Quality");
        heading10 = new Label("Type");
        heading10.addClickHandler(new HeaderClickHandler(heading10, typeCol));
        Label nospace = new Label("");

        resetHeaderStyles();
        nospace.setStyleName("custom-grid-lbl");

        heading1.setWidth("19px");
        heading2.setWidth("79px");
        heading3.setWidth("119px");
        heading4.setWidth("19px");
        heading5.setWidth("69px");
        heading6.setWidth("139px");
        heading7.setWidth("69px");
        heading8.setWidth("59px");
        heading9.setWidth("64px");
        heading10.setWidth("73px");
        nospace.setWidth("13px");

        hPanel.add(heading1);
        hPanel.add(heading2);
        hPanel.add(heading3);
        hPanel.add(heading4);
        hPanel.add(heading5);
        hPanel.add(heading6);
        hPanel.add(heading7);
        hPanel.add(heading8);
        hPanel.add(heading9);
        hPanel.add(heading10);
        hPanel.add(nospace);

        return hPanel;
    }

}
