package smallapps;

public class LinkedList {
	
	public static void removeDuplicates(Node root){
		
		if(root==null)return;
		
		Node top=root;
		Node curr=root.next;
		Node list;

		
		while(curr!=null){
			list=root;
			while(curr!=list){
				if(curr.c==list.c){
					Node tmp=curr.next;
					top.next=tmp;
					curr=tmp;
					break;
				}
				
				list=list.next;
			}
			if(curr==list){
				top=curr;
				curr=curr.next;
			}
				
			
		}
		System.out.println();
		printList(root);
		
	}
	
	public static void printList(Node root){
		while(root!=null){
			//System.out.println(root.c);
			System.out.print(root.c +" ");
			root=root.next;
		}
	}
	
	
	//Sum of 2 linked lists
	
	public static Node sum(Node s1,Node s2,int carry){
		
		if(s1==null && s2==null)
			return null;
		
		Node result=new Node(0);
		int sum=carry;
		if(s1!=null)
			sum+=s1.data;
		if(s2!=null)
			sum+=s2.data;
		result.data=sum%10;
		
		Node next=sum((Node)s1!=null?s1.next:null,(Node)s2!=null?s2.next:null,sum>=10?1:0);
		result.next=next;
		
		
		return result;
	}
	
	//Corrupt LL-(Circular LL)
	public static Node isCorruptLoop(Node head){
		Node n1=head;
		Node n2=head;
		
		while(n1!=null){
			n1=n1.next;
			n2=n2.next.next;
			if(n1==n2)
				break;
		}
		
		if(n1==null)
			return null;
		
		n1=head;
		while(n1!=n2){
			n1=n1.next;
			n2=n2.next;
		}
		
		return n1;
	}
	
	public static void main(String args[]){
		
		Node root=new Node('a');
		root.next=new Node('b');
		root.next.next=new Node('c');
		root.next.next.next=new Node('c');
		root.next.next.next.next=new Node('e');
		root.next.next.next.next.next=new Node('c');
		root.next.next.next.next.next.next=new Node('c');
		root.next.next.next.next.next.next.next=new Node('h');
		root.next.next.next.next.next.next.next.next=new Node('h');
		root.next.next.next.next.next.next.next.next.next=new Node('j');
		root.next.next.next.next.next.next.next.next.next.next=new Node('h');
		//root.next.next.next.next.next.next.next.next.next.next.next=root.next.next.next.next.next;
		
		//System.out.print(isCorruptLoop(root).c);
		printList(root);
		removeDuplicates(root);
		/*
		Node root=new Node(3);
		root.next=new Node(1);
		root.next.next=new Node(5);
		
		Node root2=new Node(5);
		root2.next=new Node(9);
		root2.next.next=new Node(2);
		*/
		//Node result=sum(root,root2,0);
		//printList(result);
		
	}
}
