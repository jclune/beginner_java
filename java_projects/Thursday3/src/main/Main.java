package main;

import exception.NoNameException;
import value.User;

public class Main {

	public static void main(String[] args) {
		try{
		User u1 = new User(null);
		u1.speak();
		}catch(NoNameException e){
			//System.out.println(e);
			e.printStackTrace();
		}
		try {
			User u2 = new User("justin");
			u2.setName(null);
		} catch (NoNameException e) {
			e.printStackTrace();
		}
	}
}
