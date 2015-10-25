package smallapps;

public class Tree {
	int value;
	Tree left;
	Tree right;
	Tree parent;
	
	Tree(){
		left=null;
		right=null;
		parent=null;
	}
	
	Tree(int v){
		value=v;
		left=null;
		right=null;
		parent=null;
	}
}
