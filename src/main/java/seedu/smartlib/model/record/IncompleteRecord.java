package seedu.smartlib.model.record;

import seedu.smartlib.commons.core.name.Name;
import seedu.smartlib.model.book.Barcode;
import seedu.smartlib.model.book.Book;
import seedu.smartlib.model.reader.Reader;

/**
 * Incomplete record (i.e. a record with missing barcode) of a borrowing activity.
 */
public class IncompleteRecord extends Record {

    /**
     * Creates a borrowing record.
     *
     * @param barcode  barcode of the book that is borrowed.
     * @param readerName   reader who borrowed the book.
     * @param dateBorrowed borrow date of the book.
     */
    public IncompleteRecord(Barcode barcode, Name readerName, DateBorrowed dateBorrowed) {
        super(Book.TEMP_BOOKNAME, barcode, readerName, dateBorrowed);
    }

    /**
     * Creates a returning record.
     *
     * @param barcode barcode of the book that is borrowed.
     * @param dateReturned return date of the book.
     */
    public IncompleteRecord(Barcode barcode, DateReturned dateReturned) {
        super(Book.TEMP_BOOKNAME, barcode, Reader.TEMP_READERNAME, dateReturned);
    }

}
