package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

class SectionTest {

    @Test
    void should_show_hint_message_when_section_has_no_tasks() {
        Assertions.assertEquals(List.of("# To be done", "Empty"),
                Section.tbd().format(Collections.emptyList()));
        Assertions.assertEquals(List.of("# Completed", "Empty"),
                Section.completed().format(Collections.emptyList()));
    }
}