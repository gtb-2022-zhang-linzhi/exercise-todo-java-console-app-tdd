package com.tw.cn.cap.gtb.todo;

import java.util.Arrays;
import java.util.List;

public class App {

    private final ListCommand listCommand = new ListCommand();

    public static void main(String[] args) {
        new App().run().forEach(System.out::println);
    }

    public List<String> run(String... args) {
        if (args.length <= 0) {
            return listCommand.run();
        }
        final var resetArgs = Arrays.copyOfRange(args, 1, args.length);
        if (args[0].equals("add")) {
            return new AddCommand(new taskRepository(), resetArgs).execute();
        }
        if (args[0].equals("remove")) {
            return new RemoveCommand(new taskRepository(), resetArgs).execute();
        }
        return listCommand.run();
    }

}
