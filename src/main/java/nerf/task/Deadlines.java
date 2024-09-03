package nerf.task;

import java.time.LocalDate;

import nerf.io.Parser;

/**
 * Deadline class 
 */
public class Deadlines extends Task {
    private final LocalDate dueDate;

    public Deadlines(String description, LocalDate dueDate) {
        super(description);
        if (dueDate == null) {
            throw new IllegalArgumentException("Due date cannot be null");
        }
        this.dueDate = dueDate;
    }

    public Deadlines(String description, boolean isDone, LocalDate dueDate) {
        super(description, isDone);
        if (dueDate == null) {
            throw new IllegalArgumentException("Due date cannot be null");
        }
        this.dueDate = dueDate;
    }

    
    /**
     * Returns format for saving to file.
     * 
     * @return string format of task.
     */
    @Override
    public String getSaveFormat() {
        return String.format("D | %s | %s", super.getSaveFormat(), Parser.dateToString(this.dueDate, true));
    }

    /**
     * Returns format for printing.
     * 
     * @return string format of task.
     */
    @Override
    public String toString(){
        return String.format("[D]%s (by: %s)",super.toString(), Parser.dateToString(this.dueDate, false));
    }
}