package com.company;
import java.util.HashMap;
/**
 * @author  Renato Martins
 * @version 3.1.2022
 */
public class CommandWords {
    // map between command name and the associated enum
    private HashMap<String, CommandWord> validCommands;
    
    /**
     * starts the commands
     */
    public CommandWords() {
        validCommands = new HashMap<String, CommandWord>();
        for (CommandWord command : CommandWord.values()) {
            if (command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }
    
    /**
     * finds the commands in the list of commands
     */
    public CommandWord getCommandWord(String commandWord) {
        CommandWord command = validCommands.get(commandWord);
        if (command == null) {
            return CommandWord.UNKNOWN;
        }
        return command;
    }

    /**
     * check if it is valid or not
     */
    public boolean isCommand(String aString) {
        return validCommands.containsKey(aString);
    }

    /**
     * print all commands
     */
    public void showAll() {
        for (String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
