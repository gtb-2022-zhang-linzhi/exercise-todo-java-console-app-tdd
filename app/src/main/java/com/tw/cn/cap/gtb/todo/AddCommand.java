package com.tw.cn.cap.gtb.todo;

import java.util.List;

public class AddCommand {
    private final String[] args;
    // Dependency Injection (OI)
    // do not confuse with DIP

    // DOC: depended on component
    final TaskRepository taskRepository;

    public AddCommand(TaskRepository taskRepository, String... args) {
        this.args = args;
        this.taskRepository = taskRepository;
    }

    List<String> execute() {
        final var taskName = String.join(" ", args);
        taskRepository.create(new Task(0, taskName, false, false));
        return List.of();
    }

}
