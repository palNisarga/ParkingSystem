package ParkingLot;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws IOException, SQLException {
		Object client=new InMemoryClient();
		String FetchData = input.nextLine();
		Object database;
		if(FetchData.equalsIgnoreCase("inMemory")) {
			else {
				  database = new MysqlDB();

		Scanner input = new Scanner(System.in);
	    	int menu = 0;
		do {
			Menu.options();
			menu = input.nextInt();
      
		switch(menu) {
			case(1):
				database.SetSlot();
				break;
			case(2):
				database.ToRemoveFromSlot();
				break;
			case(3):
				database.SearchSlotByRegNumber();
				break;
           		 case(4):
              			  database.SearchCarByColor();
				break;
           		 case(5):
            			database.searchSlotByColor();//
				break;
			case(0):
               			 System.out.println("\nThank you!\n");
	           		 break;
            		default: {
	            		 System.out.println("Invalid option!\n");
	         		//break;
	                    }
		      }	
		}
		while(menu!=0);
		
	}

}
