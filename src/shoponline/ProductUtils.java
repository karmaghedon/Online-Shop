/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoponline;

import shoponline.Product.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import shoponline.Exceptions.Alerts;

/**
 *
 * @author colea
 */
public class ProductUtils {
    private static String textFileName = null;

    /**
     * Default Constructor
     * @param textFileName variable to display file name
     */
    public ProductUtils(String textFileName){
        if(textFileName != null && textFileName.length() != 0){
            this.textFileName = textFileName; 
        }
        else{
            System.out.println("Please enter a valid name");
        }
                       
    }
    //getter and setter
    public String getTextFielName() {
        return textFileName;
    }

    public void setTextFielName(String textFileName) {
        if(textFileName != null && textFileName.length() != 0){
            this.textFileName = textFileName; 
        }
        else{
            System.out.println("Please enter a valid name");
        }
    }
    
    /**
     * method to write to file
     * @param data that needs to be written to file
     */
    public void writeToFile(String data ){
        
      
       BufferedWriter buffWrite = null;
       
        try{
            buffWrite = new BufferedWriter(new FileWriter(textFileName, true));//bufferedWriter is created                            
                 buffWrite.append(data);//write to file 
                 buffWrite.newLine(); //go to the next line    
        }
        catch (IOException ie){
                Alerts.redAllert(ie.getMessage());
            }  
        finally {//run under any circumstances
            try{  
             if(buffWrite != null) 
                buffWrite.close(); // close a file
           }catch(IOException iex){
               Alerts.redAllert(iex.getMessage());
           }
        }
    }
    
    /**
     * method to read from file
     * @return the list of items from file as an Array List
     */
    public static ArrayList<Product> readFromFile(){
        ArrayList<Product> items = new ArrayList<Product>();//a list of items is created
        BufferedReader buffRead = null;
        
        try{
           buffRead = new BufferedReader(new FileReader(textFileName)); //BufferedReader is created
           String info = null;//info buffer is declared
           while((info = buffRead.readLine()) != null){//check if info is not null
             String[] data = info.split(",");//data is retrieved from the file             
             String name = data[0];//retrive item name
             String code = data[1];//retrive item code
             String price = data[2];//retrive item price
             String quantity = data[3];//retrive item quantity
             Product product = new Product(name,code,Double.parseDouble(price),Integer.parseInt(quantity));// creating a new product
             items.add(product); //adding items to product             
            }
        }
        catch(IOException ie){
            Alerts.redAllert(ie.getMessage());
        }
        finally{
            try{
                if(buffRead != null){
                    buffRead.close();// close buffreader
                }                    
            }catch(IOException ie){
                Alerts.redAllert(ie.getMessage());
            }
        }
        return items;
    }
 
}
