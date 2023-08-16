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

import javafx.scene.control.TableColumn;

public class FCon {
	@FXML
	private Button customerP;
	@FXML
	private Button Adminp;

	// Event Listener on Button[#customerP].onAction
	@FXML
	public void GotoCus(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Customerportal.fxml"));
    	Stage window = (Stage) customerP.getScene().getWindow();
    	window.setScene(new Scene(root, 789, 549));
	}
	// Event Listener on Button[#Adminp].onAction
	@FXML
	public void AdminPortal(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Adminportal.fxml"));
    	Stage window = (Stage) Adminp.getScene().getWindow();
    	window.setScene(new Scene(root, 789, 549));
	}
}


/*

package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class FCon {

    @FXML
    private Button customerP;

    @FXML
    private Button Adminp;

    @FXML
    void AdminPortal(ActionEvent event) {

    }

    @FXML
    void GotoCus(ActionEvent event) {

    }

}

*/
