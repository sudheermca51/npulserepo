package org.iitwf.hc.nexuspulse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ConnectionManager {
	private static String url = "jdbc:mysql://localhost:3306/nexusplulse_db";    
	private static String driverName = "com.mysql.cj.jdbc.Driver";   
	private static String username = "root";   
	private static String password = "Welcome123#";
	private static Connection con;
	private static String[][] inputArr;
	/*
	 * 	<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.21</version>
		</dependency>
	 */
	@Test(dataProvider = "test")
	public void verifyData(String patientID,String patientName,String appointmentID,String doctorID) {
		System.out.println("Hello DataProvider");
		System.out.println(patientID +"::"+ patientName +"::"+ doctorID);
	}
 
	@DataProvider(name = "test")
	public String[][] readDataFromDB()  {
		try {
			System.out.println("Driver Loading..." + driverName);
			Class.forName(driverName);
			try {
				//Create a connection to DB by passing Url,Username,Password as parameters
				con = DriverManager.getConnection(url, username, password);
				Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				
				//Executing the Queries
				//stmt.executeUpdate("INSERT INTO mmp.patient_data VALUES (5,'Alexander','18-07-1986')");
				//stmt.executeUpdate("truncate table testDB.employee");
				ResultSet rs = stmt.executeQuery("SELECT * FROM nexusplulse_db.patient_info");
			 
				int rows = rs.getRow();
				System.out.println("Number of rows in the table: " + rows);
				
				
				rs.last();
				rows = rs.getRow();
				System.out.println("Number of rows in the table after calling last() method: " + rows);
				 
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
				int cols = rsmd.getColumnCount();
				System.out.println(rows +"--" + cols);
				
				inputArr= new String[rows][cols];
 
				int i =0;
				rs.beforeFirst();
				//Iterating the data in the Table
				while (rs.next())
				{
					for(int j=0;j<cols;j++)
					{
						inputArr[i][j]=rs.getString(j+1);
						System.out.print("values:: " + inputArr[i][j]);
						//" +":::"+i +":::"+j); 
						// rs.updateRow(); 
					}
					System.out.println();
					i++;
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println("Failed to create the database connection."); 
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			System.out.println("Driver not found."); 
		}
 	return inputArr;
 
	}
}
