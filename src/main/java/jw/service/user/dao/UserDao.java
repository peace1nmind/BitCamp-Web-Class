package jw.service.user.dao;
// W5 D21 12

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
		System.out.println("new UserDao().getUser(userVO) ����\n");
		
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
				System.out.println("UserDao ���� Ȯ�� �� id, pwd = "+userVO.getId()+" : "+userVO.getPwd());
				System.out.println();
				
				userVO.setActive(true);
				
			} else {
				System.out.println(String.format("db�� id= <%s>, pwd= <%s> �� �ش��ϴ� �ڷᰡ �����ϴ�.", userVO.getId(), userVO.getPwd()));
				System.out.println();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			close(con, pstmt, rs);
				
		}
		
		System.out.println("\nnew UserDao().getUser(userVO) ����\n");
		
	}// method end
	
	
	public boolean addUser(UserVO userVO){
		Connection con = null;
		PreparedStatement pStmt = null;
		boolean insertResult   = false;
		
		try{		
			//1�ܰ� connection
			con = this.connect();
			
			//2�ܰ� statement 
			pStmt = con.prepareStatement("INSERT INTO users ( no, id, pwd) " +
										"VALUES( ? , ? , ? )");
			
			pStmt.setInt(1,userVO.getNo());
			pStmt.setString(2,userVO.getId());
			pStmt.setString(3,userVO.getPwd());

			//3�ܰ� ����� Ȯ���ϱ�
			if( 1 == pStmt.executeUpdate()){    
				insertResult = true;
			}
		}catch(Exception e){		
			e.printStackTrace();
		}finally{
			this.close(con,pStmt);
		}
		
		return insertResult; 
		
	}//end of addUser()
	
	
	public List<UserVO> getUserList() {
		
		System.out.println("\npackage jw.service.user.dao.UserDao");
		System.out.println("=> new UserDao().getUserList() ����\n");
		
		List<UserVO> userList = new ArrayList<UserVO>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = connect();
			
			String sql = "SELECT * FROM users ORDER BY no";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("������ SQL �� : "+sql);
			System.out.println("executeQuery()");
			
			while (rs.next()) {
				UserVO userVO = new UserVO(rs.getInt(1), rs.getString(2), rs.getString(3));
				System.out.println(userVO);
				
				userList.add(userVO);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			close(con, pstmt, rs);
			
		}
		
		System.out.println("\n<= new UserDao().getUserList() ����\n");
		
		return userList;
	}
	
}
// class end
