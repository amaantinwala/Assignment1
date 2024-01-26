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

    public void saveBook(Book newBook) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Books.dat"))) {
            booksCollection.add(newBook);
            oos.writeObject(booksCollection);
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
