package huffman;


public class Node implements Comparable<Node> {
	public Node left;
	public Node right;
	public int freq;
	public char letter;
	public final char static aChar = (char) 0x01;

	public Node() {
	}
	public Node(int freq) {
		this.freq = freq;
		this.letter = aChar;
	}
	public Node(char letter, int freq) {
		this.left = null;
		this.right = null;
		this.freq = freq;
		this.letter = letter;
	}
	@Override
	public String toString() {
		return this.letter + " => " + this.freq;
	}
	@Override
	public int compareTo(Node o) {
		if (this.freq > o.freq) {
			return 1;
		} else if (this.freq < o.freq) {
			return -1;
		}
		return 0;
	}
}
