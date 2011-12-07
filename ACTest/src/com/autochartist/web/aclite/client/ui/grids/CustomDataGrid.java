package com.autochartist.web.aclite.client.ui.grids;

import com.autochartist.web.aclite.client.constants.ACConstants;
import com.autochartist.web.aclite.client.constants.ACConstantsWithLookup;
import com.autochartist.web.aclite.client.constants.GlobalSettings;
import com.autochartist.web.aclite.client.model.BrokerLongnameDisplayMap;
import com.autochartist.web.aclite.client.model.PatternSearchResult;
import com.autochartist.web.aclite.client.model.PatternSearchResultList;
import com.autochartist.web.aclite.client.ui.imagebundle.ImageHelper;
import com.google.gwt.cell.client.ImageCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.*;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The source, with you may it be old master
 * Date: 2011/11/24
 */
public class CustomDataGrid extends VerticalPanel {

    private static final ImageHelper imageHelper = new ImageHelper();

    private static final String EAST_INTERVAL = "日足";

    private static final String TYPE_APPROACH = "Approach";

    private static final String TYPE_BREAKOUT = "Breakout";

    private static final String TYPE_COMPLETED = "Completed";

    private static final String TYPE_EMERGING = "Emerging";

    private ScrollPanel scrollPanel;

    private CustomCellTable<TableData> table;

    private Column<TableData, String> alertColumn;

    private TextColumn<TableData> exchangeColumn;

    private TextColumn<TableData> identifiedColumn;

    private TextColumn<TableData> symbolColumn;

    private Column<TableData, String> directionColumn;

    private TextColumn<TableData> intervalColumn;

    private TextColumn<TableData> patternColumn;

    private TextColumn<TableData> lengthCol;

    private Column<TableData, String> qualityCol;

    private TextColumn<TableData> typeCol;

    private String intervalDisplay;

    private Column<?, ?> sortColumn = null;

    private Label sortHeading = null;

    private final Label lblNoData = new Label(ACConstants.INSTANCE.NoPatternsFound());

    private final Label lblLoadingData = new Label(ACConstants.INSTANCE.LoadingData());

    private final List<TableData> nodata = new ArrayList<TableData>();

    private ListDataProvider<TableData> dataProvider;

    private SingleSelectionModel<TableData> selectionModel;

    private CustomCellTable<TableData> grid;

    /**
     * Interface for overriding grid styles
     */
    interface TableResources extends CellTable.Resources {

        @Source({CellTable.Style.DEFAULT_CSS, "tablestyles.css"})
        CellTable.Style cellTableStyle();
    }

    public static class TableData {
        private String alert;

        private String exchange;

        private String symbol;

        private Integer direction;

        private Integer interval;

        private String pattern;

        private String identified;

        private Integer length;

        private Double quality;

        private String type;

        private boolean completed;

        private int brokerId;

        private boolean hideDirection;

        private PatternSearchResult hiddenPatternSearch;

        public String getAlert() {
            return alert;
        }

        public void setAlert(String alert) {
            this.alert = alert;
        }

        public String getExchange() {
            return exchange;
        }

        public void setExchange(String exchange) {
            this.exchange = exchange;
        }

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public Integer getDirection() {
            return direction;
        }

        public void setDirection(Integer direction) {
            this.direction = direction;
        }

        public Integer getInterval() {
            return interval;
        }

        public void setInterval(Integer interval) {
            this.interval = interval;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }

        public String getIdentified() {
            return identified;
        }

        public void setIdentified(String identified) {
            this.identified = identified;
        }

        public Integer getLength() {
            return length;
        }

        public void setLength(Integer length) {
            this.length = length;
        }

        public Double getQuality() {
            return quality;
        }

