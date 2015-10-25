package smallapps;

import java.util.Stack;

public class Stacks {
	int n=9;
	int[] stack=new int[n];
	int top1=0-1;
	int top2=n/3-1;
	int top3=2*n/3-1;
	
	public void push(int value, int stackNo){
		if(stackNo==1)
			if(top1<n/3-1)
				stack[++top1]=value;
		if(stackNo==2)
			if(top2<(2*n/3)-1)
				stack[++top2]=value;
		if(stackNo==3)
			if(top3<n-1)
				stack[++top3]=value;
	}
	
	public int pop(int stackNo){
		int top=0;
		if(stackNo==1)
			if(top1!=-1)
				top=stack[top1--];
		if(stackNo==2)
			if(top2!=n/3-1)
				top=stack[top2--];
		if(stackNo==3)
			if(top3!=2*n/3-1)
				top=stack[top3--];
		
		return top;
		
	}
	
	
	public Stack<Integer> sort(Stack<Integer> s){
		Stack<Integer> r=new Stack<Integer>();
		
		while(!s.isEmpty()){
			int value=s.pop();
			
			while(!r.isEmpty() && r.peek()>value){
				s.push(r.pop());
			}
			
			r.push(value);	
		}
		
		return r;
	}
	
}
