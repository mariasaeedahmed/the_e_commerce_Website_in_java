package PersistenceHandler;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import application.model.Checkout;
import application.model.Cnt;
import application.model.Search;
import application.model.SearchInWishlist;
import application.model.delivboysched;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
public class dbHandler {
//	Supplier SuppLObj = new Supplier();
   static int counter=0;
   int the_user;
  String usernameee="";
  implementation imp= new implementation();
  
  
  
  static dbHandler stinstance = null;
		public static dbHandler getInstance() {
			if(stinstance == null)
			{
				stinstance = new dbHandler();
			}
			return stinstance;
			
			
		}
		
    public Connection getConnection() throws ClassNotFoundException, SQLException{       
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
	return DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
		
	}
		
	}
	 
    
    public boolean verifycustomer(String username, String Password) {
    	return imp.getPassword(username, Password);
    }
    public boolean logINs(String username, String Password) {
    	return imp.getPassword(username, Password);
    }
	private static final String qe = "insert into customer ( name, username, address) values (?,?,?); ";

    public void saveIndbUname(String name, String username, String Address) {

    
    		
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

    public void SaveindbPass(String password) {
    
    		


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
//    		         while (resultSet.next()) {
//    		        	 the_user= rs.getInt(1);
//    		              System.out.println("fff");
//    		              System.out.println(the_user);
//    		             // it will store return true par sab kuch store krlay gaa apnay cheezon main
//    		         }
//    		      

    		       // return false;
    		      

    		      
    		   }
    		   catch (Exception e)
    		   {
    		       e.printStackTrace();
    		   }
    }
   public ObservableList<Cnt> fetchDetails() throws SQLException{
//    	
	  
	   
	   ObservableList<Cnt> stclass = FXCollections.observableArrayList();
	   
	   
	   try {
    		  System.out.println("someithing");
    		  
    		  stclass = imp.displaystock();
    		  
    		  
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	   return stclass;
	   
	   
    }
 
   public void savesReport(String report) {// or arrays of order
	   
   }
   public static final  String quefr="select * from items where ProductName=?";

   public ObservableList<Search> getItem(String itemname) throws ClassNotFoundException, SQLException
   {
	   //ObservableList<Search> std = FXCollections.observableArrayList();
	  // std= imp.getItem(itemname);
	   

	   
	   	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
		PreparedStatement pes = null;
		ResultSet rs = null;
		ObservableList<Search> stclass = FXCollections.observableArrayList();	  
		stclass.clear();//Lazmiii have to clearr
		String query = "select * from items where ProductName=?";
		
		pes = con.prepareStatement(query);
		pes.setString(1, itemname);
		rs = pes.executeQuery();
		
		while(rs.next())
		{
			   stclass.add(new Search(rs.getInt("id"), rs.getString("ProductName"), rs.getString("Material"), rs.getInt("price")));
		}
		
		return stclass;
	   	
	   
	   
	
	  
   }
 
   public String fetchProductinfo(String item) throws ClassNotFoundException, SQLException {
	  return imp.fetchProductinfo(item);
	  
   }
   private static final String qq = "select id from customer where username=?"  ; 
   private static final String q5 = "select * from items where id=?"  ; 
   private static final String q6=  "insert into line_item( customerid, productid, quantity, price) values(?,?,?,?) " ;
  // private static final String qe = "insert into customer ( name, username, address) values (?,?,?); ";
   public void orderRetrieverItem(int item, int quantity) {
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
	//return "ss";  
	}
   

   public void deliveryboyschedule(String thejob, int id) {
	   
   }
   

//public void OrderStockk(int quantity,String dte, String SupplierName) throws ClassNotFoundException, SQLException
//{
//	 imp.placeStockorder(SupplierName,dte,quantity);
//	
//}
//public Supplier fetchSupplierInfo(int id) throws ClassNotFoundException, SQLException 
//
//{
//	return imp.returnSupplierinfo(id);
//	
//	
//}
	private static final String q0 = "select id from customer where username=?"  ;
	private static final String qo = "select * from items where ProductName =?"  ;
	private static final String q9=  "insert into wishlist(customerid, productid) values(?,?) " ;

	public void updateWishlist(String itemName) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
		PreparedStatement stn =  conn.prepareStatement(q0);
		PreparedStatement srtn =  conn.prepareStatement(qo);
		srtn.setString(1, itemName);
        ResultSet resultSdet = srtn.executeQuery();
        int prodid=0;
		while (resultSdet.next()) 
		{
			prodid= resultSdet.getInt(1);
		}
		PreparedStatement sstn =  conn.prepareStatement(q9);
		sstn.setInt(1, the_user);
		sstn.setInt(2, prodid);
		sstn.executeUpdate();			 ///
	}

	private static final String qqt = "select id from customer where id=?"; 
	private static final String ills = "select * from line_item where customerid=? "  ;
		
	public double returnprice() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=  DriverManager.getConnection("jdbc:mysql://localhost:3306/clothing_store","root","Alaska130");
		PreparedStatement stn =  conn.prepareStatement(qq);
		stn.setInt(1, the_user);
        ResultSet resultSet = stn.executeQuery();
        int custid=0;
        while (resultSet.next()) 
        {
        	custid= resultSet.getInt(1);
        }			 
		PreparedStatement stgn =  conn.prepareStatement(ills);
		stgn.setInt(1, the_user);
		ResultSet resultSeft = stgn.executeQuery();
		int total=0;
		while (resultSeft.next()) 
		{
		 	int  proce= resultSeft.getInt("price");
		 	System.out.println("the price is"+proce);
		 	total= total+proce;
		}
		System.out.println(total);
		return total;
	

	
	}


	public void freeinslots(String time)
	{
		
	}


public  ObservableList<delivboysched> retrieveschedules(String time) throws SQLException, ClassNotFoundException {
	ObservableList<delivboysched> stclass = FXCollections.observableArrayList();
	return stclass = imp.retrieveschedule(time);
}


public ObservableList<SearchInWishlist> fetchItem(String itemname, String username) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	
	return imp.fetchItem(itemname, username);
}


public void UpdateRemWishlist(String itemname) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	imp.UpdateRemWishlist(itemname);
	
}


public void Assigningjob(int dboy,String time) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
	imp.Assigningjob( dboy, time) ;
	
}
public static final  String querfr="select * from line_item where customerid=?";
public static final  String querfre="select * from items where itemId=?";


public ObservableList<Checkout> displayallitems() throws SQLException {
	// TODO Auto-generated method stub
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


//ADDD TO SCHEDULE
/// GENERATE REPORT
//MAKE PAYMENT 
// add to schedule main there is time and date
// generate report main bhi time kee cheezain hain
//make payment yet to make

}


//add to wishlist
