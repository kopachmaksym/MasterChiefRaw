package com.command;

import java.io.IOException;

public class Chief {
    Command salatFile;
    Command help;
    Command exit;

    public Chief(Command food, Command salat, Command salatFile, Command help, Command exit){

        this.salatFile = salatFile;
        this.help = help;
        this.exit = exit;
    }

    public void salatFileRecord() throws IOException {
        salatFile.execute();
    }

    public void helpRecord() throws IOException {
        help.execute();
    }

    public void exitRecord() throws IOException {
        exit.execute();
    }

}
