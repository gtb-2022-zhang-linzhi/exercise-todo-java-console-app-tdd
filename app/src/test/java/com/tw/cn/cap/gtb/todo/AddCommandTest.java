package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AddCommandTest {

    private taskRepository taskRepository;

    @BeforeEach
    void setUp() {
        taskRepository = mock(taskRepository.class);
    }

    @Test
    void should_compose_task_name_using_multiple_args() {
        final AddCommand command = createCommandFrom("fizz", "buzz");

        command.execute();

        verify(taskRepository).create(new Task(0, "fizz buzz", false));
    }

    @Test
    void should_use_empty_name_when_no_args_provided() {
        final AddCommand command = createCommandFrom();

        command.execute();

        verify(taskRepository).create(new Task(0, "", false));
    }

    private AddCommand createCommandFrom(String... args) {
        return new AddCommand(taskRepository, args);
    }

}
