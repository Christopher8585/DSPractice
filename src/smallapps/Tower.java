package smallapps;

import java.util.Stack;

public class Tower {
	Stack<Integer> disks;
	int index;
	
	Tower(int i){
		index=i;
		disks=new Stack<Integer>();
	}
	
	public int index(){
		return index;
	}
	
	public void add(int d){
		if(!disks.isEmpty()&&disks.peek()<=d)
			System.out.print("error adding");
		else
			disks.push(d);
	}
	
	public void moveTopTo(Tower t){
		if(!disks.isEmpty()){
			int value=disks.pop();
			t.add(value);
			System.out.println("Moved disk "+ value + " from Tower "+ index()+ " to Tower" +t.index());
		}
		
	}
	
	public void print(){
		System.out.println("Tower:"+index());
		for(int i=disks.size()-1;i>=0;i--){
			
			System.out.print(disks.get(i));
		}
		System.out.println();
	}
	
	public void moveDisks(int n,Tower dest,Tower buffer){
		if(n>0){
			moveDisks(n-1, buffer, dest);
			moveTopTo(dest);
			buffer.moveDisks(n-1, dest, this);
		}
	}
}
