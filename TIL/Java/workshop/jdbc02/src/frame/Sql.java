package frame;

public class Sql {
	public static String insertUser
	= "INSERT INTO T_USER VALUES (?,?,?)";
	public static String DeleteUser
	= "DELETE FROM T_USER WHERE ID = ?";
	public static String UpdateUser
	= "UPDATE T_USER SET PWD=?,NAME=? WHERE ID=?";
	public static String SelectUser
	= "SELECT * FROM T_USER WHERE ID = ?";
	public static String SelectAllUser
	= "SELECT * FROM T_USER";
}
