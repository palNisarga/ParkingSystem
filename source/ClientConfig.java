package parkingLot; 
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class ClientConfig {
    public static Connection connection;
    private static String client;

    public static Connection create() {
	Connection con= null;
	try{  
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db?characterEncoding=utf8","nisarga","12345678");    
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

	public static String getClient() {
		// TODO Auto-generated method stub
		return null;
	}

	public void mysqlConnection() {
		// TODO Auto-generated method stub
		
	}
	    public void mongoConnection(){
        MongoClient mongoClient =new MongoClient(properties.getProperty("HOST"), Integer.parseInt(properties.getProperty("mongoPort")));
        MongoDatabase database= mongoClient.getDatabase("car_parking");
        this.setDatabase(database);
        MongoCollection<Document> collection=database.getCollection("parking_system");
        this.setCollection(collection);
        this.setUpdateFields(new BasicDBObject());
        this.setSetQuery(new BasicDBObject());
        this.setWhereQuery(new BasicDBObject());
    }

}
