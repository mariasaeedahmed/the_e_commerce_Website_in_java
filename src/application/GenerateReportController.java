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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TableColumn;
public class GenerateReportController {
	 @FXML
	    private TextArea textAreaReport;

	    @FXML
	    private TableView<?> tableViewInventory;

	    @FXML
	    private TableColumn<?, ?> productCode;

	    @FXML
	    private TableColumn<?, ?> productName;

	    @FXML
	    private TableColumn<?, ?> productType;

	    @FXML
	    private TableColumn<?, ?> quantity;

	    @FXML
	    private TableColumn<?, ?> price;

	    @FXML
	    private TableColumn<?, ?> color;

	    @FXML
	    private Button buttonGenerateReport;

	    @FXML
	    private Button Goback;

	    @FXML
	    void GobackAction(ActionEvent event) throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("AdminHomePage.fxml")); 
	    	Stage window = (Stage) Goback.getScene().getWindow();
	    	window.setScene(new Scene(root, 789, 549));
	    }

	    @FXML
	    void generateReportActionClicked(ActionEvent event) {
	    	
	    }
}
