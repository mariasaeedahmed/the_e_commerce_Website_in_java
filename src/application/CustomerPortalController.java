package application;


//import java.awt.event.ActionEvent;
//import java.io.IOException;
//
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;


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

public class CustomerPortalController {

    @FXML
    private Button SignUp;

    @FXML
    private Button LogC;

    @FXML
    private Button GoBack;

    @FXML
    void Back(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
    	Stage window = (Stage) GoBack.getScene().getWindow();
    	window.setScene(new Scene(root, 789, 549));
    }

    @FXML
    void LoginAction(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
    	Stage window = (Stage) LogC.getScene().getWindow();
    	window.setScene(new Scene(root, 789, 549));
    }

    @FXML
    void SignAction(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Signup.fxml"));
    	Stage window = (Stage) SignUp.getScene().getWindow();
    	window.setScene(new Scene(root, 789, 549));

    }

}
