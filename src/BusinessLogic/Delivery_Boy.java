package BusinessLogic;

import java.sql.SQLException;

import PersistenceHandler.dbHandler;
import application.model.delivboysched;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Delivery_Boy {
int id;
String name;
Schedule[] schedule= new Schedule[100];
dbHandler db= new dbHandler();
int counter=0;
public ObservableList<delivboysched> retrieve_schedule(String time) throws SQLException, ClassNotFoundException {
	ObservableList<delivboysched> stclass = FXCollections.observableArrayList();
	return stclass = db.getInstance().retrieveschedules(time);
	

	// we can try keh har unique id keh liye pehlay woh send karay waapis idhar business logic  idhar woh match krle time
//	db.retrieveschedules(time)
}

public void updateSchedule(int rider, String the_job) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	db.getInstance().Assigningjob(rider, the_job);
}


}
