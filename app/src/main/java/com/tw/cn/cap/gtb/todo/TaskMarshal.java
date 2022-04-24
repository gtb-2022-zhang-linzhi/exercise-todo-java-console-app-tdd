package com.tw.cn.cap.gtb.todo;

public class TaskMarshal {
    private TaskMarshal() {
    }

    static final String valueIsTrue = "x";
    static final String valueIsFalse = "+";

    static String marshal(Task task) {
        final var completedSign = task.isCompleted() ? valueIsTrue : valueIsFalse;
        final var deletedSign = task.isDeleted() ? valueIsTrue : valueIsFalse;
        return completedSign + " " + deletedSign + " " + task.getName();
    }

    static Task unmarshal(int id, String line) {
        final var fields = line.split(" ", 3);
        final var isCompleted = fields[0].equals(valueIsTrue);
        final var isDeleted = fields[1].equals(valueIsTrue);
        final var name = fields[2];
        return new Task(id, name, isCompleted, isDeleted);
    }
}
