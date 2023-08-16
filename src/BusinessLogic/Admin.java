package BusinessLogic;
import java.sql.SQLException;

import PersistenceHandler.dbHandler;
import application.model.Cnt;
import application.model.delivboysched;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class Admin {
	String Username = "admin";
	String Password= "pass";
	//array of delivery boy
	Delivery_Boy dboy= new Delivery_Boy();
	Stock s= new Stock();
	dbHandler db= new dbHandler();
	Order_Logs ol= new Order_Logs();
//	Supplier sup= new Supplier();
	String timereq="";
public ObservableList<Cnt> displayStock() throws SQLException {
//	  System.out.println("someithing");
	ObservableList<Cnt> stockclass = FXCollections.observableArrayList();
	stockclass = s.stockDetails();
	
	return stockclass;
	//db.fetchDetails();
}
//public void itemQuantity(int id ,String date, int quantity) throws ClassNotFoundException, SQLException {
//	// we also need to give item id as well
//	//Stock s= new Stock();
//	
//  sup=s.getDetails(id);
//  System.out.println(sup.name);
//  sup.timeDateRequirements(date, quantity,sup.name);
//	
//}
public void generateSalesReport(String time, String []column) {
	ol.createReport(time, column);
}
public void sendingApproval(String status) {
	ol.setApproval(status);
}
public void verifyDetails() {
	
}
public ObservableList<delivboysched> searchboyforjob(String time) throws SQLException, ClassNotFoundException {
	// db main dhundnaa hai
//	dboy.retrieve_schedule();
	timereq=time;
	ObservableList<delivboysched> stclass = FXCollections.observableArrayList();
	stclass = dboy.retrieve_schedule(time);
	return stclass;

	
}
public void Assigningjob(int rider) throws ClassNotFoundException, SQLException {
	// idhar we ask for new job
	//String the_job="";
	//LocalDate dateandtime = null;
	dboy.updateSchedule(rider,timereq);
	
}
public int verifyinformation(String username, String pass) {
	if(this.Username.equals(username) && this.Password.equals(pass)) {
		return 1;
	}
	return 0;
}
public boolean verifydetails(String emailId, String password2) {
	// TODO Auto-generated method stub
	if(emailId.equals("muhammad")&& password2.equals("maroo"))
	return true;
	return false;
}

}
