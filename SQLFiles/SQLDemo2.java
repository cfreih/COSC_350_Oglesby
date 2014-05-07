//Demo2
import java.util.*;

public class SQLDemo2
{
   	public static void main( String[] args )
   	{

		SQLConnector connector = new SQLConnector("SELECT * FROM painters INNER JOIN inventory_paintings where title = 'TestPainting1';");
		Vector querryReadyResult = connector.executeSQL_Query();
		int i=0;
		InventoryPainting inventoryTest1 =new InventoryPainting();
		inventoryTest1.setArtistID(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setArtistFirstName(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setArtistLastName(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setTitleOfWork(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setDateOfWork(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setClassification(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setHeightCM(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setWidthCM(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setMedium(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setSubject(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setDateOfPurchase(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setSellerName(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setSellerAddress(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setMaxPurcahsePrice(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setActualPurchasePrice(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setTargetSellPrice(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setSoldYesOrNo(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setDateOfSale(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setBuyerName(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setBuyerAddress(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setActualSellPrice(querryReadyResult.elementAt(i)); i++;		
		inventoryTest1.setFlagBoughtReport(querryReadyResult.elementAt(i)); i++;
		inventoryTest1.setFlagSoldReport(querryReadyResult.elementAt(i)); i++;		
  	} 
} 
