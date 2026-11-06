public class Book {

    private String author;
    private String title;
    private int year;

    public Book(String author, String title, int year) {
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || !(obj instanceof Book)) return false;

        Book otherBook = (Book) obj;
        boolean sameAuthor = (author == null && otherBook.author == null) || 
                             (author != null && author.equals(otherBook.author));
        boolean sameTitle = (title == null && otherBook.title == null) || 
                            (title != null && title.equals(otherBook.title));
        return sameAuthor && sameTitle && year == otherBook.year;
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%d)", author, title, year);
    }
}
