package db2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

	public static void main(String[] args) {
		// 1. JDBC Driver Loading..	
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");  //자동으로 오라클에 접속하는 프로그램으로 바뀐다
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
					e.printStackTrace();  // 모든error를 print 하겠다
				}
				
				// 3. SQL 전송
				String sql="INSERT INTO T_PRODUCT VALUES (?,?,?,SYSDATE)";  //여기선 세미콜론 찍지않는다 , 뭐가들어갈지모르니 물음표로 표시
				PreparedStatement pstmt = null;  //pre + ctrl + space 자동완성
				try {
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "id21");
					pstmt.setString(2, "pwd20");
					pstmt.setInt(3, 1000);
					
					
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
