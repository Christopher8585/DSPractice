package NFA;

import java.util.ArrayList;
import java.util.Stack;

public class DFSAlgo {
	 Vertex[] nodeList;
	
	 char[] re;	
	 int accept;
	
	DFSAlgo(String regex){
		re=regex.toCharArray();
		accept=re.length;
		nodeList=new Vertex[accept+1];
		
		int i=0;
		for(char c:re){
			nodeList[i]=new Vertex(c, null);
			i++;
		}
		nodeList[i]=new Vertex('\0', null);
		buildEpsilonTransition();
	}
	

	public void driver(int start, boolean[] visited) {
		dfs(start, visited);

		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == false)
				dfs(i, visited);
		}
	}

	private  void dfs(int vertexno, boolean[] visited) {
		visited[vertexno] = true;
		//System.out.println("Visiting " + nodeList[vertexno].c);
		for (Neighbor nbr = nodeList[vertexno].adjlink; nbr != null; nbr = nbr.next) {
			if (visited[nbr.vertexno] == false) {
				//System.out.println(nodeList[vertexno].c + "--"
				//		+ nodeList[nbr.vertexno].c);
				dfs(nbr.vertexno, visited);
				
			}
		}

	}

	private  void print() {
		System.out.println();
		for (int i = 0; i < nodeList.length; i++) {
			System.out.println(nodeList[i].c);
			if(nodeList[i].adjlink!=null)
				for (Neighbor nbr = nodeList[i].adjlink; nbr != null; nbr = nbr.next) {
					System.out.println("-->" + nodeList[nbr.vertexno].c);
				}
		}
	}

	public boolean recognizes(String text){
		ArrayList<Integer> pc=new ArrayList<Integer>();
		int n=nodeList.length;
		boolean[] visited = new boolean[n];
		dfs(0,visited);
		for (int v = 0; v < visited.length; v++) 
			if (visited[v])
				pc.add(v);
		
		for(int i=0;i<text.length();i++){
			ArrayList<Integer> match=new ArrayList<Integer>();
			for(int v:pc){
				if(v==accept)
					continue;
				
				if(re[v]==text.charAt(i) || re[v]=='.'){
					match.add(v+1);
					
				}
			}
			visited = new boolean[n];
			for(int vertex:match)
				dfs(vertex,visited);
			pc=new ArrayList<Integer>();
			for (int v = 0; v < visited.length; v++) 
				if (visited[v]){
					pc.add(v);
					
				}
		}
		for(int v:pc)
			if(v==accept)
				return true;
		return false;
		
	}

	public  void buildEpsilonTransition(){
		
		Stack<Integer> ops=new Stack<Integer>();
		for(int i=0;i<accept;i++){
			int lp=i;
			
			if(re[i]=='(' || re[i]=='|')ops.push(i);
			else if(re[i]==')'){
				int or=ops.pop();
				if(re[or]=='|'){
					lp=ops.pop();

					nodeList[lp].adjlink = new Neighbor(or+1, nodeList[lp].adjlink);
					nodeList[or].adjlink = new Neighbor(i, nodeList[or].adjlink);
				}
				else
					lp=or;
			}
			
			if(i<accept-1 && re[i+1]=='*'){

				nodeList[lp].adjlink = new Neighbor(i+1, nodeList[lp].adjlink);
				nodeList[i+1].adjlink = new Neighbor(lp, nodeList[i+1].adjlink);
			}	
			
			if(re[i]=='(' || re[i]=='*' || re[i]==')')
				nodeList[i].adjlink = new Neighbor(i+1, nodeList[i].adjlink);
		}
				
	}
	

	public static void main(String args[]) {
		
		DFSAlgo dfs=new DFSAlgo("//*.asda") ;
		//dfs.print();
		System.out.println(dfs.recognizes("bccasd"));
	}

}
