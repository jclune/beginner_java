public class Triangle{
	public static void main(String[] args){
		System.out.println("");
		System.out.println("---- 実行結果 ----");
	
		int i;
		for (i = 0; i < 10; i++ ){
			for (int j = 0; j < i; j++){
				System.out.print("*");
			}
			System.out.println("");
		}
		for (; i > 0; i--){
                        for (int j = 0; j < i; j++){
                                System.out.print("*");
                        }
                        System.out.println("");
		}
		System.out.println("");
	}
}
