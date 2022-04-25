package com.tw.cn.cap.gtb.todo;

import java.util.ArrayList;
import java.util.List;

public class ListCommand extends Command{

    public ListCommand(TaskRepository taskRepository, String... ignored) {
        super(taskRepository);
    }

    List<String> execute() {
        final List<Task> tasks = taskRepository.all();
        final List<String> result = new ArrayList<>();
        result.addAll(Section.tbd().format(tasks));
        result.addAll(Section.completed().format(tasks));
        return result;
    }
}
