import java.io.*;
public class PlaceSum{
	public static void main(String[] args){
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			System.out.println("3桁の数値を入力してください。");
			String line = reader.readLine();
			int sum = 0;

			for(int i = 0; i < line.length(); i++){
				//System.out.println("heres a digit: "+line.substring(i,i+1));
				sum = sum + Integer.parseInt(line.substring(i,i+1));
			}
			System.out.print("sum of digits: "+sum);
			if (Integer.parseInt(line) % 3 == 0){
				System.out.print(" and it's divisible by 3");
			}
			if (Integer.parseInt(line) % 9 == 0){
				System.out.print(" and it's dividible by 9!");
			}
			System.out.println("");

		} catch(IOException e){
                        System.out.println("error: "+e);
                } catch(NumberFormatException e){
                        System.out.print("数字の形式が正しくありません");
                }
	}
}
