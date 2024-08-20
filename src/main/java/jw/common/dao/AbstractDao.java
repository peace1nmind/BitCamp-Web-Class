package jw.common.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jw.common.util.DBUtil;

// W5 D21 13
/* 
 	공통, 일반적 사항을 추상화한, 공유목적의 추상 Dao
*/

public abstract class AbstractDao {

	// Field

	
	// Constructor
	public AbstractDao() {
	}

	
	// Method
	public Connection connect() {
		
		System.out.println("\npackage jw.common.dao.AbstractDao");
		System.out.println("new AbstractDao().connect() 실행\n");
		
		Connection con = null;
		
		try {
			con = DBUtil.getConnection();
			
		} catch (RuntimeException ex) {
			throw ex;
		}
		
		System.out.println("\nnew AbstractDao().connect() 종료\n");
		
		return con;
		
	}// connect() end
	
	
	public void close(Connection con, PreparedStatement pstmt) {
		
		System.out.println("\npackage jw.common.dao.AbstractDao");
		System.out.println("new AbstractDao().close(con, pstmt) 실행\n");
		
		if (pstmt != null) {
			try {
				System.out.println("pstmt.close()");
				pstmt.close();
				System.out.println("pstmt closed");
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}// pstmt close()
		
		if (con != null) {
			try {
				System.out.println("con.close()");
				con.close();
				System.out.println("con closed");
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}// con close()
		
		System.out.println("\nnew AbstractDao().close(con, pstmt) 종료\n");
		
	}// close(con, pstmt) end
	
	
	public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		
		System.out.println("\npackage jw.common.dao.AbstractDao");
		System.out.println("new AbstractDao().close(con, pstmt, rs) 실행\n");
		
		if (rs != null) {
			try {
				System.out.println("rs.close()");
				rs.close();
				System.out.println("rs closed");
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}// rs close()
		
		close(con, pstmt);
		
		System.out.println("\nnew AbstractDao().close(con, pstmt, rs) 종료\n");
		
	}// close(con, pstmt, rs) end
	
	
public void close(PreparedStatement pstmt, ResultSet rs) {
		
		System.out.println("\npackage jw.common.dao.AbstractDao");
		System.out.println("new AbstractDao().close(con, pstmt, rs) 실행\n");
		
		if (rs != null) {
			try {
				System.out.println("rs.close()");
				rs.close();
				System.out.println("rs closed");
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}// rs close()
		
		if (pstmt != null) {
			
			try {
				System.out.println("pstmt.close()");
				pstmt.close();
				System.out.println("rs closed");
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			}	
		}// pstmt close()
		
	}// close(pstmt, rs) end

}// class end
