package com.sandbox.client.components;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.HeaderPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;

import java.util.ArrayList;
import java.util.List;

/**
 * The source, with you may it be old master
 * Date: 2011/11/21
 */
public class CustomGrid {


    private class Patterns {
        private String alert;

        private String exchange;

        private String symbol;

        private String direction;

        private String interval;

        private String pattern;

        private String identified;

        private String length;

        private String quality;

        private String type;

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

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getInterval() {
            return interval;
        }

        public void setInterval(String interval) {
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

        public String getLength() {
            return length;
        }

        public void setLength(String length) {
            this.length = length;
        }

        public String getQuality() {
            return quality;
        }

        public void setQuality(String quality) {
            this.quality = quality;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

    private HeaderPanel headerPanel;

    private CellTable<Patterns> headerTable;

    public CustomGrid() {
        headerPanel = new HeaderPanel();
        headerPanel.setSize("800px", "200px");
        headerPanel.setVisible(true);

        headerTable = new CellTable<Patterns>();

        headerPanel.setFooterWidget(null);

        setHeaders();
        setData();
    }

    public void setHeaders() {
        TextColumn<Patterns> alertColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.alert;
            }
        };
        headerTable.addColumn(alertColumn, "");
        headerTable.setColumnWidth(alertColumn, "20px");

        TextColumn<Patterns> exchangeColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.exchange;
            }
        };
        exchangeColumn.setSortable(true);

        headerTable.addColumn(exchangeColumn, "Exchange");
        headerTable.setColumnWidth(exchangeColumn, "70px");
        headerTable.addColumnStyleName(1, "grid-headercell");


        TextColumn<Patterns> symbolColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.exchange;
            }
        };
        headerTable.addColumn(symbolColumn, "Symbol");
        headerTable.setColumnWidth(exchangeColumn, "130px");

        TextColumn<Patterns> directionColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.direction;
            }
        };
        headerTable.addColumn(directionColumn, "");
        headerTable.setColumnWidth(exchangeColumn, "20px");


        TextColumn<Patterns> intervalColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.interval;
            }
        };
        headerTable.addColumn(intervalColumn, "Interval");
        headerTable.setColumnWidth(intervalColumn, "130px");

        TextColumn<Patterns> patternColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.pattern;
            }
        };
        headerTable.addColumn(patternColumn, "Pattern");
        headerTable.setColumnWidth(patternColumn, "140px");

        TextColumn<Patterns> identifiedColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.identified;
            }
        };
        headerTable.addColumn(identifiedColumn, "Identified");
        headerTable.setColumnWidth(patternColumn, "50px");


        TextColumn<Patterns> lengthCol = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.length;
            }
        };
        headerTable.addColumn(lengthCol, "Length");
        headerTable.setColumnWidth(patternColumn, "50px");



        TextColumn<Patterns> qualityCol = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.quality;
            }
        };
        headerTable.addColumn(qualityCol, "Quality");
        headerTable.setColumnWidth(patternColumn, "50px");


        TextColumn<Patterns> typeCol = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.type;
            }
        };
        headerTable.addColumn(typeCol, "Type");
        headerTable.setColumnWidth(patternColumn, "72px");

        headerTable.setRowCount(0);

