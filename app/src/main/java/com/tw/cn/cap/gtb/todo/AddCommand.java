package com.tw.cn.cap.gtb.todo;

import java.util.List;

public class AddCommand {
    private final String[] args;
    final taskRepository taskRepository = new taskRepository();

    public AddCommand(String[] args) {
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }

    List<String> execute() {
        return taskRepository.create(new Task(0, getArgs()[1], false));
    }

}
