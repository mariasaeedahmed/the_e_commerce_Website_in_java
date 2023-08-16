package BusinessLogic;
import java.sql.SQLException;

import PersistenceHandler.dbHandler;
public class Product_Description {
String name;
double price;
String description;
private String Material;
int items_in_stock;
//Supplier Sup= new Supplier();
dbHandler db= new dbHandler();


//public char[] items_in_stock;
// idhar supplier info

public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public int getItems_in_stock() {
	return items_in_stock;
}
public void setItems_in_stock(int items_in_stock) {
	this.items_in_stock = items_in_stock;
}
//public Supplier getSup() {
//	return Sup;
//}
//public void setSup(Supplier sup) {
//	Sup = sup;
//}
public dbHandler getDb() {
	return db;
}
public void setDb(dbHandler db) {
	this.db = db;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
// idhar supplier info
//public Supplier SupplierInfo(int id) throws ClassNotFoundException, SQLException {
//	//issay supplier name ajayegaa
//	db.getInstance().fetchSupplierInfo(id);
//	System.out.println("We in product Desc");
//	System.out.println(db.fetchSupplierInfo(id).name);
//	return db.getInstance().fetchSupplierInfo(id);
//	
//}
public String getMaterial() {
	return Material;
}
public void setMaterial(String material) {
	Material = material;
}
}
