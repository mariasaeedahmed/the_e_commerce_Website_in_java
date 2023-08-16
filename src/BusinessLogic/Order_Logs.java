package BusinessLogic;
import PersistenceHandler.dbHandler;
public class Order_Logs {
	String approval;
	// order ka array store hogaa idhar jo keh we will use
	dbHandler db= new dbHandler();
public void createReport(String time, String []column) {
	// this should return report
}
public void setApproval(String Status) {
	if (Status.equals("Approved")) {
		//db main likhnay wala kaam
		db.getInstance().savesReport(Status);
	}
}
}
