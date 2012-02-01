package cellTableExample.client;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.cellview.client.*;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.DOM;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Entry point classes define <code>onModuleLoad()</code>
 */
public class CellTableExample implements EntryPoint {

    /**
     * A simple data type that represents a contact.
     */
    private static class Contact {
        private final String address;
        private final Date birthday;
        private final String name;

        public Contact(String name, Date birthday, String address) {
            this.name = name;
            this.birthday = birthday;
            this.address = address;
        }
    }

    /**
     * The list of data to display.
     */
    private static final List<Contact> CONTACTS = Arrays.asList(
            new Contact("John", new Date(80, 4, 12), "123 Fourth Avenue"),
            new Contact("Joe", new Date(85, 2, 22), "22 Lance Ln"),
            new Contact("George", new Date(46, 6, 6), "1600 Pennsylvania Avenue"));


    public void onModuleLoad() {
        // Create a CellTable.
        CellTable<Contact> table = new CellTable<Contact>();

        // Create name column.
        TextColumn<Contact> nameColumn = new TextColumn<Contact>() {
            @Override
            public String getValue(Contact contact) {
                return contact.name;
            }
        };

        // Make the name column sortable.
        nameColumn.setSortable(true);

        // Create address column.
        TextColumn<Contact> addressColumn = new TextColumn<Contact>() {
            @Override
            public String getValue(Contact contact) {
                return contact.address;
            }
        };

        // Add the columns.
        table.addColumn(nameColumn, "Name");
        table.addColumn(addressColumn, "Address");

        // Create a data provider.
        ListDataProvider<Contact> dataProvider = new ListDataProvider<Contact>();

        // Connect the table to the data provider.
        dataProvider.addDataDisplay(table);

        // Add the data to the data provider, which automatically pushes it to the
        // widget.
        List<Contact> list = dataProvider.getList();
        for (Contact contact : CONTACTS) {
            list.add(contact);
        }

//        Add a ColumnSortEvent.ListHandler to connect sorting to the
//        java.util.List.
        ColumnSortEvent.ListHandler<Contact> columnSortHandler = new ColumnSortEvent.ListHandler<Contact>(
                list);
        columnSortHandler.setComparator(nameColumn,
                new Comparator<Contact>() {
                    public int compare(Contact o1, Contact o2) {
                        if (o1 == o2) {
                            return 0;
                        }

                        // Compare the name columns.
                        if (o1 != null) {
                            return (o2 != null) ? o1.name.compareTo(o2.name) : 1;
                        }
                        return -1;
                    }
                });
        table.addColumnSortHandler(columnSortHandler);

        // We know that the data is sorted alphabetically by default.
        table.getColumnSortList().push(nameColumn);

        
        // Add it to the root panel.
        RootPanel.get().add(table);
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
