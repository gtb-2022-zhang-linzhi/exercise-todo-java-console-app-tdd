package com.tw.cn.cap.gtb.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

class AppTest {

    private App app;

    @BeforeEach
    void setUp() {
        writeDataFile(List.of(
                "+ task 01",
                "+ task 02",
                "x task 03",
                "x task 04"));
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
                final var result = app.run();
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
                final var result = app.run();
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

    private void writeDataFile(List<String> lines) {
        try (var bufferedWriter = Files.newBufferedWriter(Constants.TASKS_FILE_PATH)) {
            for (String line : lines) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }
    }
}
