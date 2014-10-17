public class Diamond{
        public static void main(String[] args){
                System.out.println("");
                System.out.println("---- 実行結果 ----");
                System.out.println("");
                int i;
                for (i = 1; i <= 6; i++ ){
			for (int s = 0 ; s < 7-i ; s++){
				System.out.print(" ");
			}
                        for (int j = 0; j < 2*i-1; j++){
                                System.out.print("*");
                        }
                        System.out.println("");
                }
                for (; i > 0; i--){
			for (int s = 0; s < 7-i ; s++){
				System.out.print(" ");
			}
                        for (int j = 0; j < 2*i-1; j++){
                                System.out.print("*");
                        }
                        System.out.println("");
                }
                System.out.println("");
        }
}
