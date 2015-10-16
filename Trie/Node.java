import java.util.Arrays;

public class Node {
	public Node[] characters;
	public int setSize;
	
	public Node(int size) {
		setSize = size;
		characters = new Node[setSize];
		Arrays.fill(characters, null);
	}
}
