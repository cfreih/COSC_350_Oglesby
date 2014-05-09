//Demo
import java.util.*;

public class SQLDemo
{
   	public static void main( String[] args )
   	{
		//SQLConnector connector = new SQLConnector("insert into auction_paintings (painterID, title, dateOfWork, dateOfAuction, salePrice, height, widht, medium, subject) values (1, 'Painting1-4', 1995, '20100322', 200000.55, 12.10, 15.10, 'Oil', 'Lunar');");
		//int flag = connector.executeSQL_Update();
		//System.out.println(flag);
		SQLConnector connector = new SQLConnector("SELECT lastName, firstName FROM painters order by lastName;");
		Vector querryReadyResult = connector.executeSQL_Query();
		int flag= querryReadyResult.size();
		System.out.println(flag);
		System.out.println("Ordered by Last Name");
		for(int i=0; i<flag; i++){
			System.out.println(querryReadyResult.elementAt(i));			
			System.out.println();			
		}
		connector = new SQLConnector("SELECT firstName, lastName FROM painters order by firstName;");
		querryReadyResult = connector.executeSQL_Query();
		flag= querryReadyResult.size();
		//System.out.println(flag);
		System.out.println("Ordered by First Name");
		for(int i=0; i<flag; i++){
			System.out.println(querryReadyResult.elementAt(i));			
			System.out.println();			
		}
  	} 
} 
