// code by Justin Clune
import java.io.*;

public class Mottled{
        public static void main(String[] args){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("");
                System.out.println("---- 実行結果 ----");
                System.out.println("");

		try{
		int rows = 3;
		int diamonds = 7;
		int halflength = 4;

		System.out.println("how many rows of diamonds do you want? (enter 1 to 10 please)");
                String line = reader.readLine();
		int rowInput = Integer.parseInt(line);
		if (rowInput > 0 && rowInput <= 10) rows = rowInput;
                System.out.println("OK lets make "+ rows+" rows. How many collumns do you want? (enter 1 to 30 please)"); 
		String line2 = reader.readLine();
		int diamondsInput = Integer.parseInt(line2);
		if (diamondsInput > 0 && diamondsInput <= 30) diamonds = diamondsInput;
		System.out.println("OK lets make "+diamonds+" collumns! If you don't see diamonds, make your window wider please ->");               

                //r for row of diamonds
                for (int r = 1; r <= rows; r++ ){

                        //l for lines
                        int l;
                        for (l = 1 ; l <= halflength ; l++){

				//d for diamond collumn
				for(int d = 1; d <=diamonds; d++){

					//s for spaces
					for(int s = 1; s <= 4-l; s++){
					System.out.print(" ");
					}
					//a for asterics
					for(int a = 1; a <= l*2 - 1; a++){
						System.out.print("*");
					}
					for(int s = 1; s <= 4-l; s++){
						System.out.print(" ");
					}
				System.out.print(" "); 
				//end upper half of diamond
				}
                        System.out.println("");
			}

                        for (l = halflength - 1 ; l >= 1 ; l--){
                                //d for diamond collumn -lower half this time
				for (int d = 1; d<= diamonds; d++){

                                	//s for spaces
                                	for(int s = 1; s <= 4-l; s++){
                                      		 System.out.print(" ");
                                	}
                                	//a for asterics
                                	for(int a = 1; a <= l*2 - 1; a++){
                                        	System.out.print("*");
                                	}
                                	for(int s = 1; s <= 4-l; s++){
                                        	System.out.print(" ");
                                	}
                                System.out.print(" ");
				//end lower half of diamonds
				}
                        System.out.println("");
      			}
                }
		} catch(IOException e){
			System.out.println(e);
		} catch(NumberFormatException e){
			System.out.println("Not a number");
		}                               
        }
}
