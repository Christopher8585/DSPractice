package WordLadder;

import java.util.HashMap;
import java.util.Scanner;

public class BFStest {
	public static void main(String args[]) {
		/*
		Scanner a = new Scanner(System.in);
		
		do { 
			System.out.println("Enter word");
		   // v[i].adjlink=new Neighbor(,v[i].adjlink);
			addWord(a.nextLine());
		    System.out.println("End?"); //a.nextInt(); }
		  
		  }while (a.nextInt()!=-1);
		
		
		
		
		for (int i = 0; i < size; i++) {
			v[i] = new Vertex(, null);
		}

		
		 * for(int i=0;i<size;i++){ System.out.println("Enter edge for "+i);
		 * 
		 * while (a.nextInt()!=-1){ System.out.println("Enter edge no");
		 * v[i].adjlink=new Neighbor(a.nextInt(),v[i].adjlink);
		 * System.out.println("End?"); //a.nextInt(); }
		 * 
		 * }
		

		v[0].adjlink = new Neighbor(1, v[0].adjlink);
		v[0].adjlink = new Neighbor(5, v[0].adjlink);
		v[0].adjlink = new Neighbor(2, v[0].adjlink);

		v[1].adjlink = new Neighbor(0, v[1].adjlink);
		v[1].adjlink = new Neighbor(2, v[1].adjlink);

		v[2].adjlink = new Neighbor(0, v[2].adjlink);
		v[2].adjlink = new Neighbor(1, v[2].adjlink);
		v[2].adjlink = new Neighbor(3, v[2].adjlink);
		v[2].adjlink = new Neighbor(4, v[2].adjlink);

		v[3].adjlink = new Neighbor(2, v[3].adjlink);
		v[3].adjlink = new Neighbor(4, v[3].adjlink);
		v[3].adjlink = new Neighbor(5, v[3].adjlink);

		v[4].adjlink = new Neighbor(2, v[4].adjlink);
		v[4].adjlink = new Neighbor(3, v[4].adjlink);

		v[5].adjlink = new Neighbor(3, v[5].adjlink);
		v[5].adjlink = new Neighbor(3, v[5].adjlink);
 */
		String[] words= {"CAT", "BAT", "COT", "COG", "COW", "RAT", "BUT","CUT", "DOG", "WEB"};
		for(String word : words)
			insertWordToVertex(word);
		addWord();
		
		BFS bfs = new BFS();
		bfs.BFS(v, 1,"BUT");
		bfs.print("DOG","CAT");

	}
	static Vertex[] v=new Vertex[10];
	//HashMap<String, Neighbor> hm=new HashMap<String,Neighbor>();
	static void addWord(){

		for(int i=0;i<10;i++){
			for(int j=0;j<10;j++){
			if(v[i]!=null)
				if(diffOfOne(v[i].name,v[j].name)){
					v[i].adjlink=new Neighbor(j,v[i].adjlink);
				}
			}
		}
	}
	
	static int insertWordToVertex(String word){
		boolean exists=false;
		int index=0;
		for(int i=0;i<v.length;i++){
			if(v[i]!=null)
				if(v[i].name==word){
					exists=true;	
					return i;
				}
			
			if(v[i]==null)
				index=i;
		}	
		
		if(v[index]==null && !exists){
			v[index]=new Vertex(word,null);
		}	
		return index;
	}
	
	static boolean diffOfOne(String one,String two){
		if(one.length()!=two.length())
			return false;
		
		int diff=0;
		for(int i=0;i<one.length();i++){
			if(one.charAt(i)!=two.charAt(i))
				diff++;
		}
		
		return (diff==1);
	}

}
