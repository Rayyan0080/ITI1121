import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book book1, Book book2) {
        int compareAuthors = book1.getAuthor().compareTo(book2.getAuthor());
        if (compareAuthors != 0) return compareAuthors;

        int compareTitles = book1.getTitle().compareTo(book2.getTitle());
        if (compareTitles != 0) return compareTitles;

        return Integer.compare(book1.getYear(), book2.getYear());
    }
}