        public void setQuality(Double quality) {
            this.quality = quality;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public PatternSearchResult getHiddenPatternSearch() {
            return hiddenPatternSearch;
        }

        public void setHiddenPatternSearch(PatternSearchResult hiddenPatternSearch) {
            this.hiddenPatternSearch = hiddenPatternSearch;
        }

        public int getBrokerId() {
            return brokerId;
        }

        public void setBrokerId(int brokerId) {
            this.brokerId = brokerId;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        public boolean isHideDirection() {
            return hideDirection;
        }

        public void setHideDirection(boolean hideDirection) {
            this.hideDirection = hideDirection;
        }
    } //end of static class TableData

    public CustomDataGrid(String width, String height) {
        lblNoData.setStyleName("custom-grid-message");
        lblLoadingData.setStyleName("custom-grid-message");
        scrollPanel = new ScrollPanel();
        scrollPanel.setSize(width, height);
        grid = createCellTable(width);
        scrollPanel.add(grid);

        this.add(genHeaders());
        this.add(scrollPanel);
        this.setStyleName("custom-grid");
        sortColumn = lengthCol;
        sortHeading = lengthHeading;
    }

    private CustomCellTable<TableData> createCellTable(String width) {
        CellTable.Resources resources = GWT.create(TableResources.class);
        table = new CustomCellTable<TableData>(0, resources);

        dataProvider = new ListDataProvider<TableData>();
        selectionModel = new SingleSelectionModel<TableData>();

        alertColumn = new Column<TableData, String>(new ImageCell()) {
            @Override
            public String getValue(TableData object) {
                return object.getAlert();
            }
        };
        table.addColumn(alertColumn);

        exchangeColumn = new TextColumn<TableData>() {
            @Override
            public String getValue(TableData object) {
                return object.getExchange();
            }
        };

        table.addColumn(exchangeColumn);

        symbolColumn = new TextColumn<TableData>() {
            @Override
            public String getValue(TableData object) {
                return object.getSymbol();
            }
        };
        table.addColumn(symbolColumn);

        directionColumn = new Column<TableData, String>(new ImageCell()) {
            @Override
            public String getValue(TableData object) {
                if (object.hideDirection) {
                    return "";
                } else {
                    return GlobalSettings.CONTEXT_PREFIX + "/icons/" +
                            imageHelper.getDirectionIconString(object.getDirection(), object.isCompleted(), object.getBrokerId()==GlobalSettings.BROKER_KOREADIRECT);
                }
            }
        };
        table.addColumn(directionColumn);

        intervalColumn = new TextColumn<TableData>() {
            @Override
            public String getValue(TableData object) {
                intervalDisplay = object.getInterval() + " " + ACConstants.INSTANCE.Min();
                if (ACConstants.INSTANCE.countryLocale() != null && ACConstants.INSTANCE.countryLocale().toLowerCase().equals("ja_jp") &&
                        object.getInterval() == 1440) {
                    intervalDisplay = EAST_INTERVAL;
                }
                return intervalDisplay;
            }
        };
        table.addColumn(intervalColumn);

        patternColumn = new TextColumn<TableData>() {
            @Override
            public String getValue(TableData object) {
                return object.getPattern();
            }
        };
        table.addColumn(patternColumn);

        identifiedColumn = new TextColumn<TableData>() {
            @Override
            public String getValue(TableData object) {
                return object.getIdentified();
            }
        };
        table.addColumn(identifiedColumn);

        lengthCol = new TextColumn<TableData>() {
            @Override
            public String getValue(TableData object) {
                return String.valueOf(object.getLength());
            }
        };
        table.addColumn(lengthCol);

        qualityCol = new Column<TableData, String>(new ImageCell()) {
            @Override
            public String getValue(TableData object) {
                return imageHelper.getStrenghtIconString("Blue", object.getQuality());
            }
        };
        table.addColumn(qualityCol);


        typeCol = new TextColumn<TableData>() {
            @Override
            public String getValue(TableData object) {
                return object.getType();
            }
        };
        table.addColumn(typeCol);

        table.setKeyboardSelectionPolicy(HasKeyboardSelectionPolicy.KeyboardSelectionPolicy.DISABLED);

        table.setSelectionModel(selectionModel);

        int w = Integer.parseInt(width.replaceAll("px", ""));
        table.setWidth((w - 17) + "px", true);
        table.setColumnWidth(alertColumn, 18, Style.Unit.PX);
        table.setColumnWidth(exchangeColumn, 78 , Style.Unit.PX);
        table.setColumnWidth(symbolColumn, 118, Style.Unit.PX);
        table.setColumnWidth(directionColumn, 18, Style.Unit.PX);
        table.setColumnWidth(intervalColumn, 68, Style.Unit.PX);
        table.setColumnWidth(patternColumn, 138, Style.Unit.PX);
        table.setColumnWidth(identifiedColumn, 68, Style.Unit.PX);
        table.setColumnWidth(lengthCol, 58, Style.Unit.PX);
        table.setColumnWidth(qualityCol, 63, Style.Unit.PX);
        table.setColumnWidth(typeCol, 71, Style.Unit.PX);

        //bind the dataprovider to the table
        dataProvider.addDataDisplay(table);

        table.setLoadingIndicator(new Label("loading data"));

        return table;
    }

    public void setTableData(List<TableData> data) {
        resetHeaderStyles();
        if (data!=null && data.size()>0) {
            dataProvider.setList(data);
            table.setRowData(data);
        } else {
            table.setRowData(nodata);
            table.setEmptyTableWidget(lblNoData);
            return;
        }

        List patternsList = dataProvider.getList();

        ColumnSortEvent.ListHandler<TableData> columnSortHandler = new ColumnSortEvent.ListHandler<TableData>(patternsList);

        columnSortHandler.setComparator(alertColumn,
                new Comparator<TableData>() {
                    public int compare(TableData o1, TableData o2) {
                        if (o1 == o2) {
                            return 0;
                        }
                        if (o1 != null) {
                            return (o2 != null) ? o1.getAlert().compareTo(o2.getAlert()) : 1;
                        }
                        return -1;
                    }
                });

        columnSortHandler.setComparator(exchangeColumn,
                new Comparator<TableData>() {
                    public int compare(TableData o1, TableData o2) {
                        if (o1 == o2) {
                            return 0;
                        }
                        if (o1 != null) {
                            return (o2 != null) ? o1.getExchange().compareTo(o2.getExchange()) : 1;
                        }
                        return -1;
                    }
                });


        columnSortHandler.setComparator(symbolColumn,
                new Comparator<TableData>() {
                    public int compare(TableData o1, TableData o2) {
                        if (o1 == o2) {
                            return 0;
                        }
                        if (o1 != null) {
                            return (o2 != null) ? o1.getSymbol().compareTo(o2.getSymbol()) : 1;
                        }
                        return -1;
                    }
                });

        columnSortHandler.setComparator(directionColumn,
                new Comparator<TableData>() {
                    public int compare(TableData o1, TableData o2) {
                        if (o1 == o2) {
                            return 0;
                        }
                        if (o1 != null) {
                            return (o2 != null) ? o1.getDirection().compareTo(o2.getDirection()) : 1;
                        }
                        return -1;
                    }
                });


        columnSortHandler.setComparator(intervalColumn,
                new Comparator<TableData>() {
                    public int compare(TableData o1, TableData o2) {
                        if (o1 == o2) {
                            return 0;
                        }
                        if (o1 != null) {
                            return (o2 != null) ? o1.getInterval().compareTo(o2.getInterval()) : 1;
                        }
                        return -1;
                    }
                });


        columnSortHandler.setComparator(patternColumn,
                new Comparator<TableData>() {
                    public int compare(TableData o1, TableData o2) {
                        if (o1 == o2) {
                            return 0;
                        }
                        if (o1 != null) {
                            return (o2 != null) ? o1.getPattern().compareTo(o2.getPattern()) : 1;
                        }
                        return -1;
                    }
                });

        columnSortHandler.setComparator(identifiedColumn,
                new Comparator<TableData>() {
                    public int compare(TableData o1, TableData o2) {
                        if (o1 == o2) {
                            return 0;
                        }
                        if (o1 != null) {
                            return (o2 != null) ? o1.getIdentified().compareTo(o2.getIdentified()) : 1;
                        }
                        return -1;
                    }
                });

        columnSortHandler.setComparator(lengthCol,
                new Comparator<TableData>() {
                    public int compare(TableData o1, TableData o2) {
                        if (o1 == o2) {
                            return 0;
                        }
                        if (o1 != null) {
                            return (o2 != null) ? o1.getLength().compareTo(o2.getLength()) : 1;
                        }
                        return -1;
                    }
                });

        columnSortHandler.setComparator(qualityCol,
                new Comparator<TableData>() {
                    public int compare(TableData o1, TableData o2) {
                        if (o1 == o2) {
                            return 0;
                        }
                        if (o1 != null) {
                            return (o2 != null) ? o1.getQuality().compareTo(o2.getQuality()) : 1;
                        }
                        return -1;
                    }
                });

        columnSortHandler.setComparator(typeCol,
                new Comparator<TableData>() {
                    public int compare(TableData o1, TableData o2) {
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
        table.getColumnSortList().push(sortColumn);


        table.sortColumn(sortColumn);
        if(table.isSortAscending()) {
            if (GlobalSettings.CONTEXT_PREFIX.equals("")) {
                sortHeading.setStyleName("custom-grid-lbl-asc");
            } else {
                sortHeading.setStyleName("custom-grid-lbl-asc-ac");
            }
        } else {
            if (GlobalSettings.CONTEXT_PREFIX.equals("")) {
                sortHeading.setStyleName("custom-grid-lbl-desc");
            } else {
                sortHeading.setStyleName("custom-grid-lbl-desc-ac");
            }
        }

        selectionModel.setSelected(data.get(0), true);
        SelectionChangeEvent.fire(selectionModel);
    }

    public void clearData() {
        table.setRowData(nodata);
        table.setEmptyTableWidget(lblLoadingData);
    }


    /**
     * Provides the selection model to had events on row selection.
     * @return
     */
    public SingleSelectionModel<TableData> getSelectionModel() {
        return selectionModel;
    }

    /**
     *
     * Converts the given PatternSearchResultList into a List of TableData that is used to bind to the grid
     *
     * @param resultList
     * @return
     */
    public static List<TableData> prepareData(PatternSearchResultList resultList, int brokerId, boolean hideDirectionColumn) {

        List<TableData> tableDataList = new ArrayList<TableData>();

        if ((resultList == null) || (resultList.size() == 0)) {
            return null;
        } else {

            TableData td;
            BrokerLongnameDisplayMap brokerLDM = new BrokerLongnameDisplayMap();
            String patternName;
            String resultClassName;
            for (PatternSearchResult psr : resultList.values()) {
                td = new TableData();
                boolean complete = psr.isComplete();

                if (psr.isNew()) {
                    td.setAlert(GlobalSettings.CONTEXT_PREFIX + "/icons/newresult.png");
                } else {
                    td.setAlert(GlobalSettings.CONTEXT_PREFIX + "/icons/spacer.gif");
                }

                td.setExchange(psr.getExchange());
                if (brokerLDM.get(brokerId)) {
                    td.setSymbol(psr.getLongName());
                } else {
                    td.setSymbol(psr.getSymbol());
                }

                td.setDirection(psr.getDirection());
                td.setCompleted(psr.isComplete());
                td.setBrokerId(brokerId);
                td.setHideDirection(hideDirectionColumn);

                td.setInterval(psr.getGranularity());

                patternName = psr.getPattern().replaceAll("\\s", "");
                patternName = patternName.replaceAll("&", "And");
                patternName = patternName.replaceAll("3", "Three");
                patternName = patternName.replaceAll("and", "And");

                try {
                    td.setPattern(ACConstantsWithLookup.INSTANCE.getString(patternName));
                } catch (java.util.MissingResourceException e) {
                    td.setPattern(psr.getPattern());
                }

                td.setIdentified(psr.getPatternEndTime());
                td.setLength(psr.getLength());
                td.setQuality(psr.getQuality());

                resultClassName = psr.getClass().getName();
                if ("com.autochartist.web.aclite.client.model.HRSPatternSearchResult".equals(resultClassName)) {
                    if (complete) {
                        td.setType(TYPE_BREAKOUT);
                    } else {
                        td.setType(TYPE_APPROACH);
                    }
                } else {
                    if (complete) {
                        td.setType(TYPE_COMPLETED);
                    } else {
                        td.setType(TYPE_EMERGING);
                    }
                }
                td.setHiddenPatternSearch(psr);
                tableDataList.add(td);
            }

        }
        return tableDataList;
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
            sortHeading = colLabel;
            sortColumn = headerColumn;
            table.sortColumn(sortColumn);
            if (table.isSortAscending()) {
                if (GlobalSettings.CONTEXT_PREFIX.equals("")) {
                    sortHeading.setStyleName("custom-grid-lbl-asc");
                } else {
                    sortHeading.setStyleName("custom-grid-lbl-asc-ac");
                }
            } else {
                if (GlobalSettings.CONTEXT_PREFIX.equals("")) {
                    sortHeading.setStyleName("custom-grid-lbl-desc");
                } else {
                    sortHeading.setStyleName("custom-grid-lbl-desc-ac");
                }
            }
            selectionModel.setSelected(dataProvider.getList().get(0), true);
        }
    }

    private Label alertHeading;
    private Label exchangeHeading;
    private Label symbolHeading;
    private Label directionHeading;
    private Label intervalHeading;
    private Label patternHeading;
    private Label identifiedHeading;
    private Label lengthHeading;
    private Label qualityHeading;
    private Label typeHeading;

    private void resetHeaderStyles() {
        alertHeading.setStyleName("custom-grid-nolbl");
        exchangeHeading.setStyleName("custom-grid-lbl");
        symbolHeading.setStyleName("custom-grid-lbl");
        directionHeading.setStyleName("custom-grid-nolbl");
        intervalHeading.setStyleName("custom-grid-lbl");
        patternHeading.setStyleName("custom-grid-lbl");
        identifiedHeading.setStyleName("custom-grid-lbl");
        lengthHeading.setStyleName("custom-grid-lbl");
        qualityHeading.setStyleName("custom-grid-lbl");
        typeHeading.setStyleName("custom-grid-lbl");
    }

    /**
     * Generates the headings for the table and adds the clickhandlers for the columns sorting methods
     * @return
     */
    public HorizontalPanel genHeaders() {
        HorizontalPanel hPanel = new HorizontalPanel();
        hPanel.setStyleName("custom-grid-header");

        alertHeading = new Label(".");
        exchangeHeading = new Label("Exchange");
        exchangeHeading.addClickHandler(new HeaderClickHandler(exchangeHeading, exchangeColumn));

        symbolHeading = new Label("Symbol");
        symbolHeading.addClickHandler(new HeaderClickHandler(symbolHeading, symbolColumn));

        directionHeading = new Label(".");
        directionHeading.addClickHandler(new HeaderClickHandler(directionHeading, directionColumn));

        intervalHeading = new Label("Interval");
        intervalHeading.addClickHandler(new HeaderClickHandler(intervalHeading, intervalColumn));

        patternHeading = new Label("Pattern");
        patternHeading.addClickHandler(new HeaderClickHandler(patternHeading, patternColumn));

        identifiedHeading = new Label("Identified");
        identifiedHeading.addClickHandler(new HeaderClickHandler(identifiedHeading, identifiedColumn));

        lengthHeading = new Label("Length");
        lengthHeading.addClickHandler(new HeaderClickHandler(lengthHeading, lengthCol));

        qualityHeading = new Label("Quality");
        qualityHeading.addClickHandler(new HeaderClickHandler(qualityHeading, qualityCol));

        typeHeading = new Label("Type");
        typeHeading.addClickHandler(new HeaderClickHandler(typeHeading, typeCol));
        Label nospace = new Label("");

        resetHeaderStyles();
        nospace.setStyleName("custom-grid-lbl");

        alertHeading.setWidth("17px");
        exchangeHeading.setWidth("77px");
        symbolHeading.setWidth("117px");
        directionHeading.setWidth("17px");
        intervalHeading.setWidth("67px");
        patternHeading.setWidth("137px");
        identifiedHeading.setWidth("67px");
        lengthHeading.setWidth("57px");
        qualityHeading.setWidth("63px");
        typeHeading.setWidth("64px");
        nospace.setWidth("21px");

        hPanel.add(alertHeading);
        hPanel.add(exchangeHeading);
        hPanel.add(symbolHeading);
        hPanel.add(directionHeading);
        hPanel.add(intervalHeading);
        hPanel.add(patternHeading);
        hPanel.add(identifiedHeading);
        hPanel.add(lengthHeading);
        hPanel.add(qualityHeading);
        hPanel.add(typeHeading);
        hPanel.add(nospace);

        return hPanel;
    }

} //end of class CustomGridData



