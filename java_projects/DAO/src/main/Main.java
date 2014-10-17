package main;
import java.util.List;

import jp.co.ca.dao.UserDao;
import jp.co.ca.dao.UserDaoImpl;
import jp.co.ca.entity.User;

/**
 * DAOを使用した簡単なサンプルです。
 * 
 * @author t.matsumoto
 *
 */
public class Main {

	/**
	 * サンプルプログラムのエントリポイントです。
	 * 
	 * @param args 使用されません
	 */
	public static void main(String[] args) {
		
		try {
			UserDao dao = new UserDaoImpl();
			
			//findByIdの動作確認
			User user1 = dao.findById(2);
			printUser(user1);
//			
//			// updateの動作確認
			user1.setName(user1.getName() + "b");
			dao.update(user1);
			
			user1 = dao.findById(2);
			printUser(user1); //=> nameが変わってる
			
			
			// insertの動作確認
			User user = new User();
			user.setName("clune18");
			user.setTel("09011112222");
			user.setPasswd("223");
			
			System.out.println("before: " + user.getId()); //=> 0
			dao.insert(user);
			System.out.println("after: " + user.getId()); //=> 挿入後のID(insertメソッドの中で設定される)
			
			
			// deleteの動作確認
			dao.delete(14);
			
			
			List<User> list = dao.findAll();
			
			for (User u : list) {
				printUser(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void printUser(User user) {
		System.out.println(user.getId() + ":" + user.getName() + ":" + user.getTel() + ":" + user.getPasswd());
	}
}

