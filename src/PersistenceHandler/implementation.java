package PersistenceHandler;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.text.TableView;

import application.model.Checkout;
import application.model.Cnt;
import application.model.Search;
import application.model.SearchInWishlist;
import application.model.delivboysched;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import BusinessLogic.Store;
import PersistenceHandler.dbHandler;
import application.model.Cnt;
import application.model.Search;
import application.model.SearchInWishlist;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

//import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class implementation {
//	Supplier sup = new Supplier();
	 static int counter=0;
	   int the_user;
	  String usernameee="";
	  int customer;
	  int product;
	  
	  static implementation stinstance = null;
		public static implementation getInstance() {
			if(stinstance == null)
			{
				stinstance = new implementation();
			}
			return stinstance;
			
			
		}
		
		
    public void saveIndbUname() {
    	
    }
    public void SaveindbPass(String password) {
    	
    }
   public void fetchDetails(){
    	
    }
   public void fetchSupplierInfo(String name) {
	   
   }
   public void savesReport(String report) {// or arrays of order
	   
   }
   public static final  String quefr="select * from items where ProductName=?";

   public ObservableList<Search> getItem(String productName) throws ClassNotFoundException, SQLException
   {
   	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
	PreparedStatement pes = null;
	ResultSet rs = null;
	ObservableList<Search> stclass = FXCollections.observableArrayList();	  
	stclass.clear();//Lazmiii have to clearr
	String query = "select * from items where ProductName=?";
	
	pes = con.prepareStatement(query);
	pes.setString(1, productName);
	rs = pes.executeQuery();
	
	while(rs.next())
	{
		   stclass.add(new Search(rs.getInt("id"), rs.getString("ProductName"), rs.getString("Material"), rs.getInt("price")));
	}
	
	return stclass;
   	
   }
   private static final String q0 = "select id from customer where username=?"  ;
   private static final String qo = "select * from items where ProductName =?"  ;
   private static final String q9=  "insert into wishlist(customerid, productid) values(?,?) " ;
   public void updateWishlist(String itemdetails) throws ClassNotFoundException, SQLException {//idhar maybe an array of strings with info yaa object
	 //  System.out.println(username);
		 
		 
	   Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
				PreparedStatement stn =  conn.prepareStatement(q0);
				
				 
				 
				 
				 PreparedStatement srtn =  conn.prepareStatement(qo);
					srtn.setString(1, itemdetails);
			         ResultSet resultSdet = srtn.executeQuery();
			         int prodid=0;
					
					 while (resultSdet.next()) {
			     		 prodid= resultSdet.getInt(1);
			              // it will store return true par sab kuch store krlay gaa apnay cheezon main
			          }

				 
					 
					
				 
				 
				 
				 
				 PreparedStatement sstn =  conn.prepareStatement(q9);
					sstn.setInt(1, the_user);
					sstn.setInt(2, prodid);
					 sstn.executeUpdate();
					
					
				 ///
   }
   public void fetchProductinfo() {
	   
   }
   public void orderRetrieverItem(String item, int quantity) {
	   
   }
   public void deliveryboyschedule(String thejob, int id) {
	   
   }
   
 

//   private ObservableList<Cnt> ViewStockClasss;
//   private TableView<Cnt> tablee;

   String SQL = "Select * from Stock";
  
public ObservableList<Cnt> displaystock() throws SQLException
{
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
	PreparedStatement pes = null;
	ResultSet rs = null;
	ObservableList<Cnt> stclass = FXCollections.observableArrayList();	  
	stclass.clear();//Lazmiii have to clearr
	String query = "Select * from Stock";
	pes = con.prepareStatement(query);
	rs = pes.executeQuery();
	
	while(rs.next())
	{
		   stclass.add(new Cnt(rs.getInt("SerialNo"), rs.getString("Iname"), rs.getInt("Itemid"), rs.getInt("quantity"), rs.getInt("price"), rs.getString("supplier")));
	}
	
	return stclass;
//   String table2 = "CREATE table Stockssss"+ "(SerialNo integer AUTO_INCREMENT Primary key,"+" Iname varchar(255) not NULL,"
//			+ "Itemid integer,"+"quantity integer not null,"+"price integer not null,"+"supplier varchar(255))";
//	Statement stmt2 = con.createStatement();	

//	stmt2.executeUpdate(table2);






}

   
private static final String querys = "select * from customer where username = ? and password =?";
public boolean getPassword(String usernamee,String Password)
{   String result = "";
try
   {
	   Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
		PreparedStatement st =  con.prepareStatement(querys);
			st.setString(1, usernamee);
			 st.setString(2, Password);System.out.println(st); ResultSet resultSet = st.executeQuery();
        while (resultSet.next()) {the_user= resultSet.getInt(1); return true; }
   } catch (Exception e) {e.printStackTrace();}

   return false;
}
private static final String queryd = "select * from admin where username = ? and password =?";
public boolean logINs(String usernamee,String Password)
{   String result = "";
   try
   {   Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
		PreparedStatement st =  con.prepareStatement(queryd);
			st.setString(1, usernamee);
			 st.setString(2, Password);
			 System.out.println(st);
         System.out.println("the admin stuff");
         ResultSet resultSet = st.executeQuery();
         while (resultSet.next()) { the_user= resultSet.getInt(1);  return true;   }
        // return false;   
   }
   catch (Exception e)
   {
       e.printStackTrace();
   }
return false;

   
}


