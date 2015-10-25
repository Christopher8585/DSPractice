package longestChain;

public class chain {

	int max(int a, int b){
		return a>b? a:b;
	}
	
	int maxDepth(node root){
		if(root==null)
			return 0;
		return 1 + max(maxDepth(root.left),maxDepth(root.right));
	}
	
	int max=0;
	int longestChain(node root){
		
		if(root==null)
			return 0;
		
		int leftdepth=0,rightdepth=0;
		
		longestChain(root.left);
		longestChain(root.right);
		
		leftdepth=maxDepth(root.left);
		rightdepth=maxDepth(root.right);
		
		int local=1+leftdepth+rightdepth;
		if(local>max)
			max=local;
		
		return max(leftdepth,rightdepth);
		
	}
}
