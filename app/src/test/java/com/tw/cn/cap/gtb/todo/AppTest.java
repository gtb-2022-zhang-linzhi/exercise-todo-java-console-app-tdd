package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class AppTest {
    @Test
    void should_list_existing_tasks() {
        final var result = new App().run();
        Assertions.assertEquals(List.of("task 01", "task 02"), result);
    }
}
