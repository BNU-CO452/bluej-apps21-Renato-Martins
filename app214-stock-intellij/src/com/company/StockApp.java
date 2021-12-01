package com.company;

/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Renato
 * @version 1
 */
public class StockApp
{
    private InputReader reader;

    private StockList stock;

    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();

        stock = new StockList();
        StockDemo demo = new StockDemo(stock);
    }

    /**
     *  Display a list of menu choices and execute
     *  the user's choice.
     */
    public void run()
    {
        boolean finished = false;

        while(!finished)
        {
            printHeading();
            printMenuChoices();

            String choice = reader.getString("Please enter your choice > ");

            finished = executeChoice(choice.toLowerCase());
        }
    }

    private boolean executeChoice(String choice)
    {
        if(choice.equals("quit"))
        {
            return true;
        }
        else if(choice.equals("add"))
        {
            addProduct();
        }
        else if(choice.equals("remove"))
        {
            removeProduct();
        }
        else if(choice.equals("buy"))
        {
            buyProduct();
        }
        else if(choice.equals("sell"))
        {
            sellProduct();
        }
        else if(choice.equals("search"))
        {
            String productname = reader.getString("What are you looking for?");
            stock.searchProducts(productname);
        }
        else if(choice.equals("low"))
        {
            int productlow = reader.getInt("Levels below...?");
            stock.stockLower(productlow);
        }
        else if(choice.equals("print"))
        {
            stock.print();
        }

        return false;
    }



    private void sellProduct()
    {
        int rid = reader.getInt("ID of the product you wish to sell");
        int amount = reader.getInt("how much would you like to sell?");
        if(stock.findProduct(rid) != null)
        {
            stock.sellProduct(rid, amount);
        }
        else if(stock.findProduct(rid) == null)
        {
            System.out.println("There isn't a product with that ID");
        }
    }

    private void buyProduct()
    {
        int rid = reader.getInt("ID of the product you wish to buy");
        int amount = reader.getInt("how much would you like to buy?");
        if(stock.findProduct(rid) != null)
        {
            stock.buyProduct(rid, amount);
        }
        else if(stock.findProduct(rid) == null)
        {
            System.out.println("There isn't a product with that ID");
        }
    }

    private void removeProduct()
    {
        int rid = reader.getInt("please enter the ID of the product you wish removed");
        if(stock.findProduct(rid) != null)
        {
            stock.removeProduct(rid);
            System.out.println("product has been removed");
        }
        else if (stock.findProduct(rid) == null)
        {
            System.out.println("There isn't a product with that ID");
        }
        else
        {
            System.out.println("Error, please try again");

        }
    }

    private void addProduct()
    {
        int id = reader.getInt("Please enter the ID for the product");
        String name = reader.getString("Please enter the name for the product");
        Product product = new Product(id, name);
        stock.add(product);
        System.out.println("Product " + product.getID()
                + ", " + product.getName() + " has been added!");
    }

    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    Add:        Add a new product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Print:      Print all products");
        System.out.println("    Buy:        Buy product");
        System.out.println("    Sell:       Sell product");
        System.out.println("    Search:     Search for a Product");
        System.out.println("    Low:        Check for low amounts");
        System.out.println("    Quit:       Quit the program");
        System.out.println();
    }

    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("********************************");
        System.out.println("  App21-04: Stock Application ");
        System.out.println("      by Renato");
        System.out.println("********************************");
    }
}