package application;

//import java.awt.Button;
//
//import java.awt.event.ActionEvent;
//import java.io.IOException;
//
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//


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

import javafx.scene.control.TableColumn;

public class AdminC {
	
    @FXML
    private Button BackA;

    @FXML
    private Button viewStock;

    @FXML
    private Button orderStock;

    @FXML
    private Button Assigndelivery;

    @FXML
    private Button logout;

    @FXML
    private Button GenerateReport;

    @FXML
    void AssignDeliveryAction(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("AssignDelivery.fxml"));
    	Stage window = (Stage) Assigndelivery.getScene().getWindow();
    	window.setScene(new Scene(root, 789, 549));
    }

    @FXML
    void BackAction(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Adminportal.fxml"));
    	Stage window = (Stage) BackA.getScene().getWindow();
    	window.setScene(new Scene(root, 789, 549));
    }

    @FXML
    void GenerateAction(ActionEvent event) throws IOException {
    
        	Parent root = FXMLLoader.load(getClass().getResource("GenerateReport.fxml"));
        	Stage window = (Stage) GenerateReport.getScene().getWindow();
        	window.setScene(new Scene(root, 789, 549));
    }

    @FXML
    void logoutAction(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Adminportal.fxml"));
    	Stage window = (Stage) logout.getScene().getWindow();
    	window.setScene(new Scene(root, 789, 549));
    }

    @FXML
    void orderStockAction(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("orderStock.fxml"));
    	Stage window = (Stage) orderStock.getScene().getWindow();
    	window.setScene(new Scene(root, 789, 549));
    }

    @FXML
    void viewStockAction(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("ViewStock.fxml"));
    	Stage window = (Stage) viewStock.getScene().getWindow();
    	window.setScene(new Scene(root, 789, 549));
    }

}
