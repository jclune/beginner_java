public class Tool2Test{
	public static void main(String[] args){
		System.out.println("Test  1: Tool2.intSum(1, 2) = "+Tool2.intSum(1,2));

               	System.out.println("Test  2: Tool2.printReturn(\"printing a string\")");
		int test2 = Tool2.printReturn("printing a string");
                System.out.println("Test  2: return is = "+test2);

                System.out.println("Test  3: Tool2.printStrInt(\"string\",10)");
		Tool2.printStrInt("string",10);

		System.out.println("Test  4: Tool2.helloWorld()");
		Tool2.helloWorld();
	
		System.out.println("Test  5: Tool2.doubleToStr(10.0) = "+Tool2.doubleToStr(10.0));
		if(Tool2.doubleToStr(10.0) instanceof String) System.out.println("10.0 type is string");

		System.out.println("Test  6: Tool2.divide(10.0, 3.0) = "+Tool2.divide(10.0, 3.0));
		
                System.out.println("Test  7: Tool2.printJustin()");
                Tool2.printJustin();

		System.out.println("Test  8: Tool2.isZero(0) = "+Tool2.isZero(0));
                System.out.println("Test  8: Tool2.isZero(1) = "+Tool2.isZero(1));

                System.out.println("Test  9: Tool2.rectArea(2.0, 5.0) = "+Tool2.rectArea(2.0,5.0));

                System.out.println("Test 10: Tool2.triangleArea(2.0, 5.0) = "+Tool2.triangleArea(2.0,5.0));
                System.out.println("Test 11: Tool2.concatChar('a', 'b') = "+Tool2.concatChar('a','b'));	
		if(Tool2.concatChar('a', 'b') instanceof String) System.out.println("ab type is string");

		System.out.println("Test 12: Tool2.groupSixty(299) = "+Tool2.groupSixty(299));
                System.out.println("Test 12: Tool2.groupSixty(999) = "+Tool2.groupSixty(499));
                System.out.println("Test 12: Tool2.groupSixty(4999) = "+Tool2.groupSixty(4999));
                System.out.println("Test 12: Tool2.groupSixty(5000) = "+Tool2.groupSixty(5000));

		System.out.println("Test 13: Tool2.isLeap(2012) = "+Tool2.isLeap(2012));
                System.out.println("Test 13: Tool2.isLeap(2013) = "+Tool2.isLeap(2013));
	}
}
