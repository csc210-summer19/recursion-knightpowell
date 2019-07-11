/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Samuel Bryant
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 1) {
			return n;
		}
		if (n == k) {
			return 1;
		}
		return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {

		String result = intWithCommasHelper(n, 1, 1000);

		return result;
	}

	private String intWithCommasHelper(int n, double counter, double countCheck) {
		if (n == 0) {
			return "";
		} else {
			int quotient = n / 10;
			int remainder = n % 10;
			String numberRemainder = "";
			if (remainder == 0)
				numberRemainder = "0";
			if (remainder == 1)
				numberRemainder = "1";
			if (remainder == 2)
				numberRemainder = "2";
			if (remainder == 3)
				numberRemainder = "3";
			if (remainder == 4)
				numberRemainder = "4";
			if (remainder == 5)
				numberRemainder = "5";
			if (remainder == 6)
				numberRemainder = "6";
			if (remainder == 7)
				numberRemainder = "7";
			if (remainder == 8)
				numberRemainder = "8";
			if (remainder == 9)
				numberRemainder = "9";

			if (counter == countCheck) {
				numberRemainder = numberRemainder + ",";
				countCheck *= 1000;
			}

			return intWithCommasHelper(quotient, counter * 10, countCheck) + numberRemainder;

		}

	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length);

	}

	private void reverseArray(int[] x, int index, int len) {
		int mid = len / 2;
		if (index == mid) {
			return;
		} else {

			int temp = x[index];
			x[index] = x[len - index - 1];
			x[len - index - 1] = temp;

		}
		reverseArray(x, index + 1, len);

	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		int min = a[0];
		int max = a[0];
		int tempResult = 0;
		int result = arrayRangeHelper(min, max, tempResult, a, 0, a.length);
		return result;

	}

	private int arrayRangeHelper(int min, int max, int tempResult, int[] a, int index, int len) {

		if (index == len) {
			return tempResult;
		} else {
			if (a[index] < min) {
				min = a[index];
			}
			if (a[index] > max) {
				max = a[index];
			}
		}
		if ((max - min) > tempResult) {
			tempResult = max - min;
		}
		return arrayRangeHelper(min, max, tempResult, a, index + 1, len);
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		boolean sorted = isSortedHelper(nums, 0);
		return sorted;
	}

	private boolean isSortedHelper(int[] nums, int index) {

		if (nums.length == 0 || nums.length == 1) {
			return true;
		}
		if (index != nums.length - 1) {

			if (nums[index] > nums[index + 1]) {
				return false;
			} else {
				return isSortedHelper(nums, index += 1);
			}
		} else {
			return true;
		}
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		boolean located = false;
		return foundHelper(search, strs, 0, located);
	}

	private boolean foundHelper(String search, String[] strs, int index, boolean located) {
		if (strs.length == 0) {
			return false;
		}
		if (index == strs.length) {
			return located;
		} else {
			if (strs[index].equals(search)) {
				located = true;
				return located;
			} else {
				located = false;
			}
			return foundHelper(search, strs, index += 1, located);
		}
	}
}
