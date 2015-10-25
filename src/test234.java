
public class test234 {
	// A Binary Tree Node
	static class Node
	{
	    Node left, right;
	    int key;
	// Utility function to create a new tree Node
		Node(int key)
		{
		    this.key = key;
		    left = right = null;
		}
	}
	 
	// This function returns pointer to LCA of two given values n1 and n2.
	// v1 is set as true by this function if n1 is found
	// v2 is set as true by this function if n2 is found
	static Node findLCAUtil( Node root, int n1, int n2)
	{
	    // Base case
	    if (root == null) return null;
	 
	    // If either n1 or n2 matches with root's key, report the presence
	    // by setting v1 or v2 as true and return root (Note that if a key
	    // is ancestor of other, then the ancestor key becomes LCA)
	    if (root.key == n1)
	    {
	        v1 = true;
	        return root;
	    }
	    if (root.key == n2)
	    {
	        v2 = true;
	        return root;
	    }
	 
	    // Look for keys in left and right subtrees
	    Node left_lca  = findLCAUtil(root.left, n1, n2);
	    Node right_lca = findLCAUtil(root.right, n1, n2);
	 
	    // If both of the above calls return Non-NULL, then one key
	    // is present in once subtree and other is present in other,
	    // So this node is the LCA
	    if (left_lca!=null && right_lca!=null)  return root;
	 
	    // Otherwise check if left subtree or right subtree is LCA
	    return (left_lca != null)? left_lca: right_lca;
	}
	 
	// Returns true if key k is present in tree rooted with root
	static boolean find(Node root, int k)
	{
	    // Base Case
	    if (root == null)
	        return false;
	 
	    // If key is present at root, or in left subtree or right subtree,
	    // return true;
	    if (root.key == k || find(root.left, k) ||  find(root.right, k))
	        return true;
	 
	    // Else return false
	    return false;
	}
	 
	// This function returns LCA of n1 and n2 only if both n1 and n2 are present
	// in tree, otherwise returns NULL;
	static boolean v1 = false, v2 = false;
	static Node findLCA(Node root, int n1, int n2)
	{
	    // Initialize n1 and n2 as not visited
	   
	 
	    // Find lca of n1 and n2 using the technique discussed above
	    Node lca = findLCAUtil(root, n1, n2);
	 
	    // Return LCA only if both n1 and n2 are present in tree
	    if (v1 && v2 || v1 && find(lca, n2) || v2 && find(lca, n1))
	        return lca;
	 
	    // Else return NULL
	    return null;
	}
	 
	// Driver program to test above functions
	public static void main(String args[])
	{
	    // Let us create binary tree given in the above example
	    Node  root = new Node(1);
	    root.left = new Node(2);
	    root.right = new Node(3);
	    root.left.left = new Node(4);
	    root.left.right = new Node(5);
	    root.right.left = new Node(6);
	    root.right.right = new Node(7);
	    Node lca =  findLCA(root, 4, 5);
	    if (lca != null)
	       System.out.println("LCA(4, 5) = " + lca.key);
	    else
	    	System.out.println("Keys are not present ");
	    v1 = false;
	    v2 = false;
	    lca =  findLCA(root, 4, 10);
	    if (lca != null)
	    	System.out.println("\nLCA(4, 10) = " + lca.key);
	    else
	    	System.out.println("\nKeys are not present ");

	}
}
