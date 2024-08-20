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
	// DBMS 접속 정보로 Connection 생성 메서드
	public static Connection getConnection(String driverClassName,String url,
											String id, String password) {
		
		System.out.println("\npackage jw.common.util.DBUtil");
		System.out.println("DBUtil.getConnection(driverClassName, url, id, password) 실행\n");
		
		Connection con = null;
		
		try {
			System.out.println("driverClassName : "+driverClassName);
			Class.forName(driverClassName);
			
			System.out.println(String.format("url= %s, id= %s, password= %s", url, id, password));
			con = DriverManager.getConnection(url, id, password);
			
			System.out.println("DB Connection Success");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("DB 접속시 오류 발생 : " + e);
			
		}
		
		System.out.println("\nDBUtil.getConnection(driverClassName, url, id, password) 종료\\n");
		
		return con;
		
	}// getConnection() end
	
	// DataSource 이용 Connection 생성 메서드
	public static Connection getConnection() {
		
		System.out.println("\npackage jw.common.util.DBUtil");
		System.out.println("DBUtil.getConnection() 실행\n");
		
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
			// DataSource Connection return 받지 못하더라도 Connection 생성하여 return
			if (con == null) {
				System.out.println("Datasource.getConnection() Fail");
				
				con = getConnection("oracle.jdbc.driver.OracleDriver",
									"jdbc:oracle:thin:@127.0.0.1:1521:xe",
									"scott", "tiger");
			}
			
		}
		
		System.out.println("\nDBUtil.getConnection() 종료\n");
		
		return con;
		
	}// getConnection() end

}// class end
