package BusinessLogic;
import java.sql.SQLException;

import PersistenceHandler.dbHandler;
import application.model.Checkout;
import application.model.Cnt;
import application.model.Search;
import application.model.SearchInWishlist;
import application.model.delivboysched;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Store {
	
static Store stinstance = null;
private ObservableList<Cnt> StockClass = FXCollections.observableArrayList();
private ObservableList<Search> Searchh = FXCollections.observableArrayList();
private ObservableList<SearchInWishlist> WSearch = FXCollections.observableArrayList();
ObservableList<delivboysched> stclass = FXCollections.observableArrayList();

	
	
	Store(){};
	
	public static Store getInstance() {
		if(stinstance == null)
		{
			stinstance = new Store();
		}
		return stinstance;
		
		
	}
	
	

	
	
	
	
String name;
Admin admin= new Admin();
Customer c1;
dbHandler db= new dbHandler();
public ObservableList<Search> finditem(String item) throws ClassNotFoundException, SQLException {
	//ObservableList<Cnt> wishlist = FXCollections.observableArrayList();
	Searchh = c1.searchforitem(item);
	return Searchh;
	
	//return null;
}

public void additem(String itemName) throws ClassNotFoundException, SQLException {
	c1.itemAdd(itemName);
}


public void AddtoCart(int item, int quantity) {
	c1.AddinCart(item, quantity);
}


public void enterUsername( String name, String username, String Add) {
	c1 = new Customer();
	c1.SaveUsername(name, username, Add);
}

public void enterPassword( String password) {
	c1.setTempPassword( password);
}

public void enterConfirmPassword(String password) {
	c1.setPassword(password);
}

public void login(String username, String password) {
	c1.verifyusers(username, password);
}
/////ADMIN VIEW STOCK
public ObservableList<Cnt> viewstock() throws SQLException {
	StockClass = admin.displayStock();
	return StockClass;
}
//for ordering stock

public void generateReport(String[] column, String time) {
	admin.generateSalesReport(time, column);
}
public void sendingapproval(String status) {
	admin.sendingApproval(status);
}

//search for wishlisht
public ObservableList<Search> finditemwishlist(String name) throws ClassNotFoundException, SQLException {/// change name find itemrem karna hai
	Searchh = c1.searchForWishlist(name);
	return Searchh;
}
public boolean cutomerlogin(String Username, String Password) {
	if(db.getInstance().verifycustomer(Username, Password)) {
		c1 = new Customer();
		c1.username=Username;
		c1.password= Password;
	}
	 return db.verifycustomer(Username, Password);
}
public boolean logIN(String username, String password) {
	admin.verifyinformation(username, password);
	boolean answer=admin.verifydetails(username,password);
	return answer;
}



public ObservableList<SearchInWishlist> findItemRemWishlist(String item ) throws ClassNotFoundException, SQLException {
	return WSearch= c1.searchinwishlist(item);
	
}

public boolean logIN1(String emailId, String password) {
	// TODO Auto-generated method stub
	boolean answer=admin.verifydetails(emailId,password);
	return answer;
}

//public void finditem

public ObservableList<delivboysched> SearchDeliveryBoy(String time) throws SQLException, ClassNotFoundException {
	
	stclass = admin.searchboyforjob(time);
	return stclass;
	
}


public void Assigningjob(int dboy) throws ClassNotFoundException, SQLException {
	admin.Assigningjob(dboy);
}

public void removeItem(String itemname) throws ClassNotFoundException, SQLException {
	c1.removingfromwishlist(itemname);
}

public ObservableList<Checkout> displayitems() throws ClassNotFoundException, SQLException{
	return c1.checkoutdisplayitems();
}

public double returnprice() throws ClassNotFoundException, SQLException {
	double prices=0;
	prices=c1.checkoutdisplayprice();
	
	return prices;
}
}
