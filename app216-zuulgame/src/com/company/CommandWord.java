package com.company;
/**
 * @author  Renato Martins
 * @version 3.1.2022
 */
public enum CommandWord
{
    // List of commands when help is used it will list them
    GO("go"), QUIT("quit"), HELP("help"), MARK("waypoint"), BACK("return"), UNKNOWN("?");

    private String commandString;

    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * return them as a string
     */
    public String toString()
    {
        return commandString;
    }
}
