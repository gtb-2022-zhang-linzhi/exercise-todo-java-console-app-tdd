package com.tw.cn.cap.gtb.todo;

import java.util.ArrayList;
import java.util.List;

public class ListCommand {
    final com.tw.cn.cap.gtb.todo.taskRepository taskRepository = new taskRepository();

    List<String> run() {
        final List<Task> tasks = taskRepository.loadTasks();
        final List<String> result = new ArrayList<>();
        result.addAll(Section.tbd().format(tasks));
        result.addAll(Section.completed().format(tasks));
        return result;
    }
}