package assignment1.views;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import assignment1.models.Book;

public class BookTableModel extends AbstractTableModel {
    private List<Book> data;
    private String[] columnNames = { "Book ID", "Book Name" };

    public BookTableModel(List<Book> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book book = data.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return String.valueOf(book.bookId);

            case 1:
                return book.bookName;

            default:
                return null;
        }

        // public String authorNames;
        // public String publication;
        // public String dateOfPublication;
        // public double priceOfBook;
        // public int totalQuantityToOrder;
        // public double totalCost;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