private static final String qe = "insert into customer ( name, username, address) values (?,?,?); ";

public void registerusername(String name, String username, String Address) {
	
	usernameee=username;

	 try
	   {
		   Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
			PreparedStatement st =  con.prepareStatement(qe);
			// PreparedStatement prepareStatement = con.prepareStatement(querys)) {
			//st.setInt(1, counter);
			counter++;
				st.setString(1, name);
				 st.setString(2, username);
				 st.setString(3, Address);

	         System.out.println(st);

	        // ResultSet resultSet = st.executeQuery();
	        st.executeUpdate();
	      

	      
	   }
	   catch (Exception e)
	   {
	       e.printStackTrace();
	   }

}





private static final String all = "select * from customer"  ;
private static final String q3 = "update customer set password= ? where id=?"  ;

public void setPassword(String password, String temppass) {
	


	 try
	   {
		
		   Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
			PreparedStatement st =  con.prepareStatement(q3);
			 PreparedStatement aller =  con.prepareStatement(all);
			 ResultSet resultSet = aller.executeQuery();
	        while (resultSet.next()) {
	        	 the_user= resultSet.getInt(1);
	              System.out.println("fff");
	              System.out.println(the_user);
	             // it will store return true par sab kuch store krlay gaa apnay cheezon main
	         }
			// PreparedStatement prepareStatement = con.prepareStatement(querys)) {
				st.setString(1, password);
				st.setInt(2, the_user);
				 

	         //System.out.println(st);

	         st.executeUpdate();
//	         while (resultSet.next()) {
//	        	 the_user= rs.getInt(1);
//	              System.out.println("fff");
//	              System.out.println(the_user);
//	             // it will store return true par sab kuch store krlay gaa apnay cheezon main
//	         }
//	      

	       // return false;
	      

	      
	   }
	   catch (Exception e)
	   {
	       e.printStackTrace();
	   }

}

private static final String q4 = "select price from items where id= ?"  ;

