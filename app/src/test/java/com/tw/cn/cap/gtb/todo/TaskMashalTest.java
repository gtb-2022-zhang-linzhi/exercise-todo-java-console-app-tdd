package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskMashalTest {

    private TaskMarshal taskMarshal;

    @BeforeEach
    void setUp() {
        taskMarshal = new TaskMarshal();
    }

    @Test
    void should_parse_completed_property_for_task() {
        final var isCompleted = taskMarshal.unmarshal(1, "+ + foobar").isCompleted();
        assertFalse(isCompleted);
    }

    @Test
    void should_support_name_with_multiple_white_spaces() {
        final var task = taskMarshal.unmarshal(1, "+ +     foo   bar   ");
        assertEquals("    foo   bar   ", task.getName());
    }
}
