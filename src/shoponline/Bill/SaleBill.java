/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoponline.Bill;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javafx.scene.control.TextArea;
import shoponline.ItemsSold.ItemsSold;

/**
 *
 * @author colea
 */
public class SaleBill {
    
    private int billNumber;
    private Date saleDate;
    private int itemSold;
    private double billAmount;
    private ArrayList<ItemsSold> billItems;
    private Random random = new Random();
    
    
    /**
     * Default Constructor
     */
    public SaleBill(){
        
    }
    /**
     * Overload Constructor
     * @param billNumber generated
     * @param saleData generated
     * @param itemSold retrieved from ItemsSOld class
     * @param billAmount calculated based on quantity and price
     * @throws ParseException 
     */
    public SaleBill(int billNumber, Date saleData, int itemSold, double billAmount) throws ParseException {
        if(billNumber > 0){
            this.billNumber = billNumber;
        }
        else throw new IllegalArgumentException("The Number cannot be negative");
                
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date data = sdf.parse("1971-11-03");
        if(saleData != null && saleData.after(data)){
            this.saleDate = saleData;
        }
        else throw new IllegalArgumentException("Invalid date");
    
                
        if(itemSold >= 0){
           this.itemSold = itemSold; 
        }
        else throw new IllegalArgumentException("The Items Sold cannot be negative");
        
        if(billAmount > 0){
           this.billAmount = billAmount; 
        }
        else throw new IllegalArgumentException("The Bill Amount cannot be negative");
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber() throws IllegalArgumentException{        
            this.billNumber = random.nextInt(10000);               
    }

    public Date getSaleData() {
        return saleDate;
    }

    public void setSaleData(Date saleData) throws ParseException, IllegalArgumentException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date data = sdf.parse("1971-11-03");
        if(saleData != null && saleData.after(data)){
            this.saleDate = saleData;
        }
        else throw new IllegalArgumentException("Invalid date");
    }

    public int getItemSold() {
        return itemSold;
    }

    public void setItemSold(int itemSold) {
        if(itemSold >= 0){
           this.itemSold = itemSold; 
        }
        else throw new IllegalArgumentException("The Items Sold cannot be negative");
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        if(billAmount > 0){
           this.billAmount = billAmount; 
        }
        else throw new IllegalArgumentException("The Bill Amount cannot be negative");
        
    }

    public ArrayList<ItemsSold> getBillItems() {
        return billItems;
    }

    public void setBillItems(ArrayList<ItemsSold> billItems) {
        if(billItems != null){
            this.billItems = billItems;
        }
        else throw new IllegalArgumentException("There is no data");
    }
    
    
    
        /**
         * method to print the bill
         * @param text a text area that will display specific text
         */
        public void printBill(TextArea text){
        //creating the formating for the date
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,YYYY"); 
            
            double totalPurchase = 0;
            //adding the text to the TextArea
            text.appendText("Bill# "+ getBillNumber()+ "\n");
            text.appendText("Date: "+ sdf.format(getSaleData())+ "\n");
            //for loop to get the quantity and prices for all the items in the ItemsSold 
             for (ItemsSold all : getBillItems()){
                double total = all.getQuantity() * all.getPrice();
                totalPurchase += total;
                text.appendText(String.format("%d\t\t%s\t\t%s\t\t\t%.2f\n",all.getQuantity(), all.getCode(),
                    all.getName(), total ));
            }
            //adding to th eTextArea the total purchase, taxes and total bill amount
            text.appendText(String.format("Subtotal:\t\t\t\t %.2f\n", totalPurchase));
            text.appendText(String.format("Taxes @ 13%%\t\t\t%.2f\n",(totalPurchase*0.13)));
            text.appendText(String.format("Total:\t\t\t\t%.2f\n",(totalPurchase*1.13)));
                                
        }
        /**
         * method to to generate the text for Bill Data file
         * @return formated string
         */
        public String writeBill(){
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,YYYY");
            double totalPurchase = 0;
            double billAmount = 0;
            int quantity = 0;
            for (ItemsSold all : getBillItems()){
                double total = all.getQuantity() * all.getPrice();
                totalPurchase += total; 
                quantity +=all.getQuantity();
                billAmount = (totalPurchase*1.13);
            }
            
            return String.format("Bill# %d, Date: %s, Items Sold: %d, Bill Amount: %.2f", 
                    getBillNumber(),sdf.format(getSaleData()), quantity,billAmount);
            
        }

    //To string method
    @Override
    public String toString(){
     return getBillNumber()+","+getSaleData()+","+getItemSold()+","+getBillAmount();
}
    
    
}
