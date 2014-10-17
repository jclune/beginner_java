
public class ThreadTest extends Thread{
	public static void main(String[] args){
		F f = new F();
		M m = new M();
		N n = new N();
		
		new Thread(f).start();
		new Thread(m).run();
		new Thread(n).run();
	}
}
