package seedu.smartlib.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.smartlib.commons.core.Messages;
import seedu.smartlib.model.Model;
import seedu.smartlib.model.book.PopularBooksComparator;

/**
 * Finds and lists all books in SmartLib whose name contains any of the argument keywords.
 * Keyword matching is case insensitive.
 */
public class ListPopularBooksCommand extends Command {

    public static final String COMMAND_WORD = "popularbooks";

    private final PopularBooksComparator comparator;

    /**
     * Creates an ListPopularBooksCommand to sort books by popularity.
     *
     */
    public ListPopularBooksCommand(PopularBooksComparator comparator) {
        this.comparator = comparator;
    }

    /**
     * Executes the command and returns the result message.
     *
     * @param model {@code Model} which the command should operate on.
     * @return feedback message of the operation result for display.
     */
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updatePopularBookList(comparator);
        return new CommandResult(
                String.format(Messages.MESSAGE_BOOKS_LISTED_OVERVIEW, model.getFilteredBookList().size()));
    }

    /**
     * Checks if this ListPopulatBooksCommand is equal to another ListPopularBooksCommand.
     *
     * @param other the other ListPopularBooksCommand to be compared.
     * @return true if this ListPopularBooksCommand is equal to the other ListPopularBooksCommand, and false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ListPopularBooksCommand // instanceof handles nulls
                && comparator.equals(((ListPopularBooksCommand) other).comparator)); // state check
    }

}
