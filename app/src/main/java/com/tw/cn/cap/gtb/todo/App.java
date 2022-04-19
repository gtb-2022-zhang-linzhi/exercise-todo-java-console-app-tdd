package com.tw.cn.cap.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run() {
        final List<String> lines = readTaskLines();
        final List<String> result = new ArrayList<>();
        result.add("# To be done");
        for (int i = 0; i < lines.size(); i++) {
            result.add(String.format("%d %s", i + 1, lines.get(i)));
        }
        return result;
    }

    private List<String> readTaskLines() {
        try {
            return Files.readAllLines(Constants.TASKS_FILE_PATH);
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
    }
}
