import java.util.Stack;

public class InOrder {

	public static void inOrderTraversal(Node root) {
		// Inorder traversal:
		// Keep the nodes in the path that are waiting to be visited
		Stack s = new Stack();
		// The first node to be visited is the leftmost
		Node node = root;
		while (node != null) {
			s.push(node);
			node = node.left;
		}
		// Traverse the tree
		while (s.size() > 0) {
			// Visit the top node
			node = (Node) s.pop();
			System.out.println( node.data);
			// Find the next node
			if (node.right != null) {
				node = node.right;
				// The next node to be visited is the leftmost
				while (node != null) {
					s.push(node);
					node = node.left;
				}
			}
		}
	}
	
	public static void main(String args[]){
		Node root=new Node(10);
		root.left=new Node(5);
		root.right=new Node (12);
		root.left.left=new Node(3);
		root.left.right=new Node(7);
		inOrderTraversal(root);
	}

}
