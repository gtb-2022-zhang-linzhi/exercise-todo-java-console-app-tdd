package com.tw.cn.cap.gtb.todo;

import java.util.ArrayList;
import java.util.List;

public class App {

    private final com.tw.cn.cap.gtb.todo.taskRepository taskRepository = new taskRepository();

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run() {
        final List<Task> tasks = taskRepository.loadTasks();
        final List<String> result = new ArrayList<>();

        result.add("# To be done");
        tasks.stream()
                .filter(task -> !task.isCompleted())
                .map(Task::format)
                .forEach(result::add);

        result.add("# Completed");
        tasks.stream()
                .filter(Task::isCompleted)
                .map(Task::format)
                .forEach(result::add);

        return result;
    }
}
