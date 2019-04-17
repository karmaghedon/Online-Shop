/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoponline.ItemsSold;

/**
 *
 * @author colea
 */
public class ItemsSold {

    private String code;
    private String name;
    private double price;
    private int quantity;
    
    
    
    /**
     * Overload Constructed
     * @param code of the item
     * @param name of the item
     * @param price of the item
     * @param quantity that was selected
     */
    public ItemsSold(String code, String name, double price, int quantity) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    //Getters and setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    /**
     * method to display the items that customer selected
     * @return the name of the product and the quantity
     */
    public String displayItems(){
        return this.name +"\t\t\t"+ this.quantity+"\n";
    }
    
    
    // toString method
    @Override
    public String toString(){
        return this.code+","+this.name+","+this.price+","+this.quantity;
    }
    

}
