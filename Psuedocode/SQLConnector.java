//This class has the attributes to perform operation in a SQL Database
//As well as methods to establish a connection to the SQL Database
public class SQLConnector{
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost/LOO_database"; //Database URL
	private Connection connection; //manages connection
	private Statement statement;   //query statement
	private ResultSet resultSet;   //manages results
	private String sqlStatment;
	
	//Desc: 1 argument constructor, SQL Statement
	//Pre:  Requires a legal SQL statement from the calling class 	
	//Post: A SQLConnector Object is created ready to execute an SQL command 
	public SQLConnector(String sqlStamt){
		sqlStatment = sqlStamt;
	}
	
	//Desc:    Establishes a connection with the SQL database and retrieves Data from it	
	//Returns: Returns a Vector containing the requested data, 
	// 		   vector is empty if the query result is empty

	public Vector executeSQL_Query(String sqlQuery){
			//prepare vector result
			Vector querryReadyResult = new Vector(0)
			////establish connection to database
			connection = DriverManager.getConnection(DATABASE_URL,"OO","password")
			//create Statement for query database
			statement = connection.createStatement()
			//query database
			resultSet= statement.executeQuery(sqlQuery)
			//process resultSet, convert from ResultSet to Vector
			querryReadyResult = processQuerryResult(resultSet)		
			//close resultSet, statement, and connection
			resultSet.close()
			statement.close()
			connection.close()
			//return resulting vector
			return querryReadyResult
	}

	//Desc:    Establishes a connection with the SQL database and executes UPDATE, INSERT or DELETE
	//		   statements to the database
	//Returns: Returns -1 for a failed update, the row count for SQL Data Manipulation Language 
	//		   (DML) statements or 0 for SQL statements that return nothing

	public int executeSQL_Update(String sqlUpdate){
			int resultFlag = -1
			////establish connection to database
			connection = DriverManager.getConnection(DATABASE_URL,"OO","password")
			//create Statement for query database
			statement = connection.createStatement()
			//query database
			resultFlag = statement.executeUpdate(sqlUpdate)
			//close resultSet, statement, and connection
			resultSet.close()
			statement.close()
			connection.close()
			return resultFlag
	}

	//Desc:    Converts a ResultSet object in to a Vector containing all elements of the ResultSet Object
	//Pre:     The input is a ResultSet object from a SQL query
	//Returns: Returns a Vector containing all the elements originally contained in the ResultSet object

	public Vector processQuerryResult(ResultSet querryResultSet){
		//prepare Vector result
		Vector querryReadyResult = new Vector(0)
		//extract metaData
		ResultSetMetaData metaData = resultSet.getMetaData()
		//extract column Count
		int numberOfColums = metaData.getColumnCount()
		//loop through ResultSet object to extract elements wanted
		while(querryResultSet.next()){
			for(int i=1; i <= numberOfColums; i++)
				querryReadyResult.add(querryResultSet.getObject(i))
		}
		//return Resulting Vector
		return querryReadyResult
	}
}	