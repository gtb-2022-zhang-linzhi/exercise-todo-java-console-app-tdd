package com.tw.cn.cap.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskRepository {
    public TaskRepository() {
    }

    List<Task> loadTasks() {
        final List<Task> tasks = loadAllTasks();
        return tasks.stream()
                .filter(task -> !task.isDeleted())
                .collect(Collectors.toList());
    }


    List<String> readTaskLines() {
        try {
            return Files.readAllLines(Constants.TASKS_FILE_PATH);
        } catch (IOException e) {
            throw new TodoException();
        }
    }

    public void create(Task task) {
        try (var bw = Files.newBufferedWriter(Constants.TASKS_FILE_PATH, StandardOpenOption.APPEND)) {
            final String line = TaskMarshal.marshal(task);
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            throw new TodoException();
        }
    }

    public void delete(Integer id) {
        final var tasks = loadAllTasks();
        tasks.stream().filter(task -> task.getId() == id).forEach(Task::delete);
        try (var bw = Files.newBufferedWriter(Constants.TASKS_FILE_PATH)) {
            for (Task task : tasks) {
                bw.write(TaskMarshal.marshal(task));
                bw.newLine();
            }
        } catch (IOException e) {
            throw new TodoException();
        }
    }

    private List<Task> loadAllTasks() {
        final List<String> lines = readTaskLines();
        final List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            tasks.add(TaskMarshal.unmarshal(i + 1, lines.get(i)));
        }
        return tasks;
    }
}
