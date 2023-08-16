package BusinessLogic;
import java.sql.SQLException;

import PersistenceHandler.dbHandler;
public class Product {
int id;
Product_Description pd;
dbHandler db= new dbHandler();
public void getDetails() {
	
}
public void searchProductwishlist() {
}
public String retrieveproducts() {
	 return pd.getName();
}
public void getItem() {
	
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Product_Description getPd() {
	return pd;
}
public void setPd(Product_Description pd) {
	this.pd = pd;
}
public dbHandler getDb() {
	return db;
}
public void setDb(dbHandler db) {
	this.db = db;
}
public String retrieveproduct(String item) throws ClassNotFoundException, SQLException {
String prodinfo=	db.getInstance().fetchProductinfo( item);
	String[] arr = prodinfo.split(",");
	  return arr[1];
}
}
