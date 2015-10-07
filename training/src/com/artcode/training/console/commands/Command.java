package com.artcode.training.console.commands;

import java.io.File;

public interface Command {

    String help();

    String execute(File file, String... args);
}
