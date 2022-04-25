package com.tw.cn.cap.gtb.todo;

import java.util.List;
import java.util.stream.Stream;

public class RemoveCommand {
    private final taskRepository taskRepository;
    private final String[] args;

    public RemoveCommand(taskRepository taskRepository, String... args) {
        this.taskRepository = taskRepository;
        this.args = args;
    }

    public List<String> execute() {
        Stream.of(args)
                .map(Integer::valueOf)
                .forEach(this.taskRepository::delete);
        return List.of();
    }
}
