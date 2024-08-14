package jw04;
// W D 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jw.common.pool.OracleConnectionPool;

public class UserPoolDao {

	// Field
//	private String driverName = "oracle.jdbc.driver.OracleDriver";
//	private String dburl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//	private String dbuser = "scott";
//	private String dbpwd = "tiger";

	
	// Constructor
	public UserPoolDao() {
	}
	

	// Method
	public void getUser(UserVO userVO) {
		
		/* DB */
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
//			Class.forName(driverName);
//			con = DriverManager.getConnection(dburl, dbuser, dbpwd);
			
			// DB Conn, PreparedStatement Open
			con = OracleConnectionPool.getInstance().getConnection();

			pstmt = con.prepareStatement("SELECT id, pwd FROM users WHERE id=? AND pwd=?");
			
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
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				// DB Conn, PreparedStatement Close
				if (rs != null) {
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
