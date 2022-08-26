public class UpdateMarkCommand extends UpdateCommand {
    private UpdateMarkCommand(String command, Task task) {
        super(command, task);
    }

    public static UpdateMarkCommand of(String command, TaskList taskList) throws IllegalArgumentException {
        int taskIndex;
        try {
            taskIndex = Parser.getTaskIndex(command, taskList);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("🙁 OOPS!!! Provide a number to mark a task.\n");
        }

        Task task;
        try {
            task = taskList.get(taskIndex);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(
                    String.format(
                            "🙁 OOPS!!! Provide a valid number (from 1 to %d) to mark a task.\n", taskList.size())
            );
        }
        return new UpdateMarkCommand(command, task);
    }

    @Override
    public void execute() {
        super.task.mark();
    }
}