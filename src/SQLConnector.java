//Import required packages
import java.sql.*;
import java.util.*;

public class SQLConnector{

	private Connection connection; //manages connection
	private Statement statement;   //query statement
	private ResultSet resultSet;   //manages results
	private String sqlStatement;
	
	
	public SQLConnector(String sqlStamt){
		sqlStatement = sqlStamt;
	}
	
	public Vector executeSQL_Query(){
		Vector queryReadyResult = new Vector(0);
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "LOO_database";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "password";

		try{

            Class.forName(driver).newInstance(); //creates connector

			////establish connection to database
			connection = DriverManager.getConnection(url + dbName,userName,password);
			//create Statement for query database
			statement = connection.createStatement();
			//query database
			resultSet= statement.executeQuery(sqlStatement);
			queryReadyResult = processQueryResult(resultSet);
		}
		catch(Exception sqlException)
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
		return queryReadyResult;
	}
	
	public int executeSQL_Update(){
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "LOO_database";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "password";
		int resultFlag = -1;
		try{
			////establish connection to database
			connection = DriverManager.getConnection(url + dbName,userName,password);
			//create Statement for query database
			statement = connection.createStatement();
			//query database
			resultFlag = statement.executeUpdate(sqlStatement);
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
	
	public Vector processQueryResult(ResultSet queryResultSet){
		Vector queryReadyResult = new Vector(0);
		try{
			ResultSetMetaData metaData = resultSet.getMetaData();
			int numberOfColums = metaData.getColumnCount();
			while(queryResultSet.next()){
				for(int i=1; i <= numberOfColums; i++)
					queryReadyResult.add(queryResultSet.getObject(i));
			}
		}	
		catch ( Exception exception ){
			exception.printStackTrace();
		} 
		return queryReadyResult;
	}		
}