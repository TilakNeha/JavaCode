/*
 * A child is running up a staircase with n steps, and can hop either 1 step, 2 steps, or
3 steps at a time. Implement a method to count how many possible ways the child
can run up the stairs
 */
public class Staircase {
	public static void main(String[] args) {
		int steps = 4;
		System.out.println("Number of ways : " + countWays(steps));
	}
	
	public static int countWays(int steps) {
		if (steps == 0) return 1;
		
		if (steps >= 3) {
			return countWays(steps-3) + countWays(steps-2) + countWays(steps-1); 
		}
		
		if (steps >= 2) {
			return countWays(steps-2) + countWays(steps-1); 
		}
		
		if (steps >= 1) {
			return countWays(steps-1); 
		}
		
		return 0;
	}
}
