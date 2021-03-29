package seedu.smartlib.model.book;

import static seedu.smartlib.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.smartlib.commons.core.name.Name;

/**
 * Represents a book in SmartLib.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Book {

    // Identity fields
    private final Name name;

    // Data fields
    private final Author author;
    private final Publisher publisher;
    private final Isbn isbn;
    private final Genre genre;
    private final Name borrowerName;
    private final Barcode barcode;
    private BorrowCounter borrowCount;

    /**
     * Constructor for the Book class.
     * Every field must be present and not null.
     *
     * @param name Name of the book.
     * @param author Author of the book.
     * @param publisher Publisher of the book.
     * @param isbn ISBN of the book.
     * @param barcode Barcode of the book.
     * @param genre Genre of the book.
     */
    public Book(Name name, Author author, Publisher publisher, Isbn isbn, Barcode barcode, Genre genre) {
        requireAllNonNull(name, author, publisher, isbn, genre);
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.barcode = barcode;
        this.genre = genre;
        this.borrowerName = null;
        this.borrowCount = new BorrowCounter(0);
    }

    /**
     * Constructor for the Book class.
     * Every field must be present and not null.
     *
     * @param name Name of the book.
     * @param author Author of the book.
     * @param publisher Publisher of the book.
     * @param isbn ISBN of the book.
     * @param barcode Barcode of the book.
     * @param genre Genre of the book.
     * @param borrowerName Reader who borrowed the book.
     */
    public Book(Name name, Author author, Publisher publisher, Isbn isbn, Barcode barcode, Genre genre,
                Name borrowerName) {
        requireAllNonNull(name, author, publisher, isbn);
        this.name = name;
        this.author = author;
        this.publisher = publisher;
        this.isbn = isbn;
        this.barcode = barcode;
        this.genre = genre;
        this.borrowerName = borrowerName;
        this.borrowCount = new BorrowCounter(0);
    }

    /**
     * Retrieves the name of the reader who borrowed this book.
     *
     * @return the name of the reader who borrowed this book.
     */
    public Name getBorrowerName() {
        return this.borrowerName;
    }

    /**
     * Indicates whether this book is borrowed to a reader.
     *
     * @return true if this book is borrowed to a reader, and false otherwise.
     */
    public boolean isBorrowed() {
        return this.borrowerName != null;
    }

    /**
     * Gets the name of the book.
     *
     * @return name of the book.
     */
    public Name getName() {
        return name;
    }

    /**
     * Gets the author of the book.
     *
     * @return author of the book.
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Gets the publisher of the book.
     *
     * @return publisher of the book.
     */
    public Publisher getPublisher() {
        return publisher;
    }

    /**
     * Gets the ISBN of the book.
     *
     * @return ISBN of the book.
     */
    public Isbn getIsbn() {
        return isbn;
    }

    /**
     * Gets the genre of the book.
     *
     * @return genre of the book.
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Gets the barcode of the book.
     *
     * @return barcode of the book.
     */
    public Barcode getBarcode() {
        return barcode;
    }

    /**
     * Gets the number of times the book is borrowed.
     *
     * @return borrowCount of the book.
     */
    public int getBorrowCount() {
        return borrowCount.getValue();
    }

    /**
     * Returns true if both books have the same name and barcode.
     * This defines a weaker notion of equality between two books.
     *
     * @param otherBook the book to be compared with this book.
     * @return true if both books have the same name and barcode, and false otherwise.
     */
    public boolean isSameBook(Book otherBook) {
        if (otherBook == this) {
            return true;
        }

        return otherBook != null
                && otherBook.getName().equals(getName())
                && otherBook.getBarcode().equals(getBarcode());
    }

    /**
     * Increment the BorrowCount by 1 everytime the book is borrowed
     */
    public void IncrementBorrowCount() {
        borrowCount.IncrementBorrowCount();
    }

    /**
     * Add on the borrowCounts of other books of the same book title but different barcodes
     * @param borrowTimes
     */
    public void addBorrowCount(int borrowTimes) {
        borrowCount.addBorrowCount(borrowTimes);
    }

    /**
     * Checks if this Book is equal to another Book.
     * A stronger notion of equality between two books.
     *
     * @param other the book to be compared with this book.
     * @return true if this Book is equal to the other Book, and false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Book)) {
            return false;
        }

        Book otherBook = (Book) other;
        return otherBook.getName().equals(getName())
                && otherBook.getAuthor().equals(getAuthor())
                && otherBook.getPublisher().equals(getPublisher())
                && otherBook.getIsbn().equals(getIsbn())
                && otherBook.getGenre().equals(getGenre())
                && otherBook.getBarcode().equals(getBarcode())
                && ((otherBook.getBorrowCount() - getBorrowCount()) == 0);
    }

    /**
     * Generates a hashcode for this Book.
     *
     * @return the hashcode for this Book.
     */
    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, author, publisher, isbn);
    }

    /**
     * Returns this Book in String format.
     *
     * @return this Book in String format.
     */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Author: ")
                .append(getAuthor())
                .append("; Publisher: ")
                .append(getPublisher())
                .append("; Isbn: ")
                .append(getIsbn())
                .append("; Barcode: ")
                .append(getBarcode())
                .append("; Genre: ")
                .append(getGenre())
                .append("; Borrower: ")
                .append(isBorrowed() ? this.borrowerName : "Not borrowed.")
                .append("; BorrowCount: ")
                .append(getBorrowCount());

        return builder.toString();
    }

}
