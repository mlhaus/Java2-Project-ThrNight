package java1review;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int numPages;
    private boolean read;
    public static final String DEFAULT_TITLE = "Undefined";
    private static int bookCount = 0;

    public Book() {
        title = DEFAULT_TITLE;
        author = DEFAULT_TITLE;
        numPages = 1;
        read = false;
        bookCount++;
    }

    public Book(String title, String author, int numPages, boolean read) {
        this.title = title;
        this.author = author;
        this.numPages = numPages;
        this.read = read;
        bookCount++;
    }

    public static int getBookCount() {
        return bookCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.equals("")) {
            throw new IllegalArgumentException("The title is required.");
        } else {
            this.title = title;
        }
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author.equals("")) {
            throw new IllegalArgumentException("The author is required.");
        } else {
            this.author = author;
        }
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        if (numPages < 1) {
            throw new IllegalArgumentException("There must be at least one page.");
        }
        this.numPages = numPages;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numPages=" + numPages +
                ", read=" + read +
                '}';
    }

    @Override
    public int compareTo(Book o) {
        int result = (this.numPages - o.numPages) * -1;
        if(result == 0) { // if the books have the same number of pages
            this.title.compareTo(o.title);
        }
        return result;
    }
}
