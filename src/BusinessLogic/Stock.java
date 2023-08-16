package BusinessLogic;
import java.sql.SQLException;

import PersistenceHandler.dbHandler;
import application.model.Cnt;
import application.model.Search;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Stock {
	 Product products[] = new Product[100];
	 dbHandler dbs= new dbHandler();
	 Product_Description pds = new Product_Description();
	 public  ObservableList<Search> SearchProductWishlist(String name) throws ClassNotFoundException, SQLException {
			/*
			 * for(int i=0;i<100;i++) {
			 * 
			 * // idhar ek db main multiple functions call krke iss object ko poora krdete
			 * hain // String retname= products[i].retrieveproducts();
			 * if(retname.equals(name)) { return products[i]; } }
			 */
		 ObservableList<Search> std = FXCollections.observableArrayList();
		 std = dbs.getInstance().getItem(name);
		// dbs.
	 	return std;
	 }
	 public ObservableList<Cnt> stockDetails() throws SQLException {
//		 for(int i=0;i<100;i++) {
//			 System.out.print(products[i].id);
//			 System.out.print(products[i].retrieveproducts());
//			 System.out.print(products[i].pd.items_in_stock);
//		 }
		 //
		 ObservableList<Cnt> stockclass = FXCollections.observableArrayList();
		  stockclass = dbs.getInstance().fetchDetails();
		  
		  return stockclass;
	 }
//	 public Supplier getDetails(int id) throws ClassNotFoundException, SQLException {
//		/* for(int i=0;i<100;i++) {
//			 	int retname=	products[i].id;
//			 	    if(retname==id) {
//			 	    	Supplier sup=products[i].pd.SupplierInfo();
//			 	    	return sup;
//			 	    }
//			 	}*/
//		 System.out.println(pds.SupplierInfo(id).name);
//		 return pds.SupplierInfo(id);
//		 
//	 }
//
//	 
//	 public Product getitem(String name, int quantity) throws ClassNotFoundException, SQLException {
//		ObservableList<Search> p= this.SearchProductWishlist(name);
//	if(p.pd.items_in_stock>=quantity) {
//		return p ;
//	}
//		return null;	
//		 
//	 }
}
