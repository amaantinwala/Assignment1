package assignment1.models;

import java.io.Serializable;

public class Book implements Serializable {
    int bookId;
    String bookName;
    String authorNames;
    String publication;
    String dateOfPublication;
    double priceOfBook;
    int totalQuantityToOrder;
    double totalCost;
    private static final long serialVersionUID = 6529685098267757690L;

    public Book() {
    }

    public Book(int bookId, String bookName, String authorNames, String publication, String dateOfPublication,
            double priceOfBook, int totalQuantityToOrder) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorNames = authorNames;
        this.publication = publication;
        this.dateOfPublication = dateOfPublication;
        this.priceOfBook = priceOfBook;
        this.totalQuantityToOrder = totalQuantityToOrder;
        this.totalCost = priceOfBook * totalQuantityToOrder;
    }

    public String toHTML() {
        return "<html><p>Book ID: " + bookId + "<br />Book Name: " + bookName + "</p><hr /></html>";
    }
}
