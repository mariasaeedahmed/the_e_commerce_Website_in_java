package BusinessLogic;
import java.sql.SQLException;

import PersistenceHandler.dbHandler;
import application.model.Checkout;
import application.model.Search;
import application.model.SearchInWishlist;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Customer {
   String username;
   String temppass;
   String password;
   ObservableList<Search> Item;
   Cart cart= new Cart();
   Wish_list w1= new Wish_list();
   dbHandler db= new dbHandler();
   
   int index=-1;
   Wish_list wishlist= new Wish_list();
	static char counter='0';

	public void searchProductwishlist() {
		
	}
	public ObservableList<Search> searchForWishlist(String item) throws ClassNotFoundException, SQLException {
		ObservableList<Search> searchh = FXCollections.observableArrayList();
		Stock s= new Stock();
		searchh = Item=s.SearchProductWishlist(item);
		return searchh;
	}

	public void itemAdd(String itemName) throws ClassNotFoundException, SQLException {
		wishlist.itemadding(itemName);
		db.getInstance().updateWishlist(itemName);
	}
	public ObservableList<Search> searchforitem(String item) throws ClassNotFoundException, SQLException {
		ObservableList<Search> searchh = FXCollections.observableArrayList();
		Stock s= new Stock();
		Product prod= new Product(); //uncomment
		searchh = s.SearchProductWishlist(item);
		
		return searchh;
		
		
//		Item=s.SearchProductWishlist(item);
//		return null;////   
		
	}
	public void AddinCart(int item, int quantity) {
		
		cart.newItem(item , quantity);
		
	}
	public ObservableList<Checkout> checkoutdisplayitems() throws ClassNotFoundException, SQLException {
		// i dont understand how to call this from checkout
		return cart.DisplayOrderedItems();
		//idhar display total
		} 
	
	public double checkoutdisplayprice () throws ClassNotFoundException, SQLException
	{
		
		return cart.DisplayPrice();
		
	}
	///////////to remove///////////////////////
	public ObservableList<SearchInWishlist> searchinwishlist(String itemname) throws ClassNotFoundException, SQLException {
		ObservableList<SearchInWishlist> SW = FXCollections.observableArrayList();
		SW=wishlist.iteminwishlist(itemname, username);
		//removingfromwishlist(index);
	
		return SW;
	}
	public void removingfromwishlist(String itemname ) throws ClassNotFoundException, SQLException {
		
		
		
		wishlist.removefromwishlist(itemname);
	}
	///////////////////////////////
	public void enterPaymetDetails() {
		
	}
	public void enterdiscountCode() {
		
	}
	public void SaveUsername(String username, String name, String add) {
		this.username=username;
		//iss main writing into db walee cheez
		
		db.getInstance().saveIndbUname(username, name, add);;
		

	}
	public void setTempPassword(String password) {
		this.temppass=password;
	}
	public void setPassword(String password) {
	  if(temppass.equals(password)) {
		  db.SaveindbPass(password);

	  }
	}
	
	
	
	public void verifyusers(String username2, String password2) {
		// TODO Auto-generated method stub
		db.verifycustomer(username2, password2);
	
	}
	public void checkout1() {
		
	}
	
}

// wishlist ka bhi db banay gaa

