package com.artcode.training.console.controller;

import com.artcode.training.console.commands.Commands;

import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class CommandController {

    public static final String SEPARATOR = " ";
    public static final String QUIT = "q";
    private File currentFile;
    private PrintStream printStream;

    public CommandController(PrintStream printStream) {
        this.printStream = printStream;
        this.currentFile = new File("");
    }

    private Commands getCommand(String input) {
        return Commands.valueOf(input.toUpperCase());
    }

    public void readInputCommand() {
        try {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (QUIT.equals(input)) System.exit(0);
            String[] args = input.split(SEPARATOR);
            Commands command = Commands.valueOf(args[0].toUpperCase());
            precessCommand(args, command);
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    private void precessCommand(String[] args, Commands command) {
        String result;
        if (command.equals(Commands.HELP)) {
            result = command.getCommand().execute(currentFile, Arrays.stream(Commands.values()).filter(commands1 -> !commands1.equals(Commands.HELP))
                    .map(commands -> commands.getCommand().help()).toArray(String[]::new));
        } else {
            result = command.getCommand().run(currentFile, Arrays.stream(args).skip(1).toArray(String[]::new));
        }
        if (!result.isEmpty()) printStream.println(result);
        currentFile = command.getCommand().getNewCurrentFile();
    }

    private String getCurrentLocation() {
        return currentFile.getAbsolutePath() + ">";
    }

    public void printCurrentLocation() {
        printStream.print(getCurrentLocation());
    }
}
