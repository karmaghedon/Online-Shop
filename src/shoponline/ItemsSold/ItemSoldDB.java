/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoponline.ItemsSold;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import shoponline.Product.Product;
import shoponline.Product.ProductDB;
import shoponline.ProductUtils;

/**
 *
 * @author colea
 */
public class ItemSoldDB {
    public static String textFileName = "Product.txt";
    
    public ItemSoldDB() throws IOException{
      
    }
    
    
    public void addToFile(ItemsSold items){
        
        ProductUtils data = new ProductUtils("Product.txt");
        
        data.writeToFile(items.toString());
        
    }
    
   
    
    
}
