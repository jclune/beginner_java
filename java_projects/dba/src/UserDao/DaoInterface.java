package UserDao;

public interface DaoInterface {
	public int truncate();
	public int insert(User user);
	public User login(String nameInput, String passInput);
}
