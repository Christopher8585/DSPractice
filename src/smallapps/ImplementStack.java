package smallapps;

import java.util.Stack;

public class ImplementStack {
	public static void main(String args[]){
		/*
		Stacks s=new Stacks();
		s.push(1, 1);
		s.push(2, 1);
		s.push(3, 1);
		s.push(4, 1);
		s.push(5, 1);
		s.push(1, 2);
		s.push(2, 2);
		s.push(3, 2);
		s.push(4, 2);
		s.push(5, 2);
		
		System.out.print(s.pop(1));
		System.out.print(s.pop(1));
		System.out.print(s.pop(1));
		System.out.print(s.pop(1));
		System.out.print(s.pop(1));
		System.out.print(s.pop(1));
		
		s.push(1, 3);
		s.push(2, 3);
		s.push(3, 3);
		s.push(4, 3);
		s.push(5, 3);
		
		System.out.print(s.pop(3));
		System.out.print(s.pop(3));
		System.out.print(s.pop(3));
		System.out.print(s.pop(3));
		System.out.print(s.pop(3));
		System.out.print(s.pop(3));
		System.out.print(s.pop(2));
		System.out.print(s.pop(2));
		System.out.print(s.pop(2));
		System.out.print(s.pop(2));
		System.out.print(s.pop(2));
		System.out.print(s.pop(2));
		
		//Tower of Hanoi
		Tower[] tower=new Tower[3];
		
		for(int i=0;i<3;i++)
			tower[i]=new Tower(i);
		
		for(int i=4;i>0;i--)
			tower[0].add(i);
		
		tower[0].print();
		tower[1].print();
		tower[2].print();
		
		tower[0].moveDisks(4, tower[2], tower[1]);
		
		tower[0].print();
		tower[1].print();
		tower[2].print();
		*/
		Stacks s=new Stacks();
		Stack<Integer> r=new Stack<Integer>();
		r.push(3);
		r.push(2);
		r.push(5);
		r.push(6);
		r.push(1);
		Stack<Integer>sorted=s.sort(r);
		while (!sorted.isEmpty()){
			System.out.println(sorted.pop());
		}
		
	}
	
}
