public class Tool2{
	public static int intSum(int a, int b){
		return (a + b);
	}
	public static int printReturn(String a){
		System.out.println(a);
		return 0;
	}
	public static void printStrInt(String str, int integ){
		System.out.println(str+integ);
	}
	public static void helloWorld(){
		System.out.println("Hello World!");
	}
	public static String doubleToStr(double a){
		return String.valueOf(a);
	}
	public static double divide(double a, double b){
		return a / b;
	}
	public static void printJustin(){
		System.out.println("Justin");
	}
	public static boolean isZero(int a){
		return (a == 0);
	}
	public static double rectArea(double a, double b){
		return a*b;
	}
	public static double triangleArea(double a, double b){
		return 0.5*a*b;
	}
	public static String concatChar(char a, char b){
		return String.valueOf(a) + String.valueOf(b);
	}
	public static int groupSixty(int a){
		if(a < 300) return 5;
		else if(a < 1000) return 15;
		else if(a < 5000) return 30;
		else return 50;
	}
	public static boolean isLeap(int year){
		if ((year % 4)==0){
                	if((year % 100) != 0 || (year % 400) == 0){return true;
                        }else{
				return false;
                        } 
		}else{
			return false; 
		}
	}
}
