package jw.service.user.dao;
// W5 D21 12

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jw.common.dao.AbstractDao;
import jw.service.user.vo.UserVO;

public class UserDao extends AbstractDao {

	// Field
	
	
	// Constructor
	public UserDao() {
	}
	

	// Method
	public void getUser(UserVO userVO) {
		
		System.out.println("\npackage jw.service.user.dao.UserDao");
		System.out.println("new UserDao().getUser(userVO) 실행\n");
		
		/* DB */
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {			
			// DB Conn, PreparedStatement Open
			con = connect();
			
			System.out.println("con.prepareStatement(sql)");
			pstmt = con.prepareStatement("SELECT id, pwd FROM users WHERE id=? AND pwd=?");
			
			System.out.println("pstmt.setString(index, value)");
			pstmt.setString(1, userVO.getId());
			pstmt.setString(2, userVO.getPwd());
			
			System.out.println("pstmt.executeQuery()");
			rs = pstmt.executeQuery();
			
			
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
			close(con, pstmt, rs);
				
		}
		
		System.out.println("\nnew UserDao().getUser(userVO) 종료\n");
		
	}// method end
	
}
// class end
