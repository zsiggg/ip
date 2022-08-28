package duke.command;

import duke.Storage;
import duke.TaskList;
import duke.Ui;

import java.io.IOException;

public abstract class Command {
    public enum Commands {
        mark, unmark, todo, deadline, event, delete, bye, list
    }

    protected String command;
    protected boolean isExit = false;

    public Command(String command) {
        this.command = command;
    }

    public boolean getIsExit() {
        return isExit;
    }

    public abstract void execute(TaskList taskList, Storage storage, Ui ui);

    // this method will not print anything
    public abstract void execute(TaskList taskList, Storage storage) throws IOException;
}