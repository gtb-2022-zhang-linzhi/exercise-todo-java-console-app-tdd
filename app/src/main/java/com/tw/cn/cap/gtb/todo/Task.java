package com.tw.cn.cap.gtb.todo;

import java.util.Objects;

public class Task {
    private final long id;
    private final String name;
    private final boolean completed;
    private boolean deleted;

    public Task(long id, String name, boolean isCompleted, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.completed = isCompleted;
        this.deleted = isDeleted;
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
        return this.completed;
    }

    public void delete() {
        this.deleted = true;
    }

    public boolean isDeleted() {
        return this.deleted;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isCompleted=" + completed +
                ", deleted=" + deleted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && completed == task.completed && deleted == task.deleted && name.equals(task.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, completed, deleted);
    }
}
