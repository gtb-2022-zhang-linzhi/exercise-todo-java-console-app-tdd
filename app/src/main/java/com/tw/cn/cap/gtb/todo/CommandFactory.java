package com.tw.cn.cap.gtb.todo;

import java.util.Arrays;

public class CommandFactory {

    private CommandFactory() {
    }

    static Command createCommand(TaskRepository repository, String[] args) {
        final var commandName = args[0];
        final var resetArgs = Arrays.copyOfRange(args, 1, args.length);

        Command command = new ListCommand(repository, resetArgs);
        if (commandName.equals("add")) {
            command = new AddCommand(repository, resetArgs);
        }
        if (commandName.equals("remove")) {
            command = new RemoveCommand(repository, resetArgs);
        }
        return command;
    }
}
