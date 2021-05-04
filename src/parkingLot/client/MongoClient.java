package parkingLot;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.bson.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class MongoClient extends BaseClient {
   static Scanner input = new Scanner(System.in);
   static ClientConfig mongodb=new ClientConfig();
   static MongoClient con = mongodb.mongoConnection();
   static MongoDatabase database = con.getDatabase("myDatabase");

	public void SetSlot() {
		System.out.println("Enter Colour");
    		String colour = input.next();
    		System.out.println("Enter Reg Plate");
    		String regPlate = input.next();
    	
    		System.out.println("Alloting a slot..."+"\n");
    		boolean flag=false;
    		Document document = new Document();
    	
    		document.append("registrationNumber", regPlate);
    		document.append("Colour", colour);
    		database.getCollection("vehicles").insertOne(document);
	}
       Document vehicleInfo = appConfig.getCollection().find(new Document("registrationNumber", regNo)).first();
       System.out.println("Alloting a slot... " + vehicleInfo.get("_id"));
     }
    
     public void ToRemoveFromSlot(){
	System.out.println("Enter Reg Plate");
        String regNo=sc.nextLine());
        document.append.append("registrationNumber",null);
        document.append.append("Colour", null);
        BasicDBObject setQuery = new BasicDBObject();
        setQuery.append("$set", insertOne(document));
        appConfig.getCollection().updateOne(Filters.eq("registrationNumber",regNo), setQuery);
        
	    }
    
    public void SearchSlotByRegNumber() {
        boolean flag=false;
        System.out.print("Enter vehicle Registration Number :");
        String regNo=sc.nextLine();
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
        String colour=sc.nextLine(); 
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
        String colour=sc.nextLine();
        for (Document info : slotInfo) {
            System.out.println("Vehicle Slot Number  : " + info.get("_id"));
            flag=true;
        }
        if(!flag){
            System.out.println("No vehicle is available !!!");
        }
    }
}
