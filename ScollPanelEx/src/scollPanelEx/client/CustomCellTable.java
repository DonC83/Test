package scollPanelEx.client;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.ColumnSortList;

/**
 * The source, with you may it be old master
 * Date: 2011/11/24
 */
public class CustomCellTable<T> extends CellTable<T> {

    private boolean isSortAscending = false;

    public CustomCellTable() {
    }

    public CustomCellTable(int pageSize) {
        super(pageSize);
    }

    public CustomCellTable(int pageSize, Resources resources) {
        super(pageSize, resources);
    }


    public void sortColumn(Column<?, ?> column) {
        super.getColumnSortList().push(column);
        ColumnSortEvent.fire(this, super.getColumnSortList());
        ColumnSortList.ColumnSortInfo sortedInfo = (super.getColumnSortList().size() == 0) ? null
          : super.getColumnSortList().get(0);

        isSortAscending = (sortedInfo == null) ? false
          : sortedInfo.isAscending();

    }

    public boolean isSortAscending() {
        return isSortAscending;
    }

    public void setSortAscending(boolean sortAscending) {
        isSortAscending = sortAscending;
    }
}
