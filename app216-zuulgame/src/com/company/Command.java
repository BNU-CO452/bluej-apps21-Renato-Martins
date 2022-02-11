package com.company;
/**
 * @author  Renato Martins
 * @version 3.1.2022
 */
public class Command {
    private CommandWord commandWord;
    private String secondWord;

    /**
     * Command object 2 words need to be provided
     */
    public Command(CommandWord commandWord, String secondWord) {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    /**
     * return command for the first word
     */
    public CommandWord getCommandWord() {
        return commandWord;
    }

    /**
     * return command for the second word
     */
    public String getSecondWord() {
        return secondWord;
    }

    /**
     * is the command understood?
     */
    public boolean isUnknown() {
        return (commandWord == null);
    }

    /**
     * does it have a second word?
     */
    public boolean hasSecondWord() {
        return (secondWord != null);
    }
}

