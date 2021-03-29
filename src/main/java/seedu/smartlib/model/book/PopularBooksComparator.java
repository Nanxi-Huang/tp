package seedu.smartlib.model.book;


import java.util.Comparator;

public class PopularBooksComparator implements Comparator<Book> {

    @Override
    public int compare(Book thisBook, Book otherBook) {
        if(thisBook.getName().toString().length() >= otherBook.getName().toString().length()) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Checks if this PopularBooksComparator is equal to another PopularBooksComparator
     *
     * @param other the other PopularBooksComparator to be compared.
     * @return true if this PopularBooksComparator is equal to the other PopularBooksComparator,
     *         and false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PopularBooksComparator); // instanceof handles nulls
    }
}
