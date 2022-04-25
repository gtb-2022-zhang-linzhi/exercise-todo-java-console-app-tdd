package com.tw.cn.cap.gtb.todo;

import java.util.List;

public class App {

    private final TaskRepository taskRepository = new TaskRepository();

    public static void main(String[] args) {
        new App().run().forEach(System.out::println);
    }

    public List<String> run(String... args) {
        if (args.length <= 0) {
            throw new TodoException();
        }
        return CommandFactory.createCommand(this.taskRepository, args).execute();
    }
}
