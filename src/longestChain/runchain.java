package longestChain;

public class runchain {
	public static void main(String args[]){
		chain chain=new chain();
		
		node root=new node(1);
		root.left=new node(2);
		root.right=new node(3);
		root.right.right=new node(4);
		root.left.left=new node(5);
		
		root.left.right = new node(6);
		root.left.right.right = new node(9);
		root.left.right.right.left = new node(11);
		root.left.right.right.right = new node(12);
		root.left.right.right.right.right= new node(15);
		root.left.left.left = new node(7);
		root.left.left.right = new node(8);
		root.left.left.right.left = new node(10);
		root.left.left.right.left.left = new node(13);
		root.left.left.right.left.right = new node(14);
		
		int t=chain.longestChain(root);
		System.out.println("MAX:" + chain.max);
		System.out.println("MAX2:" + t);
		
	}
}
