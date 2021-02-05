package com.bit2021.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.bit2021.mysite.exception.UserRepositoryException;
import com.bit2021.mysite.vo.UserVo;

@Repository
public class UserRepository {
	
	public boolean save(UserVo vo){
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			//연결하기
			connection = getConnection();
			
			// sql 준비
			String sql = "INSERT INTO user VALUES(null, ?, ?, password(?), ?, now())";
			pstmt = connection.prepareStatement(sql);
			
			// 바인딩
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());
			
			// sql 실행
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public UserVo findByEmailAndPassword(String email, String password) {
		UserVo result = null;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//연결하기
			connection = getConnection();
			
			// sql 준비
			String sql = "SELECT no, name FROM user WHERE email=? AND password=password(?)";
			pstmt = connection.prepareStatement(sql);
			
			// 바인딩
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			// sql 실행
			rs = pstmt.executeQuery();
			
			// 결과 가져오기
			if(rs.next()) {
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				
				result = new UserVo();
				result.setNo(no);
				result.setName(name);
			}
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	
	public UserVo findByNo(Long no) throws UserRepositoryException {
		UserVo result = null;
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//연결하기
			connection = getConnection();
			
			// sql 준비
			String sql = "SELECT no, name, email, gender FROM user WHERE no=?";
			pstmt = connection.prepareStatement(sql);
			
			// 바인딩
			pstmt.setLong(1, no);
			
			// sql 실행
			rs = pstmt.executeQuery();
			
			// 결과 가져오기
			if(rs.next()) {
				result = new UserVo();
				
				result.setNo(rs.getLong(1));
				result.setName(rs.getString(2));
				result.setEmail(rs.getString(3));
				result.setGender(rs.getString(4));

			}
		} catch (SQLException e) {
			throw new UserRepositoryException();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	private Connection getConnection() throws SQLException {
		Connection connection = null;
		
		try {
			// JDBC Driver
			Class.forName("org.mariadb.jdbc.Driver");

			// connection
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
		
		return connection;
	}

	public boolean update(UserVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			//연결하기
			connection = getConnection();
			
			// sql 준비
			String sql = "UPDATE user SET name=?, password=password(?), gender=? WHERE no=?";
			pstmt = connection.prepareStatement(sql);
			
			// 바인딩
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getGender());
			pstmt.setLong(4, vo.getNo());
			
			// sql 실행
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
		} catch (SQLException e) {
			System.out.println("error : " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
		
	}




}
