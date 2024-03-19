package seedu.address.model.tag;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Tag in the address book.
 * Guarantees: immutable; name is valid as declared in {@link #isValidTagName(String)}
 */
public class Attendance {

    public static final String MESSAGE_CONSTRAINTS = "Tags names should be alphanumeric";
    public static final String VALIDATION_REGEX = "\\p{Alnum}+";

    public final String attendanceName;

    /**
     * Constructs a {@code Attendance}.
     *
     * @param attendanceName A valid tag name.
     */
    public Attendance(String attendanceName) {
        requireNonNull(attendanceName);
        checkArgument(isValidTagName(attendanceName), MESSAGE_CONSTRAINTS);
        this.attendanceName = attendanceName;
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidTagName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Attendance)) {
            return false;
        }

        Attendance otherAttendance = (Attendance) other;
        return attendanceName.equals(otherAttendance.attendanceName);
    }

    @Override
    public int hashCode() {
        return attendanceName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + attendanceName + ']';
    }

}