public String fetchproductinfo(int i) {
	//iss main we need one query to get uss item kee price kee key 
	// woh key aatee hai toh line_items main we can store itemkey customer key and quantity and price


	 try
	   {
		 
		   Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
			PreparedStatement st =  con.prepareStatement(q4);
			// PreparedStatement prepareStatement = con.prepareStatement(querys)) {
				//st.setString(1, password);
				 st.setInt(1, i);
				 

	         System.out.println(st);

	         ResultSet resultSet = st.executeQuery();
	         String names="";
	         
	     	
	     	  while (resultSet.next()) {
	     		 names= resultSet.getString("name");
	              // it will store return true par sab kuch store krlay gaa apnay cheezon main
	          }
	     	  return names;
       
	      
	   }
	   catch (Exception e)
	   {
	       e.printStackTrace();
	   }
	 return null;

}
//"insert into customer ( name, username, address) values (?,?,?); ";
private static final String qq = "select id from customer where username=?"  ; 
private static final String q5 = "select * from items where id=?"  ; 
private static final String q6=  "insert into line_item( customerid, productid, quantity, price) values(?,?,?,?) " ;
public String addtocart(int item, int quantity) {
	 try
	   {
		// System.out.println(username);
		 
		 
		   Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
//					PreparedStatement stn =  conn.prepareStatement(qq);
//					stn.setString(1, username);
//			         ResultSet resultSet = stn.executeQuery();
//			         int custid=0;
//					
//					 while (resultSet.next()) {
//			     		 custid= resultSet.getInt(1);
//			              // it will store return true par sab kuch store krlay gaa apnay cheezon main
//			          }
		 /// now we have customer id
					 
					 
		   Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
			PreparedStatement st =  con.prepareStatement(q5);

	         System.out.println(item);
				 st.setInt(1, item);
				 

	         System.out.println(st);

	         ResultSet resultSets = st.executeQuery();
	         
     int  s=0; 
//	     
	     	  while (resultSets.next()) {
	     		   System.out.println("sddfsdhfdskf");
	     		  s= resultSets.getInt("price");
     		  System.out.println(s);
             // it will store return true par sab kuch store krlay gaa apnay cheezon main
	         }
	     	  System.out.println(quantity);
	     	  int prices=s*quantity;
	     	  // now we have priceeeeee
	       
	     	 PreparedStatement stat =  con.prepareStatement(q6);
	     	  
	     	stat.setInt(1, the_user);
	     	stat.setInt(2, item);
	     	stat.setInt(3, quantity);
	     	stat.setInt(4, prices);
	     	 System.out.println(stat);
	     	  stat.executeUpdate();
	     	// ResultSet result = stat.executeQuery();
	   }
	   catch (Exception e)
	   {
	       e.printStackTrace();
	   }
	return "ss";
}
private static final String q7=  "insert into wish_list(customerid, productid) values(?,?) " ;
public void addtowishlist(int item,  int customerid) {
	 try
	   {

         System.out.println("item id in that"+item);

         System.out.println("item id in that"+item);
		   Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
			PreparedStatement st =  con.prepareStatement(qe);
			// PreparedStatement prepareStatement = con.prepareStatement(querys)) {
			//st.setInt(1, counter);
			counter++;
				st.setInt(1, customerid);
				 st.setInt(2, item);
				 //st.setString(3, Address);

	         System.out.println(st);

	        // ResultSet resultSet = st.executeQuery();
	        st.executeUpdate();
	      

	      
	   }
	   catch (Exception e)
	   {
	       e.printStackTrace();
	   }

}


private static final String ill = "select * from items where ProductName =?"  ;
public String fetchProductinfo(String item) throws ClassNotFoundException, SQLException {
///itemId | ProductName | Material | price | descr
	 
	   Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
	 PreparedStatement srtn =  conn.prepareStatement(qo);
		srtn.setString(1, item);
        ResultSet resultSdet = srtn.executeQuery();
        int prodid=0;
		String prodname="";
		String mat="";
		int pricce=0;
		String descr="";
		
		 while (resultSdet.next()) {
    		 prodid= resultSdet.getInt(1);
    		 prodname=resultSdet.getString("ProductName");
    		 mat= resultSdet.getString("Material");
    		 pricce= resultSdet.getInt("price");
    		 descr=resultSdet.getString("descr");
             // it will store return true par sab kuch store krlay gaa apnay cheezon main
         }  
		 
		String s= Integer.toString(prodid)+","+prodname+","+mat+","+pricce+","+descr;
		return s;
}
private static final String qqt = "select id from customer where id=?"; 
private static final String ills = "select * from line_item where customerid=? "  ;
public double returnprice() throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	
	 
	 
	   Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
				PreparedStatement stn =  conn.prepareStatement(qq);
				stn.setInt(1, the_user);
		         ResultSet resultSet = stn.executeQuery();
		         int custid=0;
				
				 while (resultSet.next()) {
		     		 custid= resultSet.getInt(1);
		              // it will store return true par sab kuch store krlay gaa apnay cheezon main
		          }
				 
				 
				 
					PreparedStatement stgn =  conn.prepareStatement(ills);
					stgn.setInt(1, the_user);
			         ResultSet resultSeft = stgn.executeQuery();
			       //  int custid=0;
					int total=0;
					 while (resultSeft.next()) {
			     		int  proce= resultSeft.getInt("price");
			     		 System.out.println("the price is"+proce);
			     		 total= total+proce;
			              // it will store return true par sab kuch store krlay gaa apnay cheezon main
			          }
					 System.out.println(total);

return total;
}


private static final String fs = "select * from Stock where Itemid=?"; 

