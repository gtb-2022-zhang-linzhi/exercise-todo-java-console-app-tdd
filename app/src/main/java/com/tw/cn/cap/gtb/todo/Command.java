package com.tw.cn.cap.gtb.todo;

import java.util.List;

public abstract class Command {
    // DOC: depended on component
    final TaskRepository taskRepository;

    Command(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    abstract List<String> execute();
}
