package assignment1.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import assignment1.database.Database;
import assignment1.models.Book;

public class BookStoreGUI extends JFrame {
    private JTextField bookIdField, bookNameField, authorNamesField, publicationField, dateOfPublicationField,
            priceOfBookField, totalQuantityField;
    private JTabbedPane tabbedPane = new JTabbedPane();
    Database db;

    public BookStoreGUI(Database db) {
        this.db = db;

        setTitle("Book Store");
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        createUI();
    }

    private void createUI() {
        createBookPanelGUI();
        readBookGUI();
        add(tabbedPane);
    }

    private void createBookPanelGUI() {
        JPanel createBookPanel = new JPanel(new GridLayout(8, 2));

        createBookPanel.add(new JLabel("Book ID:"));
        bookIdField = new JTextField();
        createBookPanel.add(bookIdField);

        createBookPanel.add(new JLabel("Book Name:"));
        bookNameField = new JTextField();
        createBookPanel.add(bookNameField);

        createBookPanel.add(new JLabel("Author Names:"));
        authorNamesField = new JTextField();
        createBookPanel.add(authorNamesField);

        createBookPanel.add(new JLabel("Publication:"));
        publicationField = new JTextField();
        createBookPanel.add(publicationField);

        createBookPanel.add(new JLabel("Date of Publication:"));
        dateOfPublicationField = new JTextField();
        createBookPanel.add(dateOfPublicationField);

        createBookPanel.add(new JLabel("Price of Book:"));
        priceOfBookField = new JTextField();
        createBookPanel.add(priceOfBookField);

        createBookPanel.add(new JLabel("Total Quantity to Order:"));
        totalQuantityField = new JTextField();
        createBookPanel.add(totalQuantityField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Book newBook = new Book(
                        Integer.parseInt(bookIdField.getText()),
                        bookNameField.getText(),
                        authorNamesField.getText(),
                        publicationField.getText(),
                        dateOfPublicationField.getText(),
                        Double.parseDouble(priceOfBookField.getText()),
                        Integer.parseInt(totalQuantityField.getText()));

                db.saveBook(newBook);
                showDialog("Book saved successfully!");
                clearInputFields();
            }
        });

        createBookPanel.add(saveButton);
        tabbedPane.addTab("Create Book", createBookPanel);
    }

    private void readBookGUI() {
        JPanel displayPanel = new JPanel(new BorderLayout());

        if (db.booksCollection.size() != 0) {
            for (Book curBook : db.booksCollection) {
                displayPanel.add(new JLabel(curBook.toHTML()));
            }
        } else {
            displayPanel.add(new JLabel("No data found"));
        }

        tabbedPane.addTab("Display Books", displayPanel);
    }

    private void showDialog(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    private void clearInputFields() {
        bookIdField.setText("");
        bookNameField.setText("");
        authorNamesField.setText("");
        publicationField.setText("");
        dateOfPublicationField.setText("");
        priceOfBookField.setText("");
        totalQuantityField.setText("");
    }
}
