package trietest;

public class testtrie {
	
	trienode root;
	
	testtrie(){
		root=new trienode();
	}
	
	public void insert(String word){
		word=word.toLowerCase();
		trienode traverse= root;

		for (int i=0;i<word.length();i++){
			char c=word.charAt(i);
			int val= c-'a';
			
			if(traverse.nodes[val]==null)
				traverse.nodes[val]=new trienode(c,0);	
			
			traverse=traverse.nodes[val];
		}
		
		traverse.end=1;
		
	}
	
	public boolean search(String word){
		
		word=word.toLowerCase();
		trienode tra=root;
		
		for(int i=0; i<word.length(); i++){
			char c=word.charAt(i);
			int val=c-'a';
			
			if(tra.nodes[val]==null)
				return false;
			
			tra=tra.nodes[val];
		}
		return tra.end!=0;
	}
	
	public void find(String word){
		
		word=word.toLowerCase();
		trienode tra=root;
		
		String s="";
		for(int i=0; i<word.length(); i++){
			char c=word.charAt(i);
			int val=c-'a';
			
			tra=tra.nodes[val];
			if(tra==null)
				return;
			else
				s=s+tra.data;
			//System.out.println(s);
		}
		if(tra.end==1)
			System.out.println(s);
		loop(tra,s);
	}
	
	public void loop(trienode tra, String s){
		//String snew=s;
		for(trienode t : tra.nodes){
			if(t!=null){
				
				//snew = snew+t.data;
				if(t.end==1)
					System.out.println(s + t.data);
				loop(t,s + t.data);
				
				
				
			}		
		}
	}
}
