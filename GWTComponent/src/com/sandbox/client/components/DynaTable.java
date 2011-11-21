package com.sandbox.client.components;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * The source, with you may it be old master
 * Date: 2011/07/26
 */
public class DynaTable extends HorizontalPanel {


    private CellTable<GridData> cellTable;

    private ListDataProvider<GridData> dataProvider;

    private static final String [] names = new String[]{"name1", "name2", "name3"};

    public DynaTable() {

        dataProvider = new ListDataProvider<GridData>();
        List<GridData> l = new ArrayList<GridData>();
        GridData gd;
        for (String s : names) {
            gd = new GridData();
            gd.setFirstName(s);
            l.add(gd);
        }

        dataProvider.setList(l);


        cellTable = new CellTable<GridData>();
//        ColumnSortEvent.ListHandler<String> sortHandler = new ColumnSortEvent.ListHandler<String>();
//        cellTable.addColumnSortHandler();



        Column<GridData, String> firstName = new Column<GridData, String>(new TextCell()) {
            @Override
            public String getValue(GridData object) {
                return object.getFirstName();
            }
        };

        dataProvider.addDataDisplay(cellTable);
        this.add(cellTable);

    }



}


class GridData {

    private String firstName;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}