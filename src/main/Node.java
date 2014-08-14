package main;

public class Node implements Comparable<Node> {
	private Node left;
	private Node right;
	private int frequency;
	private byte value;
	
	public Node(byte value, int frequency, Node left, Node right)
	{
		this.value = value;
		this.frequency = frequency;
		this.left = left;
		this.right = right;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public byte getValue() {
		return value;
	}

	public void setValue(byte value) {
		this.value = value;
	}

	public boolean isLeaf()
	{
		return this.getRight() == null && this.getLeft() == null;
	}
	@Override
	public int compareTo(Node that) {
		return this.frequency - that.frequency;
	}
	
	public String toString() {
		return String.valueOf(value);
	}

}
