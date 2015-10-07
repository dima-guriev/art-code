package com.artcode.training.console.commands;

public enum Commands {
    CD(new ChangeLocationCommand()),
    HELP(new HelpCommand());

    private AbstractCommand command;

    Commands(AbstractCommand command) {
        this.command = command;
    }

    public AbstractCommand getCommand() {
        return command;
    }
}
