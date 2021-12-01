package com.company;
import java.util.Random;
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;

    private Random random; 
    
    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stock)
    {
        this.stock = stock;
        this.random = new Random();
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers
        
        stock.add(new Product(101, "Assassin's Creed"));
        stock.add(new Product(102, "Assassin's Creed II"));
        stock.add(new Product(103, "Battlefield 4"));
        stock.add(new Product(104, "Fortnite"));
        stock.add(new Product(105, "Among Us"));
        stock.add(new Product(106, "Assassin's Creed IV: Black Flag"));
        stock.add(new Product(107, "Black Desert"));
        stock.add(new Product(108, "COD Vanguard"));
        stock.add(new Product(109, "Halo Infinite"));
        stock.add(new Product(110, "Elden Ring"));

    }
    
    
    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.

        stock.print();

        buyProducts();
        stock.print();

        sellProducts();
        stock.print();
    }
    // This method buys random amounts of each of the products
    private void buyProducts()
    {
        stock.buyProduct(101, 5);
        stock.buyProduct(102, 8);
        stock.buyProduct(103, 8);
        stock.buyProduct(104, 7);
        stock.buyProduct(105, 9);
        stock.buyProduct(106, 3);
        stock.buyProduct(107, 9);
        stock.buyProduct(108, 5);
        stock.buyProduct(109, 6);
        stock.buyProduct(110, 6);
    }
    // This method sells random amounts of each of the products
    private void sellProducts()
    {
        stock.sellProduct(101, 4);
        stock.sellProduct(102, 6);
        stock.sellProduct(103, 7);
        stock.sellProduct(104, 5);
        stock.sellProduct(105, 7);
        stock.sellProduct(106, 2);
        stock.sellProduct(107, 8);
        stock.sellProduct(108, 4);
        stock.sellProduct(109, 4);
        stock.sellProduct(110, 3);
    }    
}