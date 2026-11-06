import java.util.ArrayList;
import java.util.Collections;

public class Library {

    private ArrayList<Book> collection;

    public Library() {
        collection = new ArrayList<>();
    }

    public void addBook(Book book) {
        collection.add(book);
    }

    public void sort() {
        Collections.sort(collection, new BookComparator());
    }

    public void printLibrary() {
        for (Book book : collection) {
            System.out.println(book);
        }
    }

    public Book getBook(int index) {
        return collection.get(index);
    }

    public int getSize() {
        return collection.size();
    }
}
