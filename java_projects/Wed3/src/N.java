
public class N implements Runnable{
	public void run(){
		for (int i = 0;i < 100; i++){
			System.out.print(" N"+i);
		}
		System.out.println();
	}
}
