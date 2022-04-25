package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RemoveCommandTest {

    private TaskRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(TaskRepository.class);
        when(repository.all()).thenReturn(List.of(
                new Task(1, "task 01", false, false),
                new Task(2, "task 02", false, false),
                new Task(3, "task 03", true, false),
                new Task(4, "task 04", true, false)
        ));
    }

    @Test
    void should_remove_multiple_tasks() {
        RemoveCommand command = new RemoveCommand(repository, "1", "3");

        command.execute();

        verify(repository).delete(1);
        verify(repository).delete(3);
    }

    @Test
    void should_only_remove_existing_tasks() {
        RemoveCommand command = new RemoveCommand(repository, "1", "3", "404");

        command.execute();

        verify(repository).delete(1);
        verify(repository).delete(3);
        verify(repository, never()).delete(404);
    }

}
