/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoponline.Product;



/**
 *
 * @author colea
 */
public class Product {
    
    private String code;
    private String name;
    private double price;
    private int quantity;

    
    /**
     * Default Constructor
     */
    public Product(){
        
    }
    
    /**
     * Overload Constructor
     * @param code of the product
     * @param quantity of the product in the data base
     */
    public Product(String code, int quantity) throws IllegalArgumentException{
        if( code != null && quantity >=1 && code.matches(".*[^0-9].*")){
            this.code = code;
            this.quantity = quantity;
        }
        else throw new IllegalArgumentException("The field cannot be empty");
    }
    
    
    /**
     * Overload constructor
     * @param code of the product
     * @param name of the product
     * @param price of the product
     */
    public Product(String code, String name, double price) throws IllegalArgumentException{
        if( code != null  && code.matches("[0-9]+")){
           this.code = code; 
        }
        
        if(name != null && name.length() != 0){
            this.name = name;
        }
        else throw new IllegalArgumentException("The field cannot be empty");
                
        if(price >= 0){
            this.price = price;
        }
        else throw new IllegalArgumentException("The price cannot be negative");
    }
    
    /**
     * overload constructor
     * @param name of the product
     * @param code of the product
     * @param price of the product
     * @param quantity in the database
     * @throws IllegalArgumentException 
     */
    public Product(String name, String code, double price, int quantity) throws IllegalArgumentException {
         
        if(name != null && name.length() != 0){
            this.name = name;
        }
        else throw new IllegalArgumentException("The field cannot be empty");
        
        if( code != null  && code.matches("[0-9]+")){
           this.code = code; 
        }
        else throw new IllegalArgumentException("The field cannot be empty");               
                
        if(price >= 0){
            this.price = price;
        }
        else throw new IllegalArgumentException("The price cannot be negative");
                
        if(quantity >= 1){
        this.quantity = quantity;
        }
    }

    //Getters and setters
    
    public String getCode() {
       
        return code;
    }

    public void setCode(String code) throws IllegalArgumentException {
        String regex = "[0-9]+";
        if( code != null  && code.matches(regex)){
           this.code = code; 
        }
        else throw new IllegalArgumentException("The field cannot be empty");
        

        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws IllegalArgumentException{
        if(name != null && name.length() != 0){
            this.name = name;
        }
        else throw new IllegalArgumentException("The field cannot be empty");
        
    }

    public double getPrice() {
        
        return price;
    }

    public void setPrice(double price) throws IllegalArgumentException{
        if(price >= 0){
            this.price = price;
        }
        else throw new IllegalArgumentException("The price cannot be negative");
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity >= 1){
        this.quantity = quantity;
        }
        
    }
    
    //toString method
    @Override
    public String toString(){
       return  this.name+","+this.code+","+this.price+","+this.quantity; 
    }
    
    
        
}
