
public class UserTest {

	public static void main(String[] args) {
		User u1 = new User("A");
		User u2 = new User("B");
		u1.count = 10;
		u2.count = 20;
		System.out.println(u1.name+" has count "+u1.count);
		System.out.println(u2.name+" has count "+u2.count);		
	}

}
