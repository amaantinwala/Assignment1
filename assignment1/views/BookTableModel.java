package assignment1.views;

import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

import assignment1.models.Book;

public class BookTableModel extends AbstractTableModel {
    private List<Book> data;
    private String[] columnNames = { "ID", "Name", "Authors", "Publication", "Publication Date", "Price", "Quantity",
            "Total Cost", " ", " " };

    public void setData(List<Book> data) {
        this.data = data;
        fireTableChanged(null);
    }

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
            case 2:
                return book.authorNames;
            case 3:
                return book.publication;
            case 4:
                return book.dateOfPublication;
            case 5:
                return book.priceOfBook;
            case 6:
                return book.totalQuantityToOrder;
            case 7:
                return book.totalCost;
            case 8:
                return "Edit 🖊️";
            case 9:
                return "Delete 🗑️";
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 8 || columnIndex == 9)
            return JButton.class;

        return String.class;
    }
}

class ButtonRenderer extends JButton implements TableCellRenderer, ActionListener {
    public ButtonRenderer() {
        setOpaque(true);
        addActionListener(this);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        setText((value == null) ? "" : value.toString());
        return this;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clicked");
    }
}