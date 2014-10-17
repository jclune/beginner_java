
public class ExceptionTest {
	public static void main(String[] args){
		int[] arry = new int[3];
		
		try{
			if(false) throw new HogeException("Hoge monster");
		}catch(HogeException e){
			System.out.println("error: "+e);
		}finally{
			System.out.println("I finally print no matter what");
		}
		
		//myAssign(arry, 100, 5);
		/*try {
			myAssign(arry, 100, 5);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("error "+e);
			//e.printStackTrace();
		}*/
	}
	static void myAssign(int[] arr, int index, int value) throws ArrayIndexOutOfBoundsException{
		System.out.println("myAssign before");
		arr[index] = value;
		System.out.println("myAssign after");
	}
}
