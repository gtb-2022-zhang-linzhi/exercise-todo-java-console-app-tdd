package com.tw.cn.cap.gtb.todo;

public class TaskMarshal {
    private TaskMarshal() {
    }

    static String marshal(Task task) {
        final var completedSign = task.isCompleted() ? "x": "+";
        return completedSign + " " + task.getName();
    }

    static Task unmarshal(int id, String line) {
        final var fields = line.split(" ", 2);
        final var name = fields[1];
        final var isCompleted = fields[0].equals("x");
        return new Task(id, name, isCompleted);
    }
}
