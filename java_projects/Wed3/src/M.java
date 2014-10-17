
public class M implements Runnable{
	public void run(){
		for (int i = 0;i < 100; i++){
			System.out.print(" M"+i);
		}
		System.out.println();
	}
}
