package ParkingLot; 
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class ClientConfig {
    public static Connection connection;
    public static Statement statement;
    public static Properties properties;
    @SuppressWarnings("unused")
	private static String client;


    public void fileConfig() {
        try {
            properties = new Properties();
            properties.load(new FileReader("src/main/resources/config.properties"));
            MySQL.client = properties.getProperty("Client");
        } catch (Exception e) {
                 e.printStackTrace();
        }

}

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
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		MySQL.connection = connection;
	}

}
