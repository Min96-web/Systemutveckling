package com.example.marstravels;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class ShoppingCart {
    String cartPath;
    public ShoppingCart()
    {
        cartPath = "src/main/java/com/example/marstravels/TempKundvagn.txt";
    }

    /**
     * Loads the cart file.
     * @return List<String></String> with all the cart items.
     */
    public ArrayList<String> loadCart()
    {
        FileHandler reader = new FileHandler();
        return reader.read(cartPath);

    }

    public List<String> createBooking()
    {
        FileHandler reader = new FileHandler();

        return reader.read(cartPath);
    }

    public void clearCart()
    {
        try {
            PrintWriter writer = new PrintWriter(cartPath);
            writer.write("");
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveBooking( List<String> booking, String bookingId )
    {
        FileHandler writer = new FileHandler();


        writer.write(bookingId + "\n" + "{", cartPath);

        for ( String item : booking )
        {
            writer.write( item , cartPath );
        }

        writer.write("}", cartPath);
    }

    /**
     * Searches through the cart, and removes the specified item if it is found.
     */
    public void removeItem( String productName )
    {
        FileHandler reader = new FileHandler();
        List<String> cart = loadCart();
        cart.remove(productName);

        updateFile(cart, reader);
    }

    /**
     *Adds an item to the cart file.
     * @param  product A cart item as a string on the form "name;date".
     */
    public void addItem( String product )
    {
        FileHandler cartHandler = new FileHandler();

        List<String> cart = loadCart();

        cart = removeDuplicate( product, cart );

        cart.add( product );

        updateFile( cart, cartHandler );

    }

    /**
     * Updates the cart file with made changes.
     */
    public void updateFile(List<String> cart, FileHandler writer)
    {
        clearCart();
        for ( String item : cart )
        {
            writer.write(item, cartPath);
        }
    }

    /**
     * Finds products of the same type, and removes it from cart.
     * @param product the product which is to be added to cart
     */
    public List<String> removeDuplicate( String product, List<String> cart )
    {

        cart.removeIf(item -> item.split(";")[0].equals(product.split(";")[0]));

        return cart;
    }

    public int getPrice (String product) {
        int price = 0;
        FileHandler reader = new FileHandler();
        ArrayList<String> prices = reader.readPrices();
        for (int i = 0; i<prices.size(); i++) {
            if (prices.get(i).contains(product)) {
                price = parseInt(prices.get(i).substring(prices.indexOf(";")));
            }
        }
        return price;
    }
}