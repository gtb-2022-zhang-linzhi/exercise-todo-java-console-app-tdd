package com.tw.cn.cap.gtb.todo;

import java.util.ArrayList;
import java.util.List;

public record Section(String title, boolean flag) {
    static Section completed() {
        return new Section("# Completed", true);
    }

    static Section tbd() {
        return new Section("# To be done", false);
    }

    List<String> format(List<Task> tasks) {
        final List<String> result = new ArrayList<>();
        result.add(title());
        tasks.stream().filter(this::isTypeMatched).map(Task::format).forEach(result::add);
        return result;
    }

    private boolean isTypeMatched(Task task) {
        return flag() == task.isCompleted();
    }
}