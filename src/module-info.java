module reebsreebs {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	requires java.sql;
	requires java.desktop;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base,java.sql;
	 opens application.model to javafx.fxml, javafx.base,java.sql;
	 exports application;
	 exports application.model;
	//opens application to javafx.graphics, javafx.fxml;
}
