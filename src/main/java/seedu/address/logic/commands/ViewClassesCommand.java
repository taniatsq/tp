package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Model;

/**
 * Lists all Classes in the UniqueClassList to the user.
 */
public class ViewClassesCommand extends Command {

    public static final String COMMAND_WORD = "view";

    public static final String MESSAGE_SUCCESS = "Here are your classes: ";
    public static final String selectInstruction = "\nPlease use the 'select' command to choose a class to manage!"
            + "\nOr use the 'create' command to create a class to manage!";
    public static final String createInstruction = "You are not managing any classes currently.\nPlease use "
            + "the 'create' command to create a class to manage!";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        String formattedClassList = model.getFormattedClassList();


        if (formattedClassList.isEmpty()) {
            return new CommandResult(createInstruction);
        }
        model.viewClasses();
        return new CommandResult(MESSAGE_SUCCESS + formattedClassList + selectInstruction);
    }
}

