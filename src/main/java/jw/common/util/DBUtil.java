package jw.common.util;
// W5 D21 14

import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBUtil {

	// Field

	// Constructor
	public DBUtil() {
	}

	// Method
	// DBMS ���� ������ Connection ���� �޼���
	public static Connection getConnection(String driverClassName,String url,
											String id, String password) {
		
		System.out.println("\npackage jw.common.util.DBUtil");
		System.out.println("DBUtil.getConnection(driverClassName, url, id, password) ����\n");
		
		Connection con = null;
		
		try {
			System.out.println("driverClassName : "+driverClassName);
			Class.forName(driverClassName);
			
			System.out.println(String.format("url= %s, id= %s, password= %s", url, id, password));
			con = DriverManager.getConnection(url, id, password);
			
			System.out.println("DB Connection Success");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB ���ӽ� ���� �߻� : " + e);
			
		}
		
		System.out.println("\nDBUtil.getConnection(driverClassName, url, id, password) ����\\n");
		
		return con;
		
	}// getConnection() end
	
	// DataSource �̿� Connection ���� �޼���
	public static Connection getConnection() {
		
		System.out.println("\npackage jw.common.util.DBUtil");
		System.out.println("DBUtil.getConnection() ����\n");
		
		Connection con = null;
		
		try {
			System.out.println("Create InitialContext Instance");
			InitialContext ic = new InitialContext();
			
			System.out.println("Get DataSource");
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/ora");
			
			System.out.println("DataSource.getConnection()");
			con = ds.getConnection();
			
			System.out.print("DB Connection Success");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			// DataSource Connection return ���� ���ϴ��� Connection �����Ͽ� return
			if (con == null) {
				System.out.println("Datasource.getConnection() Fail");
				
				con = getConnection("oracle.jdbc.driver.OracleDriver",
									"jdbc:oracle:thin:@127.0.0.1:1521:xe",
									"scott", "tiger");
			}
			
		}
		
		System.out.println("\nDBUtil.getConnection() ����\n");
		
		return con;
		
	}// getConnection() end

}// class end
