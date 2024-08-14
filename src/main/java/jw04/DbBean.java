package jw04;
// W D 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbBean {

	// Field
	private String id;
	private String pwd;
	
	private String driverName = "oracle.jdbc.driver.OracleDriver";
	private String dburl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String dbuser = "scott";
	private String dbpwd = "tiger";

	
	// Constructor
	public DbBean() {
	}
	
	public DbBean(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}

	
	// Setter
	public void setId(String id) {
		this.id = id;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	// Method
	public boolean getUser() {
		
		/* DB */
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// DB Conn, PreparedStatement Open
		try {
			Class.forName(driverName);
	
			String sql = "SELECT id, pwd FROM users WHERE id=?";
	
			con = DriverManager.getConnection(dburl, dbuser, dbpwd);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			String fromDbPwd=null;
			
			if (rs.next()) {
				fromDbPwd = rs.getString("pwd");
				
				System.out.println("db에서 확인 한 id, pwd = "+id+" : "+fromDbPwd);
			} else {
				System.out.println(String.format("db에 <%s>에 해당하는 자료가 없습니다.", id));
			}
			
			if (fromDbPwd!=null && fromDbPwd.equals(pwd)) {
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				// DB Conn, PreparedStatement Close
				if (rs!=null) {
					rs.close();
				}
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				return false;
			}
		}
		
	}// method end
	
}
// class end