//public Supplier returnSupplierinfo(int id) throws ClassNotFoundException, SQLException {
//	   Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
//		PreparedStatement stn =  conn.prepareStatement(fs);
//		stn.setInt(1, id);
//		  ResultSet resultSet = stn.executeQuery();
//		  String suppliername="";
//		  String orderstat="";
//			 while (resultSet.next()) {
//				suppliername = resultSet.getString("supplier");
//				orderstat= resultSet.getString("Status");
//				 // it will store return true par sab kuch store krlay gaa apnay cheezon main
//	          }
//			 sup.setvalues(suppliername,orderstat);
//
//	return sup;
//	
//}
private static final String query2 = " insert into stockorders (supplier ,quantity ,date )values(?,?,?)"; 

//public Supplier placeStockorder(String supname, String date, int quantity) throws ClassNotFoundException, SQLException {
//	   Class.forName("com.mysql.cj.jdbc.Driver");
//		Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
//		PreparedStatement stn =  conn.prepareStatement(query2);
//		stn.setString(1, supname);
//		stn.setInt(2, quantity);
//		stn.setString(3, date);
//		System.out.println(supname);
//		        stn.executeUpdate();
//	return sup;
//	
//}

private static final String qqry="select * from customer where username=?";
private static final String qry="select * from items where ProductName=?";
private static final String qryy= "delete from wishlist where customerid=? and productid=? ";
public void UpdateRemWishlist(String itemname) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	 
	 
	   Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
				PreparedStatement stn =  conn.prepareStatement(qry);
				stn.setString(1, itemname);
				 
		         ResultSet resultSet = stn.executeQuery();
		         System.out.println(stn);
		         
		         int prodid=0;
		         
		         while(resultSet.next()) {
		         prodid= resultSet.getInt(1);
		         
		         }
		         
		       
			         
			         
			         
			         PreparedStatement statement =  conn.prepareStatement(qryy);
			         System.out.println(statement);
			         statement.setInt(1, customer);
			         statement.setInt(2, prodid);
			         
			         
			         statement.executeUpdate();
				       //  ResultSet ress = stnn.executeQuery();
				      
				        // String prodcid= resultSetn.getString("username");
}

private static final String qqr1y="select * from customer where username=?";
private static final String qr1y="select * from items where ProductName=?";
private static final String qr1yy= "select * from wishlist where customerid=? and productid=? ";
private static final String ifinwishlist= "select * from items where id=?";

public  ObservableList<SearchInWishlist> fetchItem(String itemname, String username) throws SQLException, ClassNotFoundException 
{
	ObservableList<SearchInWishlist> stclass = FXCollections.observableArrayList();
	stclass.clear();
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
	PreparedStatement stn =  conn.prepareStatement(qry);
	stn.setString(1, itemname);
	int prodid=0;
	ResultSet resultSet = stn.executeQuery();
	System.out.println(stn);
	String prodname="";
	String marer="";
	int pr=0;
     //temId | ProductName | Material | price | descr
	while(resultSet.next())
     {
    	 prodid= resultSet.getInt(1);
    	 prodname= resultSet.getString("ProductName");
    	 marer=resultSet.getString("Material");
    	 pr= resultSet.getInt("price");
    	 
    	 
     }
		         
		         
		         
    PreparedStatement stnn =  conn.prepareStatement(qqry);
	stnn.setString(1, username);
	 System.out.println(stnn);
	//String prodcid="";
	 int custid=0;
     ResultSet resultSetn = stnn.executeQuery();
     while(resultSetn.next())
     {
    	 custid= resultSetn.getInt(1);
     }
			         
			         
			         
	 PreparedStatement statement =  conn.prepareStatement(qr1yy);
	 statement.setInt(1, custid);
	 statement.setInt(2, prodid);
	 ResultSet gonegonegone = statement.executeQuery();
	 System.out.println(statement);
	 int aresult=0;
	 if(gonegonegone.next()) 
	 {
		 aresult=gonegonegone.getInt("customerid");
		 System.out.println("answer araha"+aresult);
		 customer=aresult;
		 product=prodid;
   }
	 System.out.println("answer araha"+aresult);
	 stclass.add(new SearchInWishlist(prodid, prodname, marer, pr));
	 System.out.println("answer araha"+aresult);
 
	 return stclass;
			         
}


private static final String qqq="select * from schedule where job1!=? AND  job2!=? and job3!=? AND (job1='0' or job2='0' or job3='0')";

