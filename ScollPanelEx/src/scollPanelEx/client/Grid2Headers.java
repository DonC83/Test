package scollPanelEx.client;

import com.google.gwt.cell.client.ImageCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.cellview.client.*;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import java.util.Comparator;
import java.util.List;

/**
 * The source, with you may it be old master
 * Date: 2011/11/23
 */
public class Grid2Headers {


    interface TableResources extends CellTable.Resources {

        @Source({CellTable.Style.DEFAULT_CSS, "tablestyles.css"})
        CellTable.Style cellTableStyle();
    }


    public CellTable<Patterns> createCellTable(List<Patterns> data) {
        CellTable.Resources resources = GWT.create(TableResources.class);
        CellTable<Patterns> table = new CellTable<Patterns>(data.size(), resources);

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
        symbolColumn.setSortable(true);

        Column<Patterns, String> directionColumn = new Column<Patterns, String>(new ImageCell()) {
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
//        identifiedColumn.set

        TextColumn<Patterns> lengthCol = new TextColumn<Patterns>() {
            @Override
            public String getValue(Patterns object) {
                return object.getLength();
            }
        };
        table.addColumn(lengthCol, "Length");


        Column<Patterns, String> qualityCol = new Column<Patterns, String>(new ImageCell()) {
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

                        // Compare the symbol columns.
                        if (o1 != null) {
                            return (o2 != null) ? o1.getSymbol().compareTo(o2.getSymbol()) : 1;
                        }
                        return -1;
                    }
                });

//        ColumnSortEvent.fire()

        table.addColumnSortHandler(columnSortHandler);
        table.getColumnSortList().push(symbolColumn);

        selectionModel.setSelected(data.get(0), true);
        return table;
    }



}