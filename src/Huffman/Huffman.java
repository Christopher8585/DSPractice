package Huffman;

public class Huffman {
	
	
	public void expand(int[] binary){
		Node root=read(binary,0);
		int n =binary.length;
		
		for(int i=0;i<n;i++){
			Node x=root;
			while(!x.isLeaf()){
				if(binary[i]!=1)
					x=x.left;
				else
					x=x.right;
				
				i++;
			}
			System.out.println(x.c);
		}
	}
	
	public void write(Node x){
		if(x.isLeaf()){
			System.out.println(1);
			System.out.println(x.c);
			return;
		}
		System.out.println(0);
		write(x.left);
		write(x.right);
	}
	
	public Node read(int []binary,int i){
		if(binary[i]==1){
			String s="";
			for(int j=i;j<i+8;j++)
				 s+=binary[j];
			int val=Integer.parseInt(s, 2);
			char c=(char)val;
			return new Node(0,c, null, null);
		}
		Node x=read(binary,i+1);
		Node y=read(binary,i+1);
		return new Node(0,'\0',  x, y);
	}
	
	
}
