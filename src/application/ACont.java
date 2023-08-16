package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
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
public class ACont {
	@FXML
	private Button LogA;
	@FXML
	private Button GoBack;
	 @FXML
	    private TextField adminusername;

	    @FXML
	    private PasswordField adminpassword;
	// Event Listener on Button[#LogA].onAction
	@FXML
	public void LoginAction(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
    	Stage window = (Stage) LogA.getScene().getWindow();
    	window.setScene(new Scene(root, 789, 549));
	}
	// Event Listener on Button[#GoBack].onAction
	@FXML
	public void BackAction(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Homepage.fxml"));
    	Stage window = (Stage) GoBack.getScene().getWindow();
    	window.setScene(new Scene(root, 789, 549));
	}
}
