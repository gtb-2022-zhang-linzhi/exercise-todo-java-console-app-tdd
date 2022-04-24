package com.tw.cn.cap.gtb.todo;

public class TaskFactory {
    private TaskFactory() {
    }

    static Task createTask(int id, String line) {
        final var fields = line.split(" ", 3);
        final var name = fields[2];
        final var isCompleted = fields[0].equals("x");
        final var isDeleted = fields[1].equals("x");
        return new Task(id, name, isCompleted, isDeleted);
    }
}
