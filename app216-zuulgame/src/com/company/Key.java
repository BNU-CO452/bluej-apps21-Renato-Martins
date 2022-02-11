package com.company;
/**
 * Key's Class
 */
public class Key {
    boolean owned;
    String identifier;
    
    public Key(String identifier) {
        owned = false;
        this.identifier = identifier;
    }
    
    /**
     * Key currently in possession
     */
    public boolean isOwned() {
        return owned;
    }
    
    /**
     * key grabbed.
     */
    public void claim() {
        owned = true;
    }
    
    public String toString() {
        return identifier;
    }
}