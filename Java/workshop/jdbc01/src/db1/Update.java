package db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {

	public static void main(String[] args) {
		
		// 1. JDBC Driver Loading..	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  //�ڵ����� ����Ŭ�� �����ϴ� ���α׷����� �ٲ��
		} catch (ClassNotFoundException e) {

			System.out.println("Driver Loading Error");
		}
		
		// 2. Connection 1521 db2 db2
		String id = "db2";
		String password = "db2";
		String url=
				"jdbc:oracle:thin:@70.12.50.235:1521:xe";  //70.12.50.235 ip config
		
		Connection con =null;
		try {
			con = DriverManager.getConnection(url, id, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Connection Error");
			e.printStackTrace();  // ���error�� print �ϰڴ�
		}
		
		// 3. SQL ����
		String sql="UPDATE T_USER SET PWD=?,NAME=? WHERE ID=?";  //���⼱ �����ݷ� �����ʴ´� , ���������𸣴� ����ǥ�� ǥ��
		PreparedStatement pstmt = null;  //pre + ctrl + space �ڵ��ϼ�
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "0000");  //? ������� 1,2,3,...
			pstmt.setString(2, "������");
			pstmt.setString(3, "id02");
			int result = pstmt.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		// 4. close
		try {
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
}