package com.company;
import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockList
{
    // A list of the products.
    private ArrayList<Product> stock;
        
    /**
     * Initialise the stock manager.
     */
    public StockList()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The product item to be added.
     */
    public void add(Product item)
    {
        stock.add(item);
    }
    
    /**
     * remove a product from the list.
     */
    public void remove(int productID)
    {
        Product product = findProduct(productID);
        if(product !=null)
            {
                System.out.println(product+ "has been removed");   
                stock.remove(product); 
            }      
        else
            {
                System.out.println("no item with that ID exist");
            }
    }
    
    /**
     * A method to buy a single quantity of the product
     */
    public void buyProduct(int productID)
    {
        buyProduct(productID, 1);
    }
    
    /**
     * Buy a quantity of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void buyProduct(int productID, int amount)
    {
        Product product = findProduct(productID);
        if(product != null) 
        {
            if(product.getQuantity() < 100)
            {
                product.increaseQuantity(amount);
                System.out.println(" Bought " + amount + " of " + product.getName());

            }
            else
            {
                System.out.println("Not enough space for " + product.getName() + 
                    " please sell more stock ");
            }
        }
        else
        {
            System.out.println("No product found");
        }
    }
    
    /**
     * Find a product to match the product id,
     * if not found return null
     */
    public Product findProduct(int productID)
    {
        for(Product product : stock)
        
        {
            if(product.getID() == productID)
                return product;
        }
        return null;
    }
    
    /**
     * Sell one of the given product.
     */
    public void sellProduct(int productID)
    {
        sellProduct(productID, 105);
    }
    
    /**
     * Sell one of the given product.
     * Show the before and after status of the product.
     * @param id The ID of the product being sold.
     */
    public void sellProduct(int productID, int amount)
    {
        Product product = findProduct(productID);

        if(product != null) 
        {
            if(product.getQuantity() > 0 && product.getQuantity() > amount)
            {
                product.decreaseQuantity(amount);
                System.out.println(" Sold " + amount + " of " + product.getName());

            }
            else if (product.getQuantity() == 0)
            {
                System.out.println("The product" + product.getName() + 
                    "is out of stock");
            }
            else
            {
                System.out.println("Not able to sell " + amount + " of " + product.getName() + 
                    "because stock level is " + product.getQuantity()); 
            }
        }
        else
        {
            System.out.println("Product not found");
        }
    }

    public Product findName(String productName)
    {
        for(Product product : stock)
        {
            if(product.getName() == productName)
                System.out.println(product);
        }
        return null;
    }

    public void removeProduct (int productID)
    {
        Product product = findProduct(productID);
        product = product;
        stock.remove(product);

    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int productID)
    {
        Product product = findProduct(productID);
        if(product !=null)
             System.out.println(product.toString());
        return 0;
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int productID)
    {
        Product product = findProduct(productID);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void print()
    {
        printHeading();
        
        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }
    
    public void printHeading()
    {
        System.out.println();
        System.out.println(" Ren's Stock List");
        System.out.println(" ====================");
        System.out.println();
    }
    
    /**
    * Search for a product
    */
    public void searchProducts(String phrase)
    {
        for(Product product : stock)
        {
            if(product.getName().startsWith(phrase) == true)
            {
                System.out.println(product);
            }
        }
    }
    
    /**
    * Show Stock under 1
    */
    public void stockLower(int lowamount)
    {
        for(Product product : stock)
        {
            if(product.getQuantity() < lowamount )
            {
                System.out.println(" Stock Below 1 ");
                System.out.println(" ------------- ");
                System.out.println(product);
            }
        }
    }
}