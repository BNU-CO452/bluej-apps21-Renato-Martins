package com.company;
import java.util.Set;
import java.util.HashMap;
/**
 * @author  Renato Martins
 * @version 3.1.2022
 */


public class Room {
    private String description;
    private Key key;
    private HashMap<String, Room> exits; // stores exits of this room.
    private HashMap<String, String> exitInfo; // stores properties of the exits

    /**
     * Room description
     */
    public Room(String description) {
        initRoom(description, null);
    }
    
    /**
     * Room description for when it has a key
     */
    public Room(String description, Key key) {
        initRoom(description, key);
    }
    
    /**
     * Create room
     */
    private void initRoom(String description, Key key) {
        this.description = description;
        this.key = key;
        exits = new HashMap<String, Room>();
        exitInfo = new HashMap<String, String>();
    }

    /**
     * Create room paths (north, south, east, west)
     */
    public void setExit(String direction, Room neighbor) {
        setExit(direction, neighbor, "ok");
    }
    
    /**
     * Room locked by key
     */
    public void setExit(String direction, Room neighbor, Key key) {
        exitInfo.put(direction + "Key", key.toString());
        setExit(direction, neighbor, "locked");
    }

    public void setExit(String direction, Room neighbor, String state) {
        exits.put(direction, neighbor);
        exitInfo.put(direction + "State", state);
    }

    /**
     * Short room description
     */
    public String getShortDescription() {
        return description;
    }

    /**
     * Long room description
     */
    public String getLongDescription() {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * State of the path
     */
    public String getState(String direction) {
        return exitInfo.get(direction + "State");
    }

    public void setState(String direction, String state) {
        exitInfo.put(direction + "State", state);
    }
    
    /**
     * Get rooms paths and print them
     */
    private String getExitString() {
        String returnString = "Paths:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }
    
    /**
     * Path locked by key
     */
    public String getExitKey(String direction) {
        return exitInfo.get(direction + "Key");
    }
    
    /**
     * Check for need of key
     */
    public boolean hasKey() {
        if (this.key == null) {
            return false;
        }
        return true;
    }
    
    /**
     * Get room keys
     */
    public Key getKey() {
        return key;
    }
    
    /**
     * Get key info
     */
    public String getKeyInfo() {
        return key.toString();
    }
}

