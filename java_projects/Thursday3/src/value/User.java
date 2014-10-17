package value;

import exception.NoNameException;

public class User {
	private String name;
	public User() throws NoNameException{
		throw new NoNameException("no name input");
	}
	public User(String name) throws NoNameException{
		if (name == null) throw new NoNameException("name is null");
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setName(String name) throws NoNameException{
		if (name == null) throw new NoNameException("name is null");
		this.name = name;
	}
	public void speak(){
		System.out.println(name);
	}
}
