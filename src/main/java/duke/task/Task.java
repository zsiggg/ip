package duke.task;

/**
 * A Task contains text and can be marked as done.
 */
public abstract class Task {
    private boolean isDone;
    private String text;
    private String tag;

    /**
     * Constructor for Task.
     *
     * @param isDone boolean denoting whether Task should be marked.
     * @param text description of task.
     */
    public Task(boolean isDone, String text, String tag) {
        this.isDone = isDone;
        this.text = text;
        this.tag = tag;
    }

    /**
     * Marks task as done.
     */
    public void mark() {
        this.isDone = true;
    }

    /**
     * Unmarks tasks to become undone.
     */
    public void unmark() {
        this.isDone = false;
    }

    /**
     * Check whether task's description contains a string.
     *
     * @param s string to be checked.
     * @return true if substring of description contains s, false otherwise.
     */
    public boolean textContains(String s) {
        return this.text.contains(s);
    }

    @Override
    public String toString() {
        if (this.tag.isEmpty()) {
            return String.format("[%c] %s", isDone ? 'X' : ' ', this.text);
        } else {
            return String.format("[%s] [%c] %s", this.tag, isDone ? 'X' : ' ', this.text);
        }
    }
}
