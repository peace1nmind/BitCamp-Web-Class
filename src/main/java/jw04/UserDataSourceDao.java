package jw04;
// W D 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDataSourceDao {

	// Field
	
	// Constructor
	public UserDataSourceDao() {
	}
	

	// Method
	public void getUser(UserVO userVO) {
		
		/* DB */
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {			
			// DB Conn, PreparedStatement Open
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/ora");
			con = ds.getConnection();
			
			System.out.println("getConnection()\n");

			pstmt = con.prepareStatement("SELECT id, pwd FROM users WHERE id=? AND pwd=?");
			
			pstmt.setString(1, userVO.getId());
			pstmt.setString(2, userVO.getPwd());
			
			rs = pstmt.executeQuery();
			System.out.println("ExecuteQeury()\n");
			
			if (rs.next()) {
				System.out.println("UserDao 에서 확인 한 id, pwd = "+userVO.getId()+" : "+userVO.getPwd());
				System.out.println();
				
				userVO.setActive(true);
				
			} else {
				System.out.println(String.format("db에 id= <%s>, pwd= <%s> 에 해당하는 자료가 없습니다.", userVO.getId(), userVO.getPwd()));
				System.out.println();
				
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
