package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RemoveCommandTest {

    @Test
    void should_remove_multiple_tasks() {
        final var repository = mock(TaskRepository.class);
        RemoveCommand command = new RemoveCommand(repository, "1", "3");

        command.execute();

        verify(repository).delete(1);
        verify(repository).delete(3);
    }

}
