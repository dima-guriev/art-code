package com.artcode.training.console.commands;

import com.artcode.training.console.commands.implementation.ChangeLocationCommand;
import com.artcode.training.console.commands.implementation.HelpCommand;
import com.artcode.training.console.commands.implementation.ShowDirectoryContentCommand;

public enum Commands {
    CD(new ChangeLocationCommand()),
    DIR(new ShowDirectoryContentCommand()),
    HELP(new HelpCommand());

    private AbstractCommand command;

    Commands(AbstractCommand command) {
        this.command = command;
    }

    public AbstractCommand getCommand() {
        return command;
    }
}
