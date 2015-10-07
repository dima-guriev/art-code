package com.artcode.training.console.commands;

import java.io.File;

public class HelpCommand extends AbstractCommand {
    @Override
    public String help() {
        return "--help - show all available commands;";
    }

    @Override
    public String execute(File file, String... args) {
        newCurrentFile = file;
        StringBuilder builder = new StringBuilder();
        builder.append(help());
        for (String arg : args) {
            builder.append("\n");
            builder.append("\n");
            builder.append(arg);
        }
        return builder.toString();
    }
}
