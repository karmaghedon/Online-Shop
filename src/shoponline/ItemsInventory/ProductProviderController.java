/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoponline.ItemsInventory;

import static com.sun.javafx.geom.Curve.next;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import shoponline.Exceptions.Alerts;
import shoponline.Product.Product;
import shoponline.ProductUtils;

/**
 * FXML Controller class
 *
 * @author colea
 */
public class ProductProviderController implements Initializable {

    @FXML
    private TextField productName;
    @FXML
    private TextField productCode;
    @FXML
    private TextField productPrice;
    @FXML
    private TextField productQuantity;
    @FXML 
    private TextArea viewProducts;
    
    
    @FXML
    public void submitClicked(ActionEvent event){
                
       try{
           Product item = new Product(productName.getText(),productCode.getText(),
                             Double.parseDouble(productPrice.getText()),Integer.parseInt(productQuantity.getText()));


          ProductUtils submit = new ProductUtils("inventory.txt");
          submit.writeToFile(item.toString());  
        }catch (NumberFormatException nfe){
            Alerts.redAllert(nfe.getMessage());
       
        } catch(IllegalArgumentException | NullPointerException e){
            Alerts.redAllert(e.getMessage());
        }  
       
       productName.setText("");
       productCode.setText("");
       productPrice.setText("");
       productQuantity.setText("");
    }

      
    
    
    @FXML
    public void viewProductClicked(ActionEvent event){
        viewProducts.setText("");
        ProductUtils submit = new ProductUtils("inventory.txt");
        
        ArrayList<Product> products = submit.readFromFile();
        
        for(Product product : products){
             
            String output = String.format("%s, %s, %.2f, %d\n",product.getName(),product.getCode(),
                    product.getPrice(), product.getQuantity()); 
            
            viewProducts.appendText(output);
        }
    }
    
    
    @FXML
    public void doneClicked(ActionEvent event){

        Stage stage =  (Stage) productCode.getScene().getWindow();
        try{
                   Parent next = FXMLLoader.load(getClass().getResource("/shoponline/ShopeOnline.fxml"));
        Scene scene = new Scene(next);
            stage.setScene(scene);
            stage.show();
       
        }
        catch (IOException ex) {
            Alerts.redAllert(ex.getMessage());

        }
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
