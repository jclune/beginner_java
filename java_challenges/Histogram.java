import java.util.Arrays;
import java.util.Collections;

public class Histogram{
	public static void main(String[] args){
		//the plot's x values are index values of args, y values are args
		int[] y = new int[args.length];
		int maxY = 0;
		for(int i=0; i < args.length; i++){
			y[i] = Integer.parseInt(args[i]);
			if (y[i] > maxY) maxY = y[i];
		}
		for(int row=0; row < maxY; row++){
			for(int i=0; i < y.length; i++){
				if (y[i] < (maxY - row)){ System.out.print(" ");
				} else System.out.print("*");
			}
			System.out.println("");
		}
	}
}
