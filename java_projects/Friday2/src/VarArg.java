public class VarArg {

	public static void main(String[] args) {
		int[] ns = { 4, 1, 9, 10, 8, 5, 2, 1, 5 };

		//int maxValue = method1(ns);
		//int maxValue = method1(4, 1, 9, 10, 8, 5, 2, 1, 5);

		//int maxValue = method2(ns);
		int maxValue = method2(4, 1, 9, 10, 8, 5, 2, 1, 5);

		System.out.println(maxValue);
	}

	public static int method1(int[] nums) {
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (max < nums[i]) {
				max = nums[i];
			}
		}
		return max;
	}

	public static int method2(int... nums) {
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (max < nums[i]) {
				max = nums[i];
			}
		}
		return max;
	}
}