package parkingLot;
import java.util.ArrayList;
import java.util.Collections;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

	public class MongoClient extends BaseClient  {
     static Scanner input = new Scanner(System.in);
	   static MongoDB mongo =new MongoDB();
	   static Connection con = mongo.create();
	   public void SetSlot() throws SQLException {
       	System.out.println("Enter Colour");
	    	String colour = input.next();
	    	System.out.println("Enter Reg Plate");
	    	String regPlate = input.next();
	      
	    	Statement stmt= con.createStatement();
        Vehicle vehicle=registerVehicle();
        boolean flag=false;
        if(vehicle!=null && !duplicateInfo(vehicle)) {
            appConfig.getUpdateFields().append("registrationNumber", vehicle.getRegNo().toUpperCase());
            appConfig.getUpdateFields().append("Colour", vehicle.getColour().toUpperCase());
            appConfig.getSetQuery().append("$set", appConfig.getUpdateFields());
            appConfig.getCollection().updateOne(Filters.eq("registrationNumber", null), appConfig.getSetQuery());
            displayTicket(vehicle.getRegNo().toUpperCase());
            flag=true;
        }
       if(!flag){
            System.out.println();
            System.out.println("Wrong Input");
        }
       Document vehicleInfo = appConfig.getCollection().find(new Document("registrationNumber", regNo)).first();
       System.out.println("Alloting a slot... " + vehicleInfo.get("_id"));
     }
    
     public void ToRemoveFromSlot(){
	      System.out.println("Enter Reg Plate");
        String regNo=sc.nextLine().toUpperCase();
        appConfig.getUpdateFields().append("registrationNumber",null);
        appConfig.getUpdateFields().append("Colour", null);
        BasicDBObject setQuery = new BasicDBObject();
        setQuery.append("$set", appConfig.getUpdateFields());
        appConfig.getCollection().updateOne(Filters.eq("registrationNumber",regNo), setQuery);
        System.out.println("Slot is now available ");
	    }
    
    public void SearchSlotByRegNumber() {
        boolean flag=false;
        System.out.print("Enter vehicle Registration Number :");
        String regNo=sc.nextLine().toUpperCase();
        for (Document info : vehicle) {
            System.out.println("vehicle Slot Number :"+info.get("_id"));
            flag=true;
        }
        if(!flag){
            System.out.println("No vehicle is available !!!");
        }
    }

  
    public void SearchCarByColor() {
        boolean flag=false;
        System.out.print("Enter vehicle Colour :");
        String colour=sc.nextLine().toUpperCase();
        List<Document> vehicleInfo = appConfig.getCollection().find(Filters.eq("Colour", colour)).into(new ArrayList<>());
        for (Document info : vehicleInfo) {
            System.out.println("vehicle Registration Number :"+info.get("registrationNumber"));
            flag=true;
        }
        if(!flag){
            System.out.println("No vehicle is available !!!");
        }
    }

   
    public void SearchSlotByColor() {
        boolean flag=false;
        System.out.print("Enter vehicle Colour :");
        String colour=sc.nextLine().toUpperCase();
        List<Document> slotInfo = appConfig.getCollection().find(Filters.eq("Colour", colour)).into(new ArrayList<>());
        for (Document info : slotInfo) {
            System.out.println("Vehicle Slot Number  : " + info.get("_id"));
            flag=true;
        }
        if(!flag){
            System.out.println("No vehicle is available !!!");
        }
    }
}
