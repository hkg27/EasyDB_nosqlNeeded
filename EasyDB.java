import java.sql.*;
import java.util.*;
import java.util.Scanner;
public class Wa {

	public static void main(String[] args)  {
		int a=0;
		Scanner sc=new Scanner(System.in);
		String url="jdbc:mysql://localhost:3306/";
		int n=0;
		String x="";
		String sql="";
		System.out.println("Press 1 for Creating Database");
		System.out.println("Press 2 for delete Database");
		System.out.println("Press 3 for create a Table ");
		a=sc.nextInt();
		switch(a) {
		case 1:
			System.out.println("Enter database name");
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
			System.out.println("Enter database name");
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
		case 3:
			System.out.println(" enter the database name in which you want to create the table");
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection(url,"root","Password@1");
				Statement st=con.createStatement();
				ResultSet s=st.executeQuery("show databases");
				System.out.println("List of databases");
				while(s.next()) {
					System.out.println(s.getString(1));
				}
				
					
				con.close();		}
			
			catch(Exception e)
			{e.printStackTrace();
				System.out.println(e);
			}
			x=sc.next();
			url=url+" "+x;
			
			System.out.println("Enter Table name(so  int)");
			x=sc.next();
			sql="create table "+x +" (";
			System.out.println("Enter the no of columns in table ");
			n=sc.nextInt();
			for(int i =0;i<n;i++)
			{
				System.out.println("Enter column name");
				x=sc.next();
				sql =sql+x +" ";
				System.out.println("Enter column datatype");
				x=sc.next();
				sql =sql+x ;
				System.out.println("Enter  datatype size");
				x=sc.next();
				sql =sql +"("+x+")" +" ";
				System.out.println(sql);
				if(i==n-1) {
					sql=sql+")";
				}
				else
					sql=sql+",";
			}
			
			

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
		}
		
		
	}

}
