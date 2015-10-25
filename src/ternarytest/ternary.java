package ternarytest;

public class ternary{
	public static void main(String[] args){
		put("cat",1);
		put("cats",2);
		put("up",3);
		put("bug",4);
		
		
		System.out.println(contains("cat"));
		System.out.println(get("up"));
	}
	
	
	static node root;
	public static void put(String word, int value){
		
		root=put(root, word, value, 0);
	}
	
	public static node put(node root, String word, int value, int depth){
		
		char data=word.charAt(depth);
		
		if(root==null)
			root=new node (0,data);
		
		if(data<root.data)
			root.left=put(root.left, word, value, depth);
		else if(data>root.data)
			root.right=put(root.right,word,value,depth);
		else if(depth<word.length()-1)
			root.equal=put(root.equal,word,value,depth + 1);
		else
			root.value=value;
		
		return root;	
			
	}
	
	public static boolean contains(String word){
		return (get(word)!=0);
	}
	
	public static int get(String word){
		node x=get(root, word, 0);
		if(x!=null)
			return x.value;
		
		return 0;
	}
	
	public static node get(node root, String word, int depth){
		
		if(root==null)
			return root;
		
		char data=word.charAt(depth);
		
		if(data<root.data)
			return get(root.left,word,depth);
		else if(data>root.data)
			return get(root.right,word,depth);
		else if(depth<word.length()-1)
			return get(root.equal,word,depth+1);
		else
			return root;
		
	}
	
	

	public static void getString(String word){
		getString(root, word, 0);
	}
	
	public static node getString(node root, String word, int depth){
		
		if(root==null)
			return null;
		
		char data=word.charAt(depth);
		//System.out.println(root.data);
		if(data<root.data)
			return getString(root.left,word,depth);
		else if(data>root.data)
			return getString(root.right,word,depth);
		else if(depth<word.length()-1){
			System.out.println("=========="+root.data+"=================");
			return getString(root.equal,word,depth+1);
		}			
		else{
			System.out.println("=========="+root.data+"=================");
			return root;
		}
		
	}
	

}

