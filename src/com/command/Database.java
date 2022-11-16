package com.command;
import com.file.*;
import java.io.IOException;
import java.util.Scanner;

public class Database {
    Scanner scanner = new Scanner(System.in);
    public Database(SalatFileCommand salatFileCommand, HelpCommand helpCommand, ExitCommand exitCommand) {
    }

    public Database() {

    }


    public void salatFile() throws IOException {
                 /*
                 Read file Salats.txt (it contains all saved salats)
                 */
        System.out.println("\n\n\n");
        FileWorking file = new FileWorking();
        file.FileReading("C:\\Users\\mk410\\OneDrive\\Desktop\\JavaProjects\\MasterChiefRaw\\src\\com\\file\\Salats.txt");
        System.out.print("Insert any number to continue: ");
        int numb = scanner.nextInt();
    }

    public void help() throws IOException {
                /*
                Read file Help.txt (it contains documentation of using progmamme)
                */
        System.out.println("\n\n\n");
        FileWorking file = new FileWorking();
        file.FileReading("C:\\Users\\mk410\\OneDrive\\Desktop\\JavaProjects\\MasterChiefRaw\\src\\com\\file\\Help.txt");
        System.out.print("Insert any number to continue: ");
        int numb = scanner.nextInt();
    }

    public void exit(){
        System.exit(0);
    }

}