public  ObservableList<delivboysched> retrieveschedule(String time) throws SQLException, ClassNotFoundException 
{
	
	ObservableList<delivboysched> stclass = FXCollections.observableArrayList();
	stclass.clear();
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
	PreparedStatement stn =  conn.prepareStatement(qqq);
	stn.setString(1, time);
	stn.setString(2, time);
	stn.setString(3, time);
	ResultSet resset= stn.executeQuery();
	System.out.println("answer araha"+stn);
	int boyd=0;
	String j1 = ""; String j2="",j3="";
	while(resset.next()) 
	{
		
		boyd= resset.getInt("boy");
    	j1=resset.getString("job1");
    	j2=resset.getString("job2");
    	 j3=resset.getString("job3");
 	   
    }
	stclass.add(new delivboysched( boyd, j1,j2,j3));
	System.out.println(stclass); 
    return stclass;
    
    
    
	
}

public static final  String querfr="select * from line_item where customerid=?";
public static final  String querfre="select * from items where itemId=?";
public ObservableList<Checkout> displayallitems() throws SQLException{
	   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
	   ObservableList<Checkout> stclass = FXCollections.observableArrayList();	
	   stclass.clear();
	   PreparedStatement stn =  con.prepareStatement(querfr);
	  stn.setInt(1,the_user);
	  System.out.println(stn);
	  ResultSet resultSet = stn.executeQuery();
	  String itname="";
	  int quant=0;
	  int pr=0;
	  int prodid=0;
	  
	  while(resultSet.next()) {
		pr=  resultSet.getInt("price");
		quant= resultSet.getInt("quantity");
		prodid= resultSet.getInt("productid");
		//////////////////////////////////////////
		   PreparedStatement stns =  con.prepareStatement(querfre);
			  stns.setInt(1,prodid);
			  ResultSet resultSett = stns.executeQuery();
			  while(resultSett.next()) {
				  itname=resultSett.getString("ProductName");
				  
			  }
			  
			  
	     ////////////////////////////////////////////
			  
			  stclass.add(new Checkout(pr, itname,quant));
			//  return stclass;
		  
	  }
	return stclass;
	  
	   
	   
}

private static final String illss = "select * from line_item where customerid=? "  ;
public double sendTotal() throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	
	 
	 
	   Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
				//PreparedStatement stn =  conn.prepareStatement(qq);
		       
				 
				 
				 
					PreparedStatement stgn =  conn.prepareStatement(illss);
					stgn.setInt(1, the_user);
			         ResultSet resultSeft = stgn.executeQuery();
			       //  int custid=0;
					int total=0;
					 while (resultSeft.next()) {
			     		int  proce= resultSeft.getInt("price");
			     		 total= total+proce;
			              // it will store return true par sab kuch store krlay gaa apnay cheezon main
			          }

return total;
}
private static final String sele="select * from schedule where boy =?";
private static final String j1="update schedule set job1=? where boy=? and job1='0'";
private static final String j2="update schedule set job2=? where boy=? and job2='0'";
private static final String j3="update schedule set job3=? where boy=? and job3='0'";

public void Assigningjob(int dboy, String time) throws ClassNotFoundException, SQLException 
{
	// TODO Auto-generated method stub
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
		PreparedStatement st =  con.prepareStatement(sele);
		st.setInt(1, dboy);
		ResultSet resset= st.executeQuery();
		String j1s="";
		String j2s="";
		String j3s="";
		while(resset.next()) 
		{
		j1s=resset.getString("job1");
		j2s=resset.getString("job2");
		j3s=resset.getString("job3");
		}
		
		if(j1s.equals("0")) 
		{
			PreparedStatement std =  con.prepareStatement(j1);
			std.setInt(2,dboy);
			std.setString(1,time);
			//ResultSet rrr=
			std.executeUpdate();
			
		}
		else if(j2s.equals("0"))
		{
			PreparedStatement std =  con.prepareStatement(j2);
			std.setInt(2,dboy);
			std.setString(1,time);
			std.executeUpdate();
			//ResultSet rrr= std.executeQuery();
		}
		else 
		{
			PreparedStatement std =  con.prepareStatement(j3);
			std.setInt(2,dboy);
			std.setString(1,time);
			std.executeUpdate();
			//ResultSet rrr= std.executeQuery();
		}
		
	
	
}


//ADDD TO SCHEDULE
/// GENERATE REPORT
//MAKE PAYMENT 
// add to schedule main there is time and date
// generate report main bhi time kee cheezain hain
//make payment yet to make
}
