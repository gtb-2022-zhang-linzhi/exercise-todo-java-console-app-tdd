package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.tw.cn.cap.gtb.todo.TestUtil.writeDataFile;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskRepositoryTest {

    @BeforeEach
    void setUp() {
        writeDataFile(List.of(
                "+ + task 01",
                "+ + task 02",
                "x + task 03",
                "x + task 04"));
    }

    @Test
    void  should_delete_multiple_tasks() {
        TaskRepository taskRepository = new TaskRepository();

        taskRepository.delete(1);
        taskRepository.delete(3);

        final var result = taskRepository.loadTasks();
        assertEquals(List.of(
                new Task(2, "task 02", false, false),
                new Task(4, "task 04", true, false)
        ), result);
    }

}
