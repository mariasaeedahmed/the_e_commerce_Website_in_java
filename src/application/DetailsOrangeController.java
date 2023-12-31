package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import BusinessLogic.Store;
import PersistenceHandler.dbHandler;
import application.model.Cnt;
import application.model.Search;
import application.model.SearchInWishlist;
import application.model.itemss;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class DetailsOrangeController implements Initializable{
	Connection con;
	@FXML
	private Button BackA;
	@FXML
	private Button AddWishliat;
	@FXML
	private Button AddCart;

	// Event Listener on Button[#BackA].onAction
	@FXML
	public void BackAction(@SuppressWarnings("exports") ActionEvent event) throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("Shopping.fxml")); 
	    	Stage window = (Stage) BackA.getScene().getWindow();
	    	window.setScene(new Scene(root, 789, 549));
	}
	// Event Listener on Button[#AddWishliat].onAction
	
	@FXML
	public void AddWishliatAction(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("wishlist.fxml")); //need to changee
    	Stage window = (Stage) AddWishliat.getScene().getWindow();
    	window.setScene(new Scene(root, 789, 549));
		// TODO Autogenerated
	}
	// Event Listener on Button[#AddCart].onAction
	@FXML
	public void AddCartAction(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AddtoCart.fxml")); //need to changee
    	Stage window = (Stage) AddCart.getScene().getWindow();
    	window.setScene(new Scene(root, 789, 549));

		// TODO Autogenerated
	}
	 @FXML
	    private TableView<itemss> tablee;

	    @FXML
	    private TableColumn<itemss, Integer> id;

	    @FXML
	    private TableColumn<itemss, Integer> itemId;

	    @FXML
	    private TableColumn<itemss, String> ProductName;

	    @FXML
	    private TableColumn<itemss, String> Material;

	    @FXML
	    private TableColumn<itemss, Integer> price;

	    @FXML
	    private TableColumn<itemss, String> desc;
	    private ObservableList<itemss> Item1;
	    public void function() throws SQLException
	    {
	    	Item1 = FXCollections.observableArrayList();
	    	   
	    	   
	    	   /*String table2 = "CREATE table Stockssss"+ "(SerialNo integer AUTO_INCREMENT Primary key,"+" Iname varchar(255) not NULL,"
	    				+ "Itemid integer,"+"quantity integer not null,"+"price integer not null,"+"supplier varchar(255))";
	    			Statement stmt2 = con.createStatement();	
	    		
	    		stmt2.executeUpdate(table2);*/
	    	   
	    	   
	    	   
	    	   String SQL = "Select * from items where id =1";
	    	   ResultSet rs = con.createStatement().executeQuery(SQL);  
	    	   while(rs.next()){
	    		   itemss cm = new itemss();
	             cm.id.set(rs.getInt("id"));                       
	            
	             
	             cm.itemId.set(rs.getInt("itemId"));
	             cm.productName.set(rs.getString("ProductName"));
	             cm.Material.set(rs.getString("Material"));
	             cm.price.set(rs.getInt("price"));
	             cm.Desc.set(rs.getString("descr"));
	             Item1.add(cm);                  
	         }
	    	   tablee.setItems(Item1);
	    	   
	    }
	    	   @Override
	    	    public void initialize(URL location, ResourceBundle resources) {

	    	        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
	    		   id.setCellValueFactory(new PropertyValueFactory<itemss,Integer>("id"));
	    		   itemId.setCellValueFactory(new PropertyValueFactory<itemss,Integer>("itemId"));
	    		   ProductName.setCellValueFactory(new PropertyValueFactory<itemss,String>("productName"));
	    		   Material.setCellValueFactory(new PropertyValueFactory<itemss,String>("Material"));
	    	        price.setCellValueFactory(new PropertyValueFactory<itemss,Integer>("price"));
	    	        desc.setCellValueFactory(new PropertyValueFactory<itemss,String>("Desc"));
	    	         dbHandler objdb = new dbHandler();
	    	       // tablee.setItems(ViewStockClasss);
	    	       try {
	    			 con = objdb.getConnection();
	    			function();
	    		} catch (ClassNotFoundException e) {
	    			
	    			e.printStackTrace();
	    		} catch (SQLException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
	    	    }
	    	   
	    	   
	    	  

}