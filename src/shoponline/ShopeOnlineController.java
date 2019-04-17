/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoponline;

import shoponline.Product.ProductDB;
import shoponline.Product.Product;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import shoponline.Bill.SaleBill;
import shoponline.Exceptions.Alerts;
import shoponline.ItemsSold.ItemsSold;


/**
 *
 * @author colea
 */
public class ShopeOnlineController implements Initializable {   
    
    @FXML
    private TextField codeText;
    @FXML
    private TextField quantityText;
    @FXML
    private TextArea saleBillText;
    @FXML
    private TextArea itemList;
    @FXML
    private TextArea myOrdersList;
    @FXML
    private Label totalId; 
    private double total = 0;
    private ArrayList<ItemsSold> soldItems = new ArrayList<>();
    
    @FXML
    public void submitClicked(ActionEvent event) throws IOException {
        ProductUtils submit = new ProductUtils("inventory.txt");
        
        ArrayList<Product> products = submit.readFromFile();
        Product soldProduct = null;
       try{
           for(Product product : products){
               if(product.getCode().equalsIgnoreCase(codeText.getText())){
                  soldProduct = product;
                  break;
               }               
           }
           if(soldProduct != null){
               ItemsSold item = new ItemsSold(soldProduct.getCode(),soldProduct.getName(),
                            soldProduct.getPrice(),Integer.parseInt(quantityText.getText()));
               
                soldItems.add(item);
               
               total+=item.getPrice()* Integer.parseInt(quantityText.getText());
               String add = String.format("%.2f", total);
               totalId.setText(String.valueOf(add));
               
               myOrdersList.appendText(item.displayItems());
               ProductUtils enter = new ProductUtils("Product.txt");
               enter.writeToFile(item.toString());
           }
           else {
               Alerts.redAllert("There is no such product");
           } 
        }catch (NumberFormatException nfe){
            Alerts.redAllert(nfe.getMessage());
       
        } catch(IllegalArgumentException | NullPointerException e){
            Alerts.redAllert(e.getMessage());
        } 
        
        
        
    }
    
    
    @FXML
    public void viewBillClicked(ActionEvent event) throws ParseException {
           saleBillText.setText("");
         ProductUtils submit = new ProductUtils("BillData.txt");
         
         
         SaleBill bill = new SaleBill();
         
         bill.setBillItems(soldItems);
         bill.setBillNumber();
         bill.setSaleData(new Date());
         bill.printBill(saleBillText);
         
         submit.writeToFile(bill.writeBill());//write to file
    }
    
    @FXML
    public void onReset(ActionEvent event) {
        codeText.setText("");
        quantityText.setText("");
        saleBillText.setText("");

    }

    @FXML
    public void onExit(ActionEvent event){
        System.exit(0);
    }     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ProductUtils submit = new ProductUtils("inventory.txt");
        ArrayList<Product> products = submit.readFromFile();
        
        for(Product product : products){
             
            String output = String.format("%s, %s, %.2f, %d\n",product.getName(),product.getCode(),
                    product.getPrice(), product.getQuantity()); 
            itemList.appendText(output);
            
            
        }                
    }        
}
