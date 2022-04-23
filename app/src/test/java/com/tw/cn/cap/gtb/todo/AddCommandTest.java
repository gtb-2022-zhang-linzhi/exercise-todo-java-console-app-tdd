package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddCommandTest {

    private MytaskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = new MytaskRepository();
    }

    @Test
    void should_compose_task_name_using_multiple_args() {
        final var command = new AddCommand(taskRepository, "add", "fizz", "buzz");

        command.execute();

        assertEquals("fizz buzz", taskRepository.getTaskName());
    }

    @Test
    void should_use_empty_name_when_no_args_provided() {
        final var command = new AddCommand(taskRepository, "add");

        command.execute();

        assertEquals("", taskRepository.getTaskName());
    }

    private static class MytaskRepository extends taskRepository {
        private Task task;

        @Override
        List<String> create(Task task) {
            this.task = task;
            return List.of();
        }

        public String getTaskName() {
            return this.task.getName();
        }
    }
}
