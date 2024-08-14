package jw04;
// W D 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserInitParamDao {

	// Field
	private String jdbcDriver;
	private String jdbcURL;
	private String jdbcUser;
	private String jdbcPassword;

	
	// Constructor
	public UserInitParamDao() {
	}

	public UserInitParamDao(String jdbcDriver, String jdbcURL, String jdbcUser, String jdbcPassword) {
		super();
		this.jdbcDriver = jdbcDriver;
		this.jdbcURL = jdbcURL;
		this.jdbcUser = jdbcUser;
		this.jdbcPassword = jdbcPassword;
	}


	// Method
	public void getUser(UserVO userVO) {
		
		/* DB */
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// DB Conn, PreparedStatement Open
		try {
			Class.forName(jdbcDriver);
	
			String sql = "SELECT id, pwd FROM users WHERE id=? AND pwd=?";
//			String sql = "SELECT id, pwd FROM users WHERE id=?";
	
			con = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userVO.getId());
			pstmt.setString(2, userVO.getPwd());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("db���� Ȯ�� �� id, pwd = "+userVO.getId()+" : "+userVO.getPwd());
//				if (userVO.getPwd().equals(rs.getString("pwd"))) {
//					System.out.println("�α��� ����");
//					userVO.setActive(true);
//				} else {
//					System.out.println(String.format("db�� id : OK, pwd= <%s>�� �ش��ϴ� �ڷᰡ �����ϴ�.", userVO.getPwd()));
//				}
				
				userVO.setActive(true);
			} else {
				System.out.println(String.format("db�� id= <%s>, pwd= <%s> �� �ش��ϴ� �ڷᰡ �����ϴ�.", userVO.getId(), userVO.getPwd()));
//				System.out.println(String.format("db�� id= <%s>�� �ش��ϴ� �ڷᰡ �����ϴ�.", userVO.getId()));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
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
				
			}
		}
		
	}// method end
	
	
	// Setter
	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}

	public void setJdbcURL(String jdbcURL) {
		this.jdbcURL = jdbcURL;
	}

	public void setJdbcUser(String jdbcUser) {
		this.jdbcUser = jdbcUser;
	}

	public void setJdbcPassword(String jdbcPassword) {
		this.jdbcPassword = jdbcPassword;
	}
	
}
// class end 
