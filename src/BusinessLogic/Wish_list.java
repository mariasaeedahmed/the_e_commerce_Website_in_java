package BusinessLogic;
import java.sql.SQLException;

import PersistenceHandler.dbHandler;
import application.model.SearchInWishlist;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Wish_list 
{
	dbHandler db= new dbHandler();
	Product[] products= new Product[100];
	int counter=0;

public void itemWishlist() {
	
}
public void removefromwishlist(String itemname) throws ClassNotFoundException, SQLException {
	db.getInstance().UpdateRemWishlist(itemname);
	
}
public void itemadding(Product item) {
	// TODO Auto-generated method stub
	products[counter]= item;
}
public ObservableList<SearchInWishlist> iteminwishlist(String itemname, String username) throws ClassNotFoundException, SQLException {
	/////////////////////////////////////////////////////////////////////////////////////////////
	
	
	ObservableList<SearchInWishlist> SW = FXCollections.observableArrayList();
	SW= db.getInstance().fetchItem(itemname, username);
	return SW;
	
	
}
public void removefromwishlist(int ind) {
	// TODO Auto-generated method stub
	for(int i=ind; i<counter-1;i++) {
		products[i]=products[i+1];
		
	}
	counter=counter-1;
	
}
public void itemadding(String itemName) {
	
	// TODO Auto-generated method stub
	//we will call the db wala function
	
}
}
