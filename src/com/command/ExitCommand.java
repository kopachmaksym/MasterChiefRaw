package com.command;

public class ExitCommand implements Command {
    Database menu;

    public ExitCommand(Database menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        menu.exit();
    }
}
