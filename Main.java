package FInalPark;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws IOException, SQLException {
		Object client=new InMemoryClient();
		

		Scanner input = new Scanner(System.in);
	    int menu = 0;
		do {
			Menu.options();
			menu = input.nextInt();
      
		switch(menu) {
			case(1):
				MySqlClient.SetSlot();
				break;
			case(2):
				MySqlClient.ToRemoveFromSlot();
				break;
			case(3):
				MySqlClient.SearchSlotByRegNumber();
				break;
            case(4):
                MySqlClient.SearchCarByColor();
				break;
            case(5):
            	MySqlClient.searchSlotByColor();//
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
