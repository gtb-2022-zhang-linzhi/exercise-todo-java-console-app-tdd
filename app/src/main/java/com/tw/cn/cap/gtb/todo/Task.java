package com.tw.cn.cap.gtb.todo;

public class Task {
    private long id;
    private String name;

    public Task() {
    }

    public Task(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    String format() {
        return String.format("%d %s", getId(), getName());
    }
}