
public class Periodic {
	public static void main(String[] args) throws InterruptedException{
		for (int i =0; i <10; i++){
			int tm = i*1000;
			Thread.currentThread().setPriority(10);
			Thread.currentThread().setName("justin");
			
			System.out.println("Start slepp with tm="+tm+" for "+Thread.currentThread());
			/*
			try{
				Thread.sleep(tm);;
			}catch(InterruptedException e){	
				System.out.print("interrupted!");
			}
			*/
			Thread.sleep(tm);
		}
	}
}
