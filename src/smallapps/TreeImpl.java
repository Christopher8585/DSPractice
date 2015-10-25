package smallapps;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class TreeImpl {
	// Check if the tree is balanced
	public static boolean isBalanced(Tree t) {
		System.out.print(maxDepth(t));
		System.out.print(minDepth(t));
		return (maxDepth(t) - minDepth(t)) <= 1;
	}

	public static int maxDepth(Tree t) {
		if (t == null)
			return 0;

		return Math.max(maxDepth(t.left), maxDepth(t.right)) + 1;
	}

	public static int minDepth(Tree t) {
		if (t == null)
			return 0;

		return Math.min(minDepth(t.left), minDepth(t.right)) + 1;
	}

	// Create MinBST of sorted array
	public static Tree createMinBST(int[] array) {
		return addBST(array, 0, array.length - 1);
	}

	public static Tree addBST(int[] a, int start, int end) {

		if (start > end)
			return null;

		Tree t;
		int mid = (start + end) / 2;
		t = new Tree(a[mid]);
		t.left = addBST(a, start, mid - 1);
		t.right = addBST(a, mid + 1, end);

		return t;
	}

	public static void inOrder(Tree t) {
		if (t == null)
			return;

		inOrder(t.left);
		System.out.print(t.value);
		inOrder(t.right);

	}

	public static ArrayList<LinkedList<Tree>> getDepthNodes(Tree t) {
		ArrayList<LinkedList<Tree>> allLists = new ArrayList<LinkedList<Tree>>();
		LinkedList<Tree> list = new LinkedList<Tree>();
		list.add(t);
		int level = 0;
		allLists.add(level, list);

		while (true) {
			list = new LinkedList<Tree>();
			for (int i = 0; i <= allLists.get(level).size() - 1; i++) {
				Tree tree = allLists.get(level).get(i);
				if (tree != null) {
					if (tree.left != null)
						list.add(tree.left);
					if (tree.right != null)
						list.add(tree.right);
				}
			}

			if (list.size() > 0) {
				allLists.add(++level, list);
			} else
				break;

		}
		return allLists;
	}

	public static Tree nextNode(Tree t) {
		if (t == null)
			return null;
		Tree next;
		if (t.parent == null && t.right != null) {
			next = (leftTraverse(t.right));
		} else
			while ((next = t.parent) != null) {
				if (next.left == t)
					break;
				else
					t = next;
			}

		return next;
	}

	public static Tree leftTraverse(Tree t) {
		if (t == null)
			return null;
		while (t.left != null) {
			t = t.left;
		}
		return t;
	}

	// Slower way
	public static Tree findCommonAncestor(Tree root, Tree t1, Tree t2) {

		if (covers(root.left, t1) && covers(root.left, t2))
			return findCommonAncestor(root.left, t1, t2);
		if (covers(root.right, t1) && covers(root.right, t2))
			return findCommonAncestor(root.right, t1, t2);

		return root;
	}

	public static boolean covers(Tree root, Tree t1) {
		if (root == null)
			return false;
		if (root == t1)
			return true;
		return (covers(root.left, t1) || covers(root.right, t1));
	}

	// Faster way
	static int Two_Nodes = 2;
	static int One_Node = 1;
	static int No_Node = 0;

	public static Tree commonAncestor(Tree root, Tree t1, Tree t2) {
		if (t1 == t2 && (root.left == t1 || root.right == t1))
			return root;

		int leftnodes = countNodes(root.left, t1, t2);
		if (leftnodes == Two_Nodes)
			if (root.left == t1 || root.left == t2)
				return root.left;
			else
				return commonAncestor(root.left, t1, t2);
		else if (leftnodes == One_Node)
			if (root == t1)
				return t1;
			else if (root == t2)
				return t2;

		int rightnodes = countNodes(root.right, t1, t2);
		if (rightnodes == Two_Nodes)
			if (root.right == t1 || root.right == t2)
				return root.right;
			else
				return commonAncestor(root.right, t1, t2);
		else if (rightnodes == One_Node)
			if (root == t1)
				return t1;
			else if (root == t2)
				return t2;

		if (leftnodes == One_Node && rightnodes == One_Node)
			return root;
		return null;
	}

	private static int countNodes(Tree root, Tree t1, Tree t2) {
		int count = No_Node;

		if (root == null)
			return count;

		if (root == t1 || root == t2)
			count += 1;

		count += countNodes(root.left, t1, t2);

		if (count == Two_Nodes)
			return count;

		return count + countNodes(root.right, t1, t2);
	}

	// One tree is subtree of another
	public static boolean contain(Tree t1, Tree t2) {
		if (t2 == null)
			return true;
		return searchRoot(t1, t2);
	}

	private static boolean searchRoot(Tree t1, Tree t2) {
		if (t1 == null)
			return false;
		if (t1.value == t2.value)
			if (subTree(t1, t2))
				return true;

		return (searchRoot(t1.left, t2) || searchRoot(t1.right, t2));
	}

	private static boolean subTree(Tree t1, Tree t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;
		if (t1.value != t2.value)
			return false;

		return (subTree(t1.left, t2.left) && subTree(t1.right, t2.right));
	}

	public static void pathsToSum(Tree t, int sum, int level,
			ArrayList<Integer> buffer) {
		if (t == null)
			return;
		buffer.add(t.value);
		int tmp = sum;
		for (int i = level; i > -1; i--) {
			tmp -= buffer.get(i);
			if (tmp == 0)
				printBuffer(buffer, i, level);
		}

		pathsToSum(t.left, sum, level + 1, (ArrayList<Integer>)buffer.clone());
		pathsToSum(t.right, sum, level + 1, (ArrayList<Integer>)buffer.clone());

	}

	private static void printBuffer(ArrayList<Integer> buffer, int level,
			int level2) {
		for (int i = level; i <= level2; i++)
			System.out.print("  " + buffer.get(i));

		System.out.println();
	}

	public static void morrisTraversal(Tree t) {
		Tree current = t;
		while (current != null) {
			if (current.left == null) {
				System.out.println(current.value);
				current = current.right;
			} else {
				Tree prev = current.left;
				while (prev.right != null && prev.right != current)
					prev = prev.right;

				if (prev.right == null) {
					prev.right = current;
					current = current.left;
				} else {
					prev.right = null;
					System.out.println(current.value);
					current = current.right;
				}

			}

		}
	}

	public static void maxSumFromRootToLeaf(Tree root) {
		Tree t = maxSum(root, 0, new Tree());
		printRootToLeaf(root, t);
	}

	private static boolean printRootToLeaf(Tree root, Tree leaf) {
		if (root == null)
			return false;
		else if (root == leaf || printRootToLeaf(root.left, leaf)
				|| printRootToLeaf(root.right, leaf)) {
			System.out.print(" -> " + root.value);
			return true;
		}

		return false;
	}

	static int max = 0;

	private static Tree maxSum(Tree node, int sum, Tree leaf) {
		if (node == null)
			return null;
		else {
			sum = sum + node.value;

			if (node.right == null && node.left == null) {
				if (sum > max) {
					max = sum;
					leaf = node;
					System.out.println(sum);
				}
			} else {
				leaf = maxSum(node.left, sum, leaf);
				leaf = maxSum(node.right, sum, leaf);
			}
		}
		return leaf;
	}

	public static void zigzag(Tree root) {
		boolean leftToRight = false;
		Stack<Tree> s1 = new Stack<>();
		Stack<Tree> s2 = new Stack<>();
		s1.add(root);
		while (!s1.isEmpty()) {
			Tree t = s1.pop();
			if (t != null) {
				System.out.print(" " + t.value);
				if (leftToRight) {
					s2.add(t.left);
					s2.add(t.right);
				} else {
					s2.add(t.right);
					s2.add(t.left);
				}
			}
			if (s1.isEmpty()) {
				System.out.println();
				leftToRight = !leftToRight;
				s1=s2;
				s2= new Stack<>();
			}
		}
	}

	public static void printLRmost(Tree t) {
		if (t != null) {
			Stack<Tree> s = new Stack<Tree>();
			s.add(t);
			while (!s.isEmpty()) {
				Stack<Tree> tmp = new Stack<Tree>();
				Tree left, right;
				if (s.size() == 1) {
					right = left = s.pop();

				} else {
					right = s.pop();

					while (s.size() > 1) {
						tmp = add(s.pop(), tmp);
					}

					left = s.pop();
					tmp = add(left, tmp);

				}
				tmp = add(right, tmp);
				s = tmp;
				System.out.print(left.value + "  " + right.value);
				System.out.println();
			}
		}
	}

	private static Stack<Tree> add(Tree t, Stack<Tree> tmp) {
		if (t.left != null)
			tmp.add(t.left);
		if (t.right != null)
			tmp.add(t.right);

		return tmp;
	}
	
	//Print all nodes at distance k from a given node
	public static void printNodesDown(Tree root,int k){
		if(root==null || k<0)return;
		if(k==0){
			System.out.print(root.value + " ");
			return;
		}
		printNodesDown(root.left, k-1);
		printNodesDown(root.right, k-1);
	}
	
	public static int printKDistanceNodes(Tree node, Tree target, int k){
		if(node==null)return -1;
		if(node==target){
			printNodesDown(node, k);
			return 0;
		}
		int dl=printKDistanceNodes(node.left, target, k);
		if(dl!=-1){
			if(dl+1==k){
				System.out.print(node.value+" ");
			}
			else {
				printNodesDown(node.right,k-dl-2);
			}
		return dl+1;
		}
		
		int dr=printKDistanceNodes(node.right, target, k);
		if(dr!=-1){
			if(dr+1==k)
				System.out.print(node.value+" ");
			else
				printNodesDown(node.left, k-dr-2);
		return dr+1;
		}
		
		return -1;
	
	}

	public static void main(String args[]) {
		/*
		 * 5 3 7 1 4 6 8
		 */
		
		Tree t = new Tree(20);
		t.left = new Tree(8);
		t.right = new Tree(22);
		t.left.right = new Tree(12);
		t.left.left = new Tree(100);
		t.left.right.left = new Tree(10);
		t.left.right.right = new Tree(14);
		zigzag(t);
		printLRmost(t);
		//Tree target=t.left.right;
		//printKDistanceNodes(t, target, 1);
		 
		//printLRmost(t);
		 //maxSumFromRootToLeaf(t);
		// System.out.println("  " +max);
		/*
		  Tree t=new Tree(5);
		  t.left=new Tree(2);
		  t.right=new Tree(7);
		  t.left.right=new Tree(3);
		  t.left.left=new Tree(1); 
		  t.right.left=new Tree(6);
		  t.right.right=new Tree(8);
		  morrisTraversal(t);
		  */
		 /*
		 * 
		 * //Check for balanced tree Tree t=new Tree(1); t.left=new Tree(2);
		 * t.right=new Tree(4); t.left.right=new Tree(3); t.left.left=new
		 * Tree(3); t.right.left=new Tree(3); t.right.right=new Tree(3);
		 * t.right.right.right=new Tree(3); //t.right.right.right.=new Tree(3);
		 * // System.out.print(isBalanced(t));
		 * 
		 * 
		 * Tree t=new Tree(5); t.left=new Tree(3); t.left.parent=t; t.right=new
		 * Tree(7); t.right.parent=t;
		 * 
		 * t.left.right=new Tree(4); t.left.right.parent=t.left; t.left.left=new
		 * Tree(2); t.left.left.parent=t.left;
		 * 
		 * System.out.print(nextNode(t.left.right).value);
		 */
		// int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// Tree t = createMinBST(a);
		// inOrder(t);

		// inOrder(t);
		// System.out.println(commonAncestor(t, t.right.right.right,
		// t.right.left).value);

		/*
		 Tree t=new Tree(3); 
		 t.left=new Tree(1); 
		 t.left.parent=t; 
		 t.right=new
		 Tree(2); t.right.parent=t;
		  
		  t.left.right=new Tree(4); t.left.right.parent=t.left; t.left.left=new
		  Tree(3); t.left.left.parent=t.left;
		 
		  pathsToSum(t, 4, 0, new ArrayList<Integer>());
		 */
		/*
		 * ArrayList<LinkedList<Tree>> lists=getDepthNodes(t);
		 * 
		 * for (int i = 0; i <= lists.size() - 1; i++){ for (int j = 0; j <=
		 * lists.get(i).size() - 1; j++){ Tree tree=lists.get(i).get(j);
		 * System.out.print(tree.value); } System.out.println(); }
		 */
	}

}
