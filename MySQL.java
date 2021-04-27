package FInalPark;
import java.sql.*;
public class MySQL 
{  

public Connection create() {
	Connection con= null;
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/test_db?characterEncoding=utf8","nisarga","qwertyuiop");    
		
		}
	catch(Exception e){ 
		System.out.println(e);
		}
	return con;
}
}