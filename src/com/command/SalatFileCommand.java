package com.command;

import java.io.IOException;

public class SalatFileCommand implements Command{
    Database menu;

    public SalatFileCommand(Database menu){
        this.menu = menu;
    }

    @Override
    public void execute() throws IOException {
        menu.salatFile();
    }
}
