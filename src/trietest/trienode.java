package trietest;

public class trienode {
	int end;
	char data;
	trienode[] nodes;
	
	trienode(char data, int end){
		this.data=data;
		this.end=end;
		
		nodes=new trienode[26];
		for(int i=0; i<26; i++)
			nodes[i]=null;
	}
	
	trienode(){
		nodes=new trienode[26];
		for(int i=0; i<26; i++)
			nodes[i]=null;
	}
}
