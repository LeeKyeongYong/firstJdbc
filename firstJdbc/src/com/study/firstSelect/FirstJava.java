package com.study.firstSelect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
	2020.07.20 11:48 업로드
	사용DB오라클
	DB접속확인여부
*/
public class FirstJava {//jdbc연결 확인-oracle버전
	public static void main(String[] args) {
		System.out.println("jdbc시작...한글깨짐 omg");
		//jdbc 연결순서
		/*
		  선행작업 odbcj.jar추가
		  1.jdbc동적로딩
		  	class.forName()
		  	클래스 자체로딩
		  	컴퓨터의 오류
		  	컴파일 오류: 문법적인 오류
		  	런타임 오류: 문법상 문제가 없지만 실제 동작시 오류 포함하는것
		  	
		 */
		try {//무조건 실행 자체를 해줌(한번 무조건)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.데이터베이스 연결하기 -> Connection 객체를 통하여 연결
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String userId="c##scott";//oracle 21c버전이라 계정명이 c##...
			String userPw="블라블라";
			
			Connection conn=DriverManager.getConnection(url, userId, userPw);
			if(conn!=null) {
				System.err.println("연결성공");
				conn.close();
			} else {
				System.err.println("연결실패");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.err.println("동적오류");
			e.printStackTrace();
		} catch(SQLException se) {
			System.err.println("데이터 베이스 오류");
			se.printStackTrace();
		}
	}
}