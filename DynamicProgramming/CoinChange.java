
public class CoinChange {
	public static void main(String[] args) {
		int value = 6;
		System.out.println("Number of ways : " + coinChange(value,5));
	}
	
	public static int coinChange(int v,int den) {
		if (v == 0) return 1;
		int next_den = 0;
		switch(den) {
			case 5 : next_den = 2; break;
			case 2 : next_den = 1; break;
			case 1 : return 1;
		}
		int ways = 0;
		for (int i = 0; i *den <= v; i++ ) {
			ways += coinChange(v-i*den,next_den);
		}
		return ways;
	}
}
