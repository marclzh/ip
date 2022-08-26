package duke.task;

/**
 * This class inherits from the abstract Task class
 * and encapsulates the logic of a ToDo task.
 */
public class ToDo extends Task{
    /**
     * Constructor for the Todo Task.
     * @param description description of the task.
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Overriden toString method for the Todo Task.
     * @return String representation of the Todo.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    /**
     * Override save format method from Task class.
     *
     * @return formatted String for the Event task.
     */
    @Override
    public String saveFormat() {
        return String.format("T | %s", super.saveFormat());
    }
}
