package com.study.firstSelect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
	2020.07.20 11:48 ���ε�
	���DB����Ŭ
	DB����Ȯ�ο���
*/
public class FirstJava {//jdbc���� Ȯ��-oracle����
	public static void main(String[] args) {
		System.out.println("jdbc����...�ѱ۱��� omg");
		//jdbc �������
		/*
		  �����۾� odbcj.jar�߰�
		  1.jdbc�����ε�
		  	class.forName()
		  	Ŭ���� ��ü�ε�
		  	��ǻ���� ����
		  	������ ����: �������� ����
		  	��Ÿ�� ����: ������ ������ ������ ���� ���۽� ���� �����ϴ°�
		  	
		 */
		try {//������ ���� ��ü�� ����(�ѹ� ������)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.�����ͺ��̽� �����ϱ� -> Connection ��ü�� ���Ͽ� ����
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String userId="c##scott";//oracle 21c�����̶� �������� c##...
			String userPw="�����";
			
			Connection conn=DriverManager.getConnection(url, userId, userPw);
			if(conn!=null) {
				System.err.println("���Ἲ��");
				conn.close();
			} else {
				System.err.println("�������");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.err.println("��������");
			e.printStackTrace();
		} catch(SQLException se) {
			System.err.println("������ ���̽� ����");
			se.printStackTrace();
		}
	}
}