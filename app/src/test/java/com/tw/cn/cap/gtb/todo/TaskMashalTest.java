package com.tw.cn.cap.gtb.todo;

//import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TaskMashalTest {
    @ParameterizedTest
    @MethodSource("lines_and_tasks")
    void should_mashal_to_plain_text(String line, Task task) {
        assertEquals(line, TaskMarshal.marshal(task));
    }

    private static Stream<Arguments> lines_and_tasks() {
        return Stream.of(
                Arguments.of("+ foobar", new Task(1, "foo", false)),
                Arguments.of("+     foo   bar   ", new Task(1, "    foo   bar   ", false))
        );
    }

//    @Test
//    void should_parse_completed_property_for_task() {
//        final var isCompleted = TaskMarshal.unmarshal(1, "+ + foobar").isCompleted();
//        assertFalse(isCompleted);
//    }
//
//    @Test
//    void should_support_name_with_multiple_white_spaces() {
//        final var task = TaskMarshal.unmarshal(1, "+     foo   bar   ");
//        assertEquals("    foo   bar   ", task.getName());
//    }
}
