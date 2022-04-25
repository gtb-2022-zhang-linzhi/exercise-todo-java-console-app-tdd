package com.tw.cn.cap.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class TestUtil {
    static void writeDataFile(List<String> lines) {
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
