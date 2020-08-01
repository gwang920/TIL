# Hive Java Connection

##### java 연동을 위한 Hive Setting

```
hive> hive --service hiveserver2

입력
```

##### Java Setting

```java
package hive;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Hive {

           public static void main(String[]args) throws Exception {
        
                     Class.forName("org.apache.hive.jdbc.HiveDriver");

                    Connection conn =
                   DriverManager.getConnection("jdbc:hive2://70.12.114.201:10000/default","","");

                     Statement stmt =conn.createStatement();

                     ResultSet rs = stmt.executeQuery("SELECT * FROM hdi");

                        while(rs.next()) {
                          System.out.println(rs.getString(1));
                        }
                     conn.close();
                     System.out.println("Success....");
           }
}

```

