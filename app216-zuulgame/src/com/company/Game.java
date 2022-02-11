package com.company;
import java.util.ArrayList;
/**
 *  This class is the main class of my zuul game "MineZuul".
 * @author  Renato Martins
 * @version 3.1.2022
 */
public class Game {
    private Parser parser;
    private ArrayList<Key> keys;
    private Room currentRoom;
    private Room beamerRoom;

    /**
     * Starts the game
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        createRooms();
        keys = new ArrayList<Key>();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {
        Room portal, forest, swamp, darkforest, glacier, highlands, naga, lich, minoshroom, hydra, knight, urghast, yeti, snowqueen, castle ;

        // Here are created the "keys" that you can get //
        Key nagakey = new Key("Naga's Head");
        Key lichkey = new Key("Lich's Staff");
        Key minoshroomkey = new Key("Minoshroom's Axe");
        Key hydrakey = new Key("Hydra's Heads");
        Key knightkey = new Key("Knight's Armour");
        Key urghastkey = new Key("Ur-Ghast's tear");
        Key yetikey = new Key("Yeti's Fur");
        Key snowqueenkey = new Key("Snow Queen's Crown");
        Key castlekey = new Key("You are now the King!");



        // Create Rooms where you can navigate //
        portal = new Room("currently in the Portal Room");

        forest = new Room("currently in a Forest");
        naga = new Room("in the Naga's Courtyard", nagakey);
        lich = new Room("in the Lich's Tower", lichkey);

        swamp = new Room("currently in the Swamp");
        minoshroom = new Room("in the Minoshroom Labyrinth", minoshroomkey);
        hydra = new Room("in the Hydra's Lair", hydrakey);

        darkforest = new Room("currently in the Dark Forest");
        knight = new Room("in the Knight's Stronghold", knightkey);
        urghast = new Room("in the Ur-Ghast's Dark Tower", urghastkey);

        glacier = new Room("currently in a Glacier");
        yeti = new Room("in the Yeti's Lair", yetikey);
        snowqueen = new Room("in the Snow's Queen Palace", snowqueenkey);

        highlands = new Room("currently in the Highlands");
        castle = new Room("in the Final Castle", castlekey);



        // Portal Room Paths //
        portal.setExit("north", forest);

        // Forest Paths Forwards //
        forest.setExit("west", naga);
        forest.setExit("north", swamp, nagakey);
        forest.setExit("east", lich);
        // Forest Paths Return //
        naga.setExit("east", forest);
        swamp.setExit("south", forest);
        lich.setExit("west", forest);

        // Swamp Paths Forwards //
        swamp.setExit("west", minoshroom);
        swamp.setExit("north", darkforest, hydrakey);
        swamp.setExit("east", hydra);
        // Swamp Paths Return //
        minoshroom.setExit("east", swamp);
        darkforest.setExit("south", swamp);
        hydra.setExit("west", swamp);

        // DarkForest Paths Forward //
        darkforest.setExit("west", knight);
        darkforest.setExit("north", glacier, knightkey);
        darkforest.setExit("east", urghast);
        // DarkForest Paths Return //
        knight.setExit("east", darkforest);
        glacier.setExit("south", darkforest);
        urghast.setExit("west", darkforest);

        // Glacier Paths Forward //
        glacier.setExit("west", yeti);
        glacier.setExit("north", highlands, snowqueenkey);
        glacier.setExit("east", snowqueen);
        // Glacier Paths Return //
        yeti.setExit("east", glacier);
        castle.setExit("south", glacier);
        snowqueen.setExit("west", glacier);

        // HighLands Paths Return //
        castle.setExit("south", highlands);
        highlands.setExit("south", glacier);
        // HighLands Paths Forward //
        highlands.setExit("north", castle);


        currentRoom = portal;  // start game outside
    }

    /**
     *  Loop until end of game
     */
    public void play() {            
        printWelcome();
                
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome() {
        System.out.println();
        System.out.println("I welcome you to MineZuul");
        System.out.println("This world is a mix between Zuul and another game.");
        System.out.println("⚠️If you don't know what to do maybe 'help' can help   ⚠️");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) {
        boolean quitGame = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("Sorry what? I didn't understand that...");
                return false;

            case BACK:
                gotoWaypoint();
                break;

            case GO:
                goRoom(command);
                break;

            case HELP:
                printHelp();
                break;

            case MARK:
                setWaypoint(currentRoom);
                break;

            case QUIT:
                quitGame = quit(command);
                break;

        }
        return quitGame;
    }


    /**
     * Print "help" info
     */
    private void printHelp() {
        System.out.println("You need to navigate the world");
        System.out.println("in order to become king!");
        System.out.println();
        System.out.println("Commands that are accepted:");
        parser.showCommands();
    }

    private void goRoom(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) { // there's nothing in that direction
            System.out.println("There's nothing there!");
            return;
        }
        if (currentRoom.getState(direction) == "locked") { // check if needed key is owned.
            for (Key key : keys) {
                if (key.toString().equals(currentRoom.getExitKey(direction))) {
                    currentRoom.setState(direction, "ok");
                    System.out.println("You unlocked the door!");
                    break;
                }
            }
        }
        
        switch (currentRoom.getState(direction)) {
            case "locked":
                String keyLabel = currentRoom.getExitKey(direction);
                System.out.println("That door is locked! You can unlock it with a key labeled "+keyLabel+", though.");
                break;

            case "ok":
                currentRoom = nextRoom;
                getRoomInfo();
                break;

            default:
                System.out.println("Error");
                break;

        }
    }
    
    /**
     * Room Info
     */
    private void getRoomInfo() {
        System.out.println(currentRoom.getLongDescription());
        if (currentRoom.hasKey()) {
            for (Key key : keys) {
                if (key.toString().equals(currentRoom.getKeyInfo())) {
                    return;
                }
            }
            System.out.println("You found an item!");
            Key gotKey = currentRoom.getKey();
            System.out.println("This item is labeled: " + gotKey);
            gotKey.claim();
            keys.add(gotKey);
        }
    }
    
    /**
     * Waypoint
     */
    private void setWaypoint(Room room) {
        beamerRoom = currentRoom;
        System.out.println("You placed a waypoint in this room.");
        System.out.println("Now you can return here by using 'back'.");
    }
    private boolean gotoWaypoint() {
        if (beamerRoom == null) {
            System.out.println("You never placed a waypoint...");
            return false;
        }
        currentRoom = beamerRoom;
        System.out.println("You went back!");
        getRoomInfo();
        return true;
    }

    /** 
     * Use Quit to exit the game
     */
    private boolean quit(Command command) {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        return true;
    }
}
