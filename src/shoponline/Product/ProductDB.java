/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoponline.Product;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import shoponline.ProductUtils;

/**
 *
 * @author colea
 */
public class ProductDB {
    //
    PrintWriter writers = null;
    
    /**
     * Default Constructor
     * @throws IOException  if the file cannot be created
     */
        public ProductDB() throws IOException{
        File file = new File("inventory.txt");
        file.createNewFile();
        
    }
        

    /**
     * Method to search the code in the file and return the related data
     * @param code entered by user
     */
    public static boolean searchCode(String code) {
 
        ArrayList<Product> info = new ProductUtils("inventory.txt").readFromFile();
        
        for(Product product : info){
            if(code.equalsIgnoreCase(product.getCode())){
                return true; 
            }
            else {
                System.out.println("No such Code");
            }                        
        }
        return false;
        
        
    }
    
    

    
}
