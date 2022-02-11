package com.company;
import java.util.Scanner;
/**
 * @author  Renato Martins
 * @version 3.1.2022
 */

public class Parser {
    private CommandWords commands;  // holds all valid command words
    private Scanner reader;         // source of command input

    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * Checks both words inserted eg. (Go, North)
     */
    public Command getCommand() {
        String inputLine;   // will hold the full input line
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     // print prompt

        inputLine = reader.nextLine();

        // Find up to two words on the line.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // get first word
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // get second word
                // note: we just ignore the rest of the input line.
            }
        }

        return new Command(commands.getCommandWord(word1), word2);
    }

    /**
     * Print commands.
     */
    public void showCommands() {
        commands.showAll();
    }
}
