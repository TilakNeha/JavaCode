import java.util.Stack;

/*
 * For a given postfix expression, find the answer
 * Eg : ab+c* = (a+b) * c
 */
public class PostfixNotation {

	public static void main(String[] args) {
		// Assume only single digit numbers.
		String postfix = "12+3*5+7/"; // Ans : 2

		int ans = solvePostfix(postfix);

		System.out.println("Solution is : " + ans);
	}

	private static int solvePostfix(String postfix) {
		Stack<Integer> s = new Stack<Integer>();
		for (char c : postfix.toCharArray()) {
			int d = 0;
			if (c == '+' || c == '-' || c == '/' || c == '*') {
				int b = s.pop();
				int a = s.pop();
				
				switch (c) {
				case '+':
					d = a + b;
					break;
				case '-':
					d = a - b;
					break;
				case '*':
					d = a * b;
					break;
				case '/':
					d = a / b;
					break;
				}
				s.push(d);
			} else {
				String temp = c + "";
				s.push(Integer.parseInt(temp));
			}
		}
		return s.pop();
	}
}
