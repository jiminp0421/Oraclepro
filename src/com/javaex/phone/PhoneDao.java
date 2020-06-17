package com.javaex.phone; //다오에는 println이 없으면 안됨

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class PhoneDao {
	
	//필드
	
	private	Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "phonedb";
	private String pw = "phonedb";
	
	//생성자
	
	public PhoneDao() {
	}
	//g/s
	//메소드
	//일반메소드
	//connection 가져오기
	private void getConnect() {
		try {
		// 1. JDBC 드라이버 (Oracle) 로딩
		Class.forName(driver);
		// 2. Connection 얻어오기
		conn = DriverManager.getConnection(url, id, pw);
		//접속성공삭제
		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		}
		
	}//getConnect끝
	
	public void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		
	}//close끝
		
	
	//SELECT
	public List<PersonVo> getPersonList() {
		   List<PersonVo> personList = new ArrayList<PersonVo>();
		
		getConnect();
		

		try {
		   
		    // 3. SQL문 준비 / 바인딩 / 실행
		    String query = "";
		    query +="SELECT	person_id, ";
		    query +="		name, ";
		    query +="		hp, ";
		    query +="		company ";
		    query +=" FROM phone";	
		 
		    System.out.println(query);
		    
		    //바인딩
		    pstmt = conn.prepareStatement(query);
		    
		    //실행
		    rs = pstmt.executeQuery();
		    // 4.결과처리
		    while (rs.next()) {
		    	int personId = rs.getInt("person_id");
		    	String Name = rs.getString("name");
		    	String Hp = rs.getString("hp");
		    	String Company = rs.getString("company");
		    	
		    	PersonVo personVo = new PersonVo(personId, Name, Hp, Company);
		    	personList.add(personVo);
		    }
		    
		
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} 

			close();
		
			return personList;

		
	}//SELECT END
	
	
	
	//INSERT
	public void phoneInsert(String Name, String Hp, String Company) {
	
		getConnect();
		int count = 0;
		//추가
		try {
		   
			// 3. SQL문 준비 / 바인딩 / 실행
			String query = ""; // 쿼리문 문자열만들기, ? 주의
		    query += "	INSERT INTO phone ";
		    query += "	VALUES (seq_person_id.nextval, ?, ?, ?)";
		    pstmt = conn.prepareStatement(query);
			
		    //바인딩
		    pstmt.setString(1, Name);
		    pstmt.setString(2, Hp);
		    pstmt.setString(3, Company);
		    
		    //실행
		    count = pstmt.executeUpdate();
		    // 4.결과처리
		    

		
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} 

			close();
	
	
	}//INSERT END
	
	//UPDATE
	public void phoneUpdate(int personId, String Name, String Hp, String Company) {

		getConnect();
		int count = 0;
		try {
		    
		    // 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query +=" update phone ";
			query +=" set name = ?, ";
			query +="	  hp = ?, ";
			query +="	  company = ? ";
			query +="where person_id = ? ";
			
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, Name);
			pstmt.setString(2, Hp);
			pstmt.setString(3, Company);
			pstmt.setInt(4, personId);
			
			count = pstmt.executeUpdate();

		    // 4.결과처리
			
			
		
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		}

			close();

		
	}//UPDATE END
	

	//DELETE
	public void phoneDelete(int personId) {

		getConnect();
		int count = 0;
		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			String query = "";
			query +=" delete from phone ";
			query +=" where person_id = ? ";
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, personId);
			
			count = pstmt.executeUpdate();
			// 4.결과처리
			
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

			close();
		
	}// DELETE END

	
	
	//검색
	//정보수정
	
		
	
	

}//class

