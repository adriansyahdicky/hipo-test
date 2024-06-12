package com.hitopia;

public class HighestPalindrome {
	public static void main(String[] args) {
		String s1 = "3943";
		int k1 = 1;
		System.out.println(getHighestPalindrome(s1, k1)); // Output: 3993

		String s2 = "932239";
		int k2 = 2;
		System.out.println(getHighestPalindrome(s2, k2)); // Output: 992299
	}

	public static String getHighestPalindrome(String s, int k) {
		char[] arr = s.toCharArray();
		int n = arr.length;

		int neededChanges = countChangesToMakePalindrome(arr, 0, n - 1, 0);
		if (neededChanges > k) {
			return "-1";
		}

		makePalindrome(arr, 0, n - 1, k);
		maximizePalindrome(arr, 0, n - 1, k);

		return new String(arr);
	}

	private static int countChangesToMakePalindrome(char[] arr, int left, int right, int count) {
		if (left >= right) {
			return count;
		}
		if (arr[left] != arr[right]) {
			count++;
		}
		return countChangesToMakePalindrome(arr, left + 1, right - 1, count);
	}

	private static void makePalindrome(char[] arr, int left, int right, int k) {
		if (left >= right) {
			return;
		}
		if (arr[left] != arr[right]) {
			char maxChar = (char) Math.max(arr[left], arr[right]);
			arr[left] = maxChar;
			arr[right] = maxChar;
			k--;
		}
		makePalindrome(arr, left + 1, right - 1, k);
	}

	private static void maximizePalindrome(char[] arr, int left, int right, int k) {
		if (left > right || k <= 0) {
			return;
		}
		if (arr[left] == arr[right]) {
			if (arr[left] != '9' && k >= 2) {
				arr[left] = '9';
				arr[right] = '9';
				k -= 2;
			}
		} else {
			char maxChar = (char) Math.max(arr[left], arr[right]);
			if (maxChar != '9' && k > 0) {
				arr[left] = '9';
				arr[right] = '9';
				k--;
			}
		}
		maximizePalindrome(arr, left + 1, right - 1, k);
	}
}
