package ws;
 
import java.util.Arrays;
 
public class User {
    private String username;
    private Car[] c;
    public User(String username, Car[] c) {
        this.username = username;
        this.c = c;
    }
    @Override
    public String toString() {
        return "User [username=" + username + ", c=" + Arrays.toString(c) + "]";
    }
    
    
}
