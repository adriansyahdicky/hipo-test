package com.hitopia;

import java.util.Stack;

public class BalancedBrackets {
	public static void main(String[] args) {
		String input1 = "{[()]}";
		String input2 = "{[(])}";
		String input3 = "{(([])[])[]}";

		System.out.println(isBalanced(input1)); // Output: YES
		System.out.println(isBalanced(input2)); // Output: NO
		System.out.println(isBalanced(input3)); // Output: YES
	}

	public static String isBalanced(String s) {
		Stack<Character> stack = new Stack<>();

		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {
				if (stack.isEmpty()) {
					return "NO";
				}
				char top = stack.pop();
				if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')) {
					return "NO";
				}
			}
		}
		return stack.isEmpty() ? "YES" : "NO";
	}
}
