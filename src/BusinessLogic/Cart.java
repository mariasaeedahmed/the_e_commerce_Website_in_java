package BusinessLogic;
import java.sql.SQLException;

import PersistenceHandler.dbHandler;
import PersistenceHandler.implementation;
import application.model.Checkout;
import javafx.collections.ObservableList;
public class Cart {
	//Product[] products_in_cart= new Product[100];
	// idhar line item ka banay ga array
	//idhar line item wala sabb karna
	Line_Item[] lineitem= new Line_Item[100];
	int counter=0;
	double totaling=0;
	dbHandler db= new dbHandler();
	implementation sd = new implementation();
int id;
//newitem

public double DisplayPrice() throws ClassNotFoundException, SQLException {
	double total_bill=0;
	total_bill=db.getInstance().returnprice();
	
	return total_bill;
	
}


public ObservableList<Checkout> DisplayOrderedItems() throws ClassNotFoundException, SQLException {
	//double total_bill=0;
//	total_bill=db.returnprice();
	return	db.getInstance().displayallitems();
	//return total_bill;
	
}


public void ApplyDiscountCode(double code) {
	
}
public void newItem(int item, int quantity) {
	// TODO Auto-generated method stub
	lineitem[counter]= new Line_Item();
	lineitem[counter].newitem(id, quantity);
	counter++;
   db.getInstance().orderRetrieverItem(item, quantity);
}
}
