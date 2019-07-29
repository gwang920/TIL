package db3;

public class UserDB extends DB<User, String> { // DB<int> x DB<integer> o

	@Override
	public void insert(User obj) {
		System.out.println(obj.getId()+ " "+obj.getName()+" Inserted");
	}

	@Override
	public User select(String obj) {
		
		return null;
	}
	
	
}
