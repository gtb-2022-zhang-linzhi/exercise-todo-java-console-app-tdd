package com.tw.cn.cap.gtb.todo;

import java.util.Objects;

public class Task {
    private final long id;
    private final String name;
    private final boolean isCompleted;
    private boolean deleted;

    public Task(long id, String name, boolean isCompleted) {
        this.id = id;
        this.name = name;
        this.isCompleted = isCompleted;
        deleted = false;
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

    public void delete() {
        this.deleted = true;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    @Override
    public String toString() {
        return id + " " + isCompleted + " " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && isCompleted == task.isCompleted && Objects.equals(name, task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isCompleted);
    }
}
