package com.artcode.training.console.view;

import com.artcode.training.console.controller.CommandController;

public class ConsoleView {
    public static void main(String[] args) {
        CommandController commandController = new CommandController(System.out);
        while (true) {
            commandController.printCurrentLocation();
            commandController.readInputCommand();
        }
    }
}
