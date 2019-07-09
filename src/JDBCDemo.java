import java.sql.*;
import java.util.*;

public class JDBCDemo {
	public static void main(String args[]) {
		try {

			Scanner scanner = new Scanner(System.in);
			// Oracle Class.forName("oracle.jdbc.driver.OracleDriver");
			// Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521","uname","Sapient123");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Emp", "root", "Sapient123");
			Statement stmt = con.createStatement();

			// stmt.executeUpdate("insert into Emp values('sang',25)");
			// stmt.executeUpdate("delete from Emp where age=26");
			// stmt.executeUpdate("update Emp set age=age+1");

			// Prepared statement-More secure
			PreparedStatement pstmt = con.prepareStatement("insert into Emp values(?,?)");
			System.out.println("Enter Name: ");
			String name = scanner.nextLine();
			System.out.println("Enter Age: ");
			int age = scanner.nextInt();
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.execute();

			ResultSet rs = stmt.executeQuery("select * from Emp");
			while (rs.next())
			{
				System.out.println("Name: " + rs.getString(1));// can give column name also
				System.out.println("Age: " + rs.getString(2));
				System.out.println();
			}
			rs.close();
			stmt.close();
			pstmt.close();
			con.close();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}