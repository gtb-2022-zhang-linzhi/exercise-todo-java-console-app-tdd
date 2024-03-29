package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class AppTest {

    private App app;

    @BeforeEach
    void setUp() {
        TestUtil.writeDataFile(List.of(
                "+ + task 01",
                "+ + task 02",
                "x + task 03",
                "x + task 04"));
        app = new App();
    }

    @Nested
    class ListCommand {
        @Nested
        class WhenThereAreExistingTasks {
            @Test
            void should_list_existing_tasks() {
                // Given
                // When
                final var result = app.run("list");
                // Then
                Assertions.assertEquals(List.of(
                                "# To be done",
                                "1 task 01",
                                "2 task 02",
                                "# Completed",
                                "3 task 03",
                                "4 task 04"),
                        result);
            }
        }
    }

    @Nested
    class AddCommand {
        @Nested
        class WhenSingleWordProvided {
            @Test
            void should_add_task_with_single_word_as_name() {
                app.run("add", "foobar");
                final var result = app.run("list");
                Assertions.assertEquals(List.of(
                                "# To be done",
                                "1 task 01",
                                "2 task 02",
                                "5 foobar",
                                "# Completed",
                                "3 task 03",
                                "4 task 04"),
                        result);
            }
        }
    }

    @Nested
    class RemoveTask {
        @Nested
        class WhenSingleIdProvided {
            @Test
            void should_remove_single_task() {
                app.run("remove", "1");
                Assertions.assertEquals(List.of(
                                "# To be done",
                                "2 task 02",
                                "# Completed",
                                "3 task 03",
                                "4 task 04"),
                        app.run("list"));
            }
        }

        @Nested
        class WhenMultipleIdsProvided {
            @Test
            void should_remove_them_all() {
                app.run("remove", "1", "3");
                Assertions.assertEquals(List.of(
                                "# To be done",
                                "2 task 02",
                                "# Completed",
                                "4 task 04"),
                        app.run("list"));
            }
        }
    }


    @Nested
    class UnknownCommand {
        @Nested
        class WhenCommandMeanIsUnknown {
            @Test
            void should_give_hint() {
                final var result = app.run("foobar");
                Assertions.assertEquals(List.of(
                                "Unknown command: foobar!"), result);
            }
        }
    }

}
