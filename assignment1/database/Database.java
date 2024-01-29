package assignment1.database;

import java.io.*;
import java.util.*;

import assignment1.models.Book;

public class Database {
    public ArrayList<Book> booksCollection = new ArrayList<Book>();

    public Database() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Books.dat"))) {
            booksCollection.addAll((ArrayList<Book>) ois.readObject());
            ois.close();
        } catch (FileNotFoundException e) {
        } catch (EOFException e) {
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void saveBooksCollection() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Books.dat"))) {
            oos.writeObject(booksCollection);
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void createBook(Book newBook) {
        booksCollection.add(newBook);
        saveBooksCollection();
    }

    public void deleteBook(int index) {
        booksCollection.remove(index);
        saveBooksCollection();
    }

    public void updateBook(int index, Book book) {
        booksCollection.set(index, book);
        saveBooksCollection();
    }
}
