package com.tw.cn.cap.gtb.todo;

import java.util.List;

public class AddCommand extends Command {
    private final String[] args;
    // Dependency Injection (OI)
    // do not confuse with DIP

    public AddCommand(TaskRepository taskRepository, String... args) {
        super(taskRepository);
        this.args = args;
    }

    @Override
    List<String> execute() {
        final var taskName = String.join(" ", args);
        taskRepository.create(new Task(0, taskName, false, false));
        return List.of();
    }

}
