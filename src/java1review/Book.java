package java1review;

public class Book implements Comparable<Book> {
    private int id;
    private String title;
    private Person author;
    private int numPages;
    private boolean read;
    public static final String DEFAULT_TITLE = "Undefined";

    public Book() {
        id = 0;
        title = DEFAULT_TITLE;
        author = new Person();
        numPages = 1;
        read = false;
    }
    
    public Book(String title) {
        id = 0;
        this.title = title;
        author = new Person();
        numPages = 1;
        read = false;
    }

    public Book(int id, String title, Person author, int numPages, boolean read) {
        setId(id);
        setTitle(title);
        setAuthor(author);
        setNumPages(numPages);
        setRead(read);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0) {
            throw new IllegalArgumentException("id cannot be negative");
        }
        this.id = id;
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

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        if (author == null) {
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
        return title + " by: " + author;
    }

    @Override
    public int compareTo(Book o) {
        int result = this.title.compareTo(o.title);
        if(result == 0) { // if the books have the same number of pages
            result = (this.numPages - o.numPages) * -1;
        }
        return result;
    }
}