//        ColumnSortEvent.ListHandler<Patterns> = new ColumnSortEvent.ListHandler<Patterns>()
//        headerTable.addColumnSortHandler()
        headerPanel.setHeaderWidget(headerTable);
    }


    public void setData() {
        CellTable<Patterns> dataTable = new CellTable<Patterns>();

        TextColumn<Patterns> alertColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.alert;
            }
        };
        dataTable.addColumn(alertColumn, "");
        dataTable.setColumnWidth(alertColumn, "20px");

        TextColumn<Patterns> exchangeColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.exchange;
            }
        };

        exchangeColumn.setSortable(true);
        dataTable.addColumn(exchangeColumn, "");
        dataTable.setColumnWidth(exchangeColumn, "70px");
        dataTable.addColumnStyleName(1, "grid-headercell");


        TextColumn<Patterns> symbolColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.exchange;
            }
        };
        dataTable.addColumn(symbolColumn, "");
        dataTable.setColumnWidth(exchangeColumn, "130px");

        TextColumn<Patterns> directionColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.direction;
            }
        };
        dataTable.addColumn(directionColumn, "");
        dataTable.setColumnWidth(exchangeColumn, "20px");


        TextColumn<Patterns> intervalColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.interval;
            }
        };
        dataTable.addColumn(intervalColumn, "");
        dataTable.setColumnWidth(intervalColumn, "130px");

        TextColumn<Patterns> patternColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.pattern;
            }
        };
        dataTable.addColumn(patternColumn, "");
        dataTable.setColumnWidth(patternColumn, "140px");

        TextColumn<Patterns> identifiedColumn = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.identified;
            }
        };
        dataTable.addColumn(identifiedColumn, "");
        dataTable.setColumnWidth(patternColumn, "50px");


        TextColumn<Patterns> lengthCol = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.length;
            }
        };
        dataTable.addColumn(lengthCol, "");
        dataTable.setColumnWidth(patternColumn, "50px");



        TextColumn<Patterns> qualityCol = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.quality;
            }
        };
        dataTable.addColumn(qualityCol, "");
        dataTable.setColumnWidth(patternColumn, "50px");


        TextColumn<Patterns> typeCol = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.type;
            }
        };
        dataTable.addColumn(typeCol, "");
        dataTable.setColumnWidth(patternColumn, "72px");



        List<Patterns> patternList = new ArrayList<Patterns>();

        Patterns p = new Patterns();

        p.setType("Completed");
        p.setExchange("FOREX");
        p.setIdentified("08-12 00:00");
        p.setInterval("1440min");
        p.setLength("48");
        p.setPattern("Triangle");
        p.setSymbol("EURUSD");
        patternList.add(p);

        p = new Patterns();
        p.setType("Completed");
        p.setExchange("FOREX");
        p.setIdentified("08-12 00:00");
        p.setInterval("1440min");
        p.setLength("48");
        p.setPattern("Triangle");
        p.setSymbol("EURUSD");
        patternList.add(p);

        p = new Patterns();
        p.setType("Completed");
        p.setExchange("FOREX");
        p.setIdentified("08-12 00:00");
        p.setInterval("1440min");
        p.setLength("48");
        p.setPattern("Triangle");
        p.setSymbol("EURUSD");
        patternList.add(p);

        p = new Patterns();
        p.setType("Completed");
        p.setExchange("FOREX");
        p.setIdentified("08-12 00:00");
        p.setInterval("1440min");
        p.setLength("48");
        p.setPattern("Triangle");
        p.setSymbol("EURUSD");
        patternList.add(p);

        p = new Patterns();
        p.setType("Completed");
        p.setExchange("FOREX");
        p.setIdentified("08-12 00:00");
        p.setInterval("1440min");
        p.setLength("48");
        p.setPattern("Triangle");
        p.setSymbol("EURUSD");
        patternList.add(p);

        p = new Patterns();
        p.setType("Completed");
        p.setExchange("FOREX");
        p.setIdentified("08-12 00:00");
        p.setInterval("1440min");
        p.setLength("48");
        p.setPattern("Triangle");
        p.setSymbol("EURUSD");
        patternList.add(p);

        p = new Patterns();
        p.setType("Completed");
        p.setExchange("FOREX");
        p.setIdentified("08-12 00:00");
        p.setInterval("1440min");
        p.setLength("48");
        p.setPattern("Triangle");
        p.setSymbol("EURUSD");
        patternList.add(p);

        p = new Patterns();
        p.setType("Completed");
        p.setExchange("FOREX");
        p.setIdentified("08-12 00:00");
        p.setInterval("1440min");
        p.setLength("48");
        p.setPattern("Triangle");
        p.setSymbol("EURUSD");
        patternList.add(p);

        p = new Patterns();
        p.setType("Completed");
        p.setExchange("FOREX");
        p.setIdentified("08-12 00:00");
        p.setInterval("1440min");
        p.setLength("48");
        p.setPattern("Triangle");
        p.setSymbol("EURUSD");
        patternList.add(p);

        p = new Patterns();
        p.setType("Completed");
        p.setExchange("FOREX");
        p.setIdentified("08-12 00:00");
        p.setInterval("1440min");
        p.setLength("48");
        p.setPattern("Triangle");
        p.setSymbol("EURUSD");
        patternList.add(p);

        dataTable.setRowData(patternList);

        ScrollPanel sPanel = new ScrollPanel();
        sPanel.setSize("800px", "200px");
        sPanel.add(dataTable);
        headerPanel.setContentWidget(sPanel);

    }

    public HeaderPanel getHeaderPanel() {
        return headerPanel;
    }


}
