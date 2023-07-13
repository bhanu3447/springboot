package Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class DaoClass 
{
  public static void main(String[] args) 
  {
	 try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/rev_db";
		String user="root";
		String pass="ROOT";
		
		Connection c = DriverManager.getConnection(url,user,pass);
		System.out.println("write the query");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		Statement statement = c.createStatement();
		boolean res = statement.execute(bufferedReader.readLine());
//		if(res)
//		{
//			ResultSet resultSet = statement.getResultSet();
//			while(resultSet.next())
//			{
//				System.out.println(resultSet.getInt(1));
//				System.out.println(resultSet.getString(2));
//				System.out.println(resultSet.getString(3));
//				System.out.println(resultSet.getString(4));
//				
//				System.out.println("-------------------------------");
//			}
//			
//		}
//		System.out.println("db operation successful");
//		
//		System.out.println(res);
//		c.close();
		
		if(res)
		{
			ResultSet resultSet = statement.getResultSet();
			 ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			while(resultSet.next())
			{
			for(int i=1;i<=columnCount;i++)
			 {
				System.out.println(metaData.getColumnLabel(i)+" of the employee "+resultSet.getObject(i));
				
			}
			System.out.println("--------------------------");
			}
			
		}
	} catch (ClassNotFoundException | SQLException | IOException e) {
		e.printStackTrace();
	}
  }
}
