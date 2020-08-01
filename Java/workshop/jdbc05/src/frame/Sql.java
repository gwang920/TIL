package frame;

public class Sql {
	public static String insertProduct = "INSERT INTO T_PRODUCT VALUES (?,?,?,?,?,?,?,?)";
	public static String deleteProduct = "DELETE FROM T_PRODUCT WHERE PDNO = ?";
	public static String updateProduct = "UPDATE T_PRODUCT SET PDMOUNT=? WHERE PDNO=?";
	public static String selectProduct = "SELECT * FROM T_PRODUCT WHERE PDNO = ?";
	public static String selectAllProduct = "SELECT * FROM T_PRODUCT";
	public static String insertFactory = "INSERT INTO T_FACTORY VALUES (?,?,?)";
	public static String deleteFactory = "DELETE FROM T_FACTORY WHERE FACTNO = ?";
	public static String updateFactory = "UPDATE T_FACTORY SET FACLOC=? WHERE FACTNO=?";
	public static String selectFactory = "SELECT * FROM T_FACTORY WHERE FACTNO = ?";
	public static String selectAllFactory = "SELECT * FROM T_FACTORY";
}
