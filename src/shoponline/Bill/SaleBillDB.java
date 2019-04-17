/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoponline.Bill;

import shoponline.ProductUtils;

/**
 *
 * @author colea
 */
public class SaleBillDB {
    
    public String textFileName = "OrderItems.txt";
       
     public SaleBillDB() {
    }
     
     
        public void addToFile(SaleBill items){
        ProductUtils data = new ProductUtils("OrderItems.txt");
        
        data.writeToFile(items.toString());
        
    }
        
        
        
    


   
    
}
