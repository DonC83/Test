package scollPanelEx.client;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The source, with you may it be old master
 * Date: 2011/11/22
 */
public class CustomGrid extends VerticalPanel {

    private final List<HeaderColumn> headerColumnList = new ArrayList<HeaderColumn>();

    private final Map<String, HeaderColumn> headerMap = new HashMap<String, HeaderColumn>();

    private CellTable<String> headerCells;

//    private CellTable<String> headerCells;

    public CustomGrid(List<String> headerNames, int width, int height) {
        headerCells = createHeaders(headerNames, width);
        this.add(headerCells);
        this.setWidth(width + "px");
        this.setHeight(height + "px");
    }

    class HeaderColumn extends TextColumn<String> {

        @Override
        public String getValue(String object) {
            return object;
        }
    }

    private CellTable<String> createHeaders(List<String> headerNames, int width) {
        CellTable<String> headerCells = new CellTable<String>();

        headerCells.setWidth((width-15) + "px", false);
        HeaderColumn headerColumn;
        for (String s : headerNames) {
            headerColumn = new HeaderColumn();
            headerCells.addColumn(headerColumn, s);
            headerMap.put(s, headerColumn);
            headerColumnList.add(headerColumn);
        }
        headerCells.setRowCount(0);
        return headerCells;
    }


    public void setColumnWidth(String columnName, String width) {
        HeaderColumn headerColumn = headerMap.get(columnName);
        headerCells.setColumnWidth(headerColumn, width);
    }

    public void setColumnWidth(int index, String width) {
        HeaderColumn headerColumn = headerColumnList.get(index);
        headerCells.setColumnWidth(headerColumn, width);
    }


    private void createContent() {
        ScrollPanel sp = new ScrollPanel();
    }

}
