package seedu.smartlib.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.smartlib.model.Model;
import seedu.smartlib.model.book.PopularBooksComparator;

/**
 * Lists all books sorted by popularity in SmartLib to the user.
 */
public class ListPopularBooksCommand extends Command {

    public static final String COMMAND_WORD = "popularbooks";

    public static final String MESSAGE_SUCCESS = "Listed all books (sorted by popularity)";

    /**
     * Executes the command and returns the result message.
     *
     * @param model {@code Model} which the command should operate on.
     * @return feedback message of the operation result for display.
     */
    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updatePopularBookList(new PopularBooksComparator());
        return new CommandResult(MESSAGE_SUCCESS);
    }

}
