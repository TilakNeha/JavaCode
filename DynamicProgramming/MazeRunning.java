
public class MazeRunning {
	public static void main(String[] args) {
		int LEN = 3;
		int HGT = 2;
		int ways = countWays(0, 0, LEN, HGT);
		System.out.println("Number of ways :" + ways);

		int[][] mat = { { 1, 2, 3 }, { 4, 6, 5 }, { 3, 2, 1 } };
		int costWays = countCostWays(mat, 0, 0, 12, 3, 3);
		System.out.println("Number of ways :" + costWays);
	}

	public static int countWays(int x, int y, int len, int hgt) {
		if (x == len - 1 && y == hgt - 1)
			return 1;
		if (x < len - 1 && y < hgt - 1)
			return countWays(x + 1, y, len, hgt) + countWays(x, y + 1, len, hgt);
		if (x < len - 1)
			return countWays(x + 1, y, len, hgt);
		if (y < hgt - 1)
			return countWays(x, y + 1, len, hgt);
		return -1;
	}

	/*Given a matrix where every cell has some number of coins. 
	 * Count number of ways to reach bottom right from top left with exactly k coins.
	 */
	private static int countCostWays(int[][] mat, int x, int y, int val, int len, int hgt) {
		if (x == len - 1 && y == hgt - 1) {
			if (mat[x][y] == val) {
				return 1;
			}
			return 0;
		}
		if (x < len - 1 && y < hgt - 1)
			return countCostWays(mat,x + 1, y,val-mat[x][y], len, hgt) + countCostWays(mat,x, y+1,val-mat[x][y], len, hgt);
		if (x < len - 1)
			return countCostWays(mat,x + 1, y,val-mat[x][y], len, hgt);
		if (y < hgt - 1)
			return countCostWays(mat,x, y + 1,val-mat[x][y], len, hgt);
		return -1;
	}
}
