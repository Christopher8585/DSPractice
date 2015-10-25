package smallapps;

public class Node {
	char c;
	int data;
	Node next;
	Node(int d){
		data=d;
		next=null;
	}
	Node(char ch){
		c=ch;
		next=null;
	}
}
