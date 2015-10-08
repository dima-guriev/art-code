package com.artcode.training.console.view;

import com.artcode.training.console.controller.CommandController;

public class ConsoleView {
    public static void main(String[] args) {
        CommandController commandController = new CommandController();
        while (true) {
            System.out.print(commandController.getCurrentLocation());
            String result = commandController.readInputCommand();
            if (!result.isEmpty()) {
                System.out.println(result);
            }
        }
    }
}
