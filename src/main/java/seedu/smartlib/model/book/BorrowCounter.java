package seedu.smartlib.model.book;

import static seedu.smartlib.commons.util.AppUtil.checkArgument;

/**
 * Represents a BorrowCounter of a book in SmartLib.
 * Guarantees: immutable; is valid as declared in {@link #isValidBorrowCounter(int)}.
 */
public class BorrowCounter {

    public static final int MIN_VALUE = 1000000000;
    public static final int MAX_VALUE = 2000000000;
    public static final int BORROW_COUNTER_VALUE = 0;

    public static final String MESSAGE_CONSTRAINTS =
            "BorrowCounter should only contain numbers.";

    private int value;



    /**
     * Constructs a {@code BorrowCounter}.
     *
     * @param counter A valid counter.
     */
    public BorrowCounter(int counter) {
        assert(isValidBorrowCounter(counter));
        checkArgument(isValidBorrowCounter(counter), MESSAGE_CONSTRAINTS);
        value = counter;
    }

    /**
     * Returns the value of the borrowCounter.
     *
     * @return The value of the borrowCounter.
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns true if a given int is a valid borrowCounter.
     *
     * @param counter integer to be tested.
     * @return true if a given int is a valid borrowCounter.
     */
    public static boolean isValidBorrowCounter(int counter) {
        return (counter >= BorrowCounter.MIN_VALUE && counter <= BorrowCounter.MAX_VALUE)
                || counter == BORROW_COUNTER_VALUE;
    }

    /**
     * Increment the BorrowCount by 1 everytime the book is borrowed
     */
    public void IncrementBorrowCount() {
        value++;
    }

    /**
     * Add on the borrowCounts of other books of the same book title but different barcodes
     * @param borrowTimes
     */
    public void addBorrowCount(int borrowTimes) {
        value = value + borrowTimes;
    }

    /**
     * Returns this BorrowCounter in String format.
     *
     * @return this BorrowCounter in String format.
     */
    @Override
    public String toString() {
        return value + "";
    }

    /**
     * Checks if this BorrowCounter is equal to another BorrowCounter.
     *
     * @param other the other BorrowCounter to be compared.
     * @return true if this BorrowCounter is equal to the other BorrowCounter, and false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof BorrowCounter // instanceof handles nulls
                && value == ((BorrowCounter) other).value); // state check
    }

    /**
     * Generates a hashcode for this BorrowCounter.
     *
     * @return the hashcode for this BorrowCounter.
     */
    @Override
    public int hashCode() {
        return toString().hashCode();
    }

}
