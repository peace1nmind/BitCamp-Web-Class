package jw04;
// W D 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

	// Field
	private String driverName = "oracle.jdbc.driver.OracleDriver";
	private String dburl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String dbuser = "scott";
	private String dbpwd = "tiger";

	
	// Constructor
	public UserDao() {
	}
	

	// Method
	public void getUser(UserVO userVO) {
		
		/* DB */
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		// DB Conn, PreparedStatement Open
		try {
			Class.forName(driverName);
	
//			String sql = "SELECT id, pwd FROM users WHERE id=? AND pwd=?";
			String sql = "SELECT id, pwd FROM users WHERE id=?";
	
			con = DriverManager.getConnection(dburl, dbuser, dbpwd);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userVO.getId());
//			pstmt.setString(2, userVO.getPwd());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println("db���� Ȯ�� �� id, pwd = "+userVO.getId()+" : "+userVO.getPwd());
				if (userVO.getPwd().equals(rs.getString("pwd"))) {
					System.out.println("�α��� ����");
					userVO.setActive(true);
				} else {
					System.out.println(String.format("db�� id : OK, pwd= <%s>�� �ش��ϴ� �ڷᰡ �����ϴ�.", userVO.getPwd()));
				}
				
//				userVO.setActive(true);
			} else {
				System.out.println(String.format("db�� id= <%s>�� �ش��ϴ� �ڷᰡ �����ϴ�.", userVO.getId()));
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
	
}
// class end
