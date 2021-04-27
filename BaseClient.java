package FInalPark;
import java.util.Scanner;

public abstract class BaseClient {
	Scanner sc=new Scanner(System.in);
	
    public abstract  void SetSlot();
    public abstract void ToRemoveFromSlot();
    public abstract void SearchSlotByRegNumber();
    public abstract void SearchCarByColor();
    public abstract void searchSlotByColor();
}
