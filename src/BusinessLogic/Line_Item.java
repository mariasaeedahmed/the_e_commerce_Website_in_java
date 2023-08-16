package BusinessLogic;
import PersistenceHandler.dbHandler;
public class Line_Item {
	dbHandler db= new dbHandler();
int ItemQuantity;
double price;
int the_product;
public double sendTotal(String itemname,String username) {
	
	 //db.returnprice(itemname, username);
	return price;
	// this we will take from db
}
public void newItem() {
	
}
public void newitem(int id, int quantity) {
	// TODO Auto-generated method stub
	ItemQuantity=quantity;
	the_product=id;
	//price=id.pd.price*quantity;
}



}
