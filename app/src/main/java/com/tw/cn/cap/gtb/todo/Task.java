package com.tw.cn.cap.gtb.todo;

public class Task {
    private final long id;
    private final String name;
    private final boolean isCompleted;

    public Task(long id, String name, boolean isCompleted) {
        this.id = id;
        this.name = name;
        this.isCompleted = isCompleted;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    String format() {
        return String.format("%d %s", getId(), getName());
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }
}