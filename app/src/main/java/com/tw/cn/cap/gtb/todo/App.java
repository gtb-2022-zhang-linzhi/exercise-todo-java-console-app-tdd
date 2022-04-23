package com.tw.cn.cap.gtb.todo;

import java.util.List;

public class App {

    private final ListCommand listCommand = new ListCommand();

    public static void main(String[] args) {
        new App().run().forEach(System.out::println);
    }

    public List<String> run(String... args) {
        if (args.length > 0 && args[0].equals("add")) {
            return new AddCommand(new taskRepository(), args).execute();
        }
        return listCommand.run();
    }

}
