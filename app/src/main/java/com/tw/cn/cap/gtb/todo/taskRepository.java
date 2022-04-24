package com.tw.cn.cap.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class taskRepository {

    private final TaskMarshal taskMarshal = new TaskMarshal();

    List<Task> loadTasks() {
        final List<String> lines = readTaskLines();
        final List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            tasks.add(taskMarshal.unmarshal(i + 1, lines.get(i)));
        }
        return tasks;
    }

    public void create(Task task) {
        try (var bw = Files.newBufferedWriter(Constants.TASKS_FILE_PATH, StandardOpenOption.APPEND)) {
            final String line = taskMarshal.marshal(task);
            bw.write(line);
            bw.newLine();
        } catch (IOException e) {
            throw new TodoException();
        }
    }

    List<String> readTaskLines() {
        try {
            return Files.readAllLines(Constants.TASKS_FILE_PATH);
        } catch (IOException e) {
            throw new TodoException();
        }
    }

}
