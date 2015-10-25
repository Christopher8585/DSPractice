package Huffman;

public class Node implements Comparable<Node>{
	
	int freq;
	char c;
	Node left,right;
	
	Node(int f,char c,Node left, Node right){
		this.freq=f;
		this.c=c;
		this.left=left;
		this.right=right;
	}
	
	boolean isLeaf(){
		return this.left==null && this.right==null;
	}

	@Override
	public int compareTo(Node o) {
		return this.freq-o.freq;
	}
	
}
