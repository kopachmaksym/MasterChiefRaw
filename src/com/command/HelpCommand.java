package com.command;

import java.io.IOException;

public class HelpCommand implements Command{
    Database menu;

    public HelpCommand(Database menu){
        this.menu = menu;
    }

    @Override
    public void execute() throws IOException {
        menu.help();
    }
}
