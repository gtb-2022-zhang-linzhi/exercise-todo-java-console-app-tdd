package com.tw.cn.cap.gtb.todo;

import java.util.List;

public class App {

    private final ListCommand listCommand = new ListCommand();

    public static void main(String[] args) {
        throw new UnsupportedOperationException();
    }

    public List<String> run() {
        return listCommand.run();
    }

}
