//Import required packages
import java.sql.*;
import java.util.*;

public class SQLConnector{
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost/LOO_database"; //Database URL
	private Connection connection; //manages connection
	private Statement statement;   //query statement
	private ResultSet resultSet;   //manages results
	private String sqlStatment;
	
	
	public SQLConnector(String sqlStamt){
		sqlStatment = sqlStamt;
	}
	
	public Vector executeSQL_Query(){
		Vector querryReadyResult = new Vector(0);
		try{
			////establish connection to database
			connection = DriverManager.getConnection(DATABASE_URL,"deitel","deitel");
			//create Statement for query database
			statement = connection.createStatement();
			//query database
			resultSet= statement.executeQuery(sqlStatment);			
			querryReadyResult = processQuerryResult(resultSet);			
		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		finally // ensure resultSet, statement and connection are closed
		{
			try
			{
				resultSet.close();
				statement.close();
				connection.close();
			} 
			catch ( Exception exception )
			{
			exception.printStackTrace();
			} 
		}
		return querryReadyResult;
	}
	
	public int executeSQL_Update(){
		int resultFlag = -1;
		try{
			////establish connection to database
			connection = DriverManager.getConnection(DATABASE_URL,"deitel","deitel");
			//create Statement for query database
			statement = connection.createStatement();
			//query database
			resultFlag = statement.executeUpdate(sqlStatment);						
		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		finally // ensure resultSet, statement and connection are closed
		{
			try
			{
				statement.close();
				connection.close();
			} 
			catch ( Exception exception )
			{
			exception.printStackTrace();
			} 
		}	
		return resultFlag;
	}
	
	public Vector processQuerryResult(ResultSet querryResultSet){
		Vector querryReadyResult = new Vector(0);
		try{
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColums = metaData.getColumnCount();
			while(querryResultSet.next()){
				for(int i=1; i <= numberOfColums; i++)
					querryReadyResult.add(querryResultSet.getObject(i));
			}
		}	
		catch ( Exception exception ){
			exception.printStackTrace();
		} 
		return querryReadyResult;
	}		
}