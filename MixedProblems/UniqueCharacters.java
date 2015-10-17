import java.util.HashMap;
/* Find whether given string containes repeated characters.
 * 
 */
public class UniqueCharacters {
	public static void main(String[] args) {
		String s = "hello";
		boolean repeats = isRepeated(s);
		if (repeats) {
			System.out.println("String contains repeated characters.");
		} else {
			System.out.println("String contains unique characters.");
		}

	}

	public static boolean isRepeated(String str) {
		if (str.length() > 26) {
			return true;
		} else {
			HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
			for (int i = 0; i < str.length(); i++) {
				if (hmap.containsKey(str.charAt(i))) {
					return true;
				} else {
					hmap.put(str.charAt(i), 1);
				}
			}
		}
		return false;
	}
}