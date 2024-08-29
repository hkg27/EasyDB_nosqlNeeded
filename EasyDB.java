import java.sql.*;
import java.util.*;
import java.util.Scanner;
public class EasyDB {

	public static void main(String[] args)  {
		int a=0;
		Scanner sc=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/";
		String x="";
		String sql="";
		System.out.println("Press 1 for Creating Database");
		System.out.println("Press 2 for delete Database");
		a=sc.nextInt();
		switch(a) {
		case 1:
			System.out.print("Enter database name");
			x=sc.next();
			sql="create Database "+x;

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,"root","Password@1");
				Statement st=con.createStatement();
				st.executeUpdate(sql);
					
				con.close();		
				}
			
			catch(Exception e)
			{e.printStackTrace();
				System.out.println(e);
			}
			break;
		case 2:
			System.out.print("Enter database name");
			x=sc.next();
			sql="drop Database "+x;

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,"root","Password@1");
				Statement st=con.createStatement();
				st.executeUpdate(sql);
					
				con.close();		
				}
			
			catch(Exception e)
			{e.getMessage();
				System.out.println(e);
			}
			break;
			
		}
    }
}