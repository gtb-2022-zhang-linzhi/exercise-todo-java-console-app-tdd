package com.tw.cn.cap.gtb.todo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class App {
    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run() {
        try {
            return Files.readAllLines(Path.of("/Users/Zhanglinzhi/.todo/tasks"));
        } catch (IOException e) {
            throw new TodoCannotReadFileException();
        }
    }
}
