package com.tw.cn.cap.gtb.todo;

import java.util.List;

public class UnknownCommand extends Command {
    private final String commandName;

    public UnknownCommand(TaskRepository repository, String commandName) {
        super(repository);
        this.commandName = commandName;
    }

    @Override
    List<String> execute() {
        return List.of("Unknown command: " + commandName + "!");
    }
}
