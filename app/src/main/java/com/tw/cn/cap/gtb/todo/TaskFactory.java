package com.tw.cn.cap.gtb.todo;

public class TaskFactory {
    private TaskFactory() {
    }

    static Task createTask(int id, String line) {
        final var name = line.split(" ", 2)[1];
        return new Task(id, name);
    }
}