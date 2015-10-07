package com.artcode.training.console.commands;

import java.io.File;

public class ChangeLocationCommand extends AbstractCommand {
    @Override
    public String help() {
        return "cd .. - go to parent directory\n"
                + "cd directory[" + File.separator + "directory] - go to child directory\n"
                + "cd absolute path - go to specified directory";
    }

    @Override
    public String execute(File file, String... args) {
        String join = String.join("", args);
        if ("..".equals(join)) {
            newCurrentFile = file.getAbsoluteFile().getParentFile();
        } else if (join.contains(":")) {
            File newFile = new File(join);
            newCurrentFile = newFile.isDirectory() && newFile.exists() ? newFile : file;
        } else {
            File newFile = new File(file.getAbsolutePath() + File.separator + join);
            newCurrentFile = newFile.isDirectory() && newFile.exists() ? newFile : file;
        }
        return "";
    }
}
