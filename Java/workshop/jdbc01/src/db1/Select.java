package db1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {

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
		
		// 3. SQL ���� & Receive
		String sql="SELECT * FROM T_USER WHERE ID=?";  //���⼱ �����ݷ� �����ʴ´� , ���������𸣴� ����ǥ�� ǥ��
		PreparedStatement pstmt = null;  //pre + ctrl + space �ڵ��ϼ�
		ResultSet rset = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "id02");
			rset = pstmt.executeQuery();
			rset.next();
			String uid = rset.getString("ID");   //column ��Ī
			String upwd = rset.getString("PWD");   //column ��Ī
			String uname = rset.getString("NAME");   //column ��Ī
			System.out.println(uid + " "+upwd+" "+uname);
			
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
