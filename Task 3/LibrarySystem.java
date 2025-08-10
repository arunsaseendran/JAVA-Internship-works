import java.util.ArrayList;
import java.util.List;

// Book class
class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public void issue() { isIssued = true; }
    public void returnBook() { isIssued = false; }

    @Override
    public String toString() {
        return title + " by " + author + (isIssued ? " [Issued]" : " [Available]");
    }
}

// User class
class User {
    private String name;
    private int userId;

    public User(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() { return name; }
    public int getUserId() { return userId; }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name;
    }
}

// Library class
class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user);
    }

    public void showBooks() {
        System.out.println("\nBooks in library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void issueBook(String title, int userId) {
        Book foundBook = findBook(title);
        User foundUser = findUser(userId);

        if (foundBook == null) {
            System.out.println("Book not found!");
            return;
        }
        if (foundUser == null) {
            System.out.println("User not found!");
            return;
        }
        if (foundBook.isIssued()) {
            System.out.println("Book is already issued!");
        } else {
            foundBook.issue();
            System.out.println("Book \"" + foundBook.getTitle() + "\" issued to " + foundUser.getName());
        }
    }

    public void returnBook(String title) {
        Book foundBook = findBook(title);

        if (foundBook == null) {
            System.out.println("Book not found!");
            return;
        }
        if (!foundBook.isIssued()) {
            System.out.println("Book was not issued!");
        } else {
            foundBook.returnBook();
            System.out.println("Book \"" + foundBook.getTitle() + "\" returned successfully.");
        }
    }

    private Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    private User findUser(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }
}

// Main class to run the program
public class LibrarySystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding sample data
        library.addBook(new Book("Java Programming", "James Gosling"));
        library.addBook(new Book("Python Basics", "Guido van Rossum"));

        library.addUser(new User("Kiran", 1));
        library.addUser(new User("shankar", 2));

        library.showBooks();

        // Issue and return books
        library.issueBook("Java Programming", 1);
        library.showBooks();

        library.returnBook("Java Programming");
        library.showBooks();
    }
}
