package Heap;

public class testHeap {
	public static void main(String args[]){
		Heap p=new Heap(10);
		
		p.add(4);
		System.out.println(p);
		p.add(3);
		System.out.println(p);
		p.add(5);
		System.out.println(p);
		p.add(7);
		System.out.println(p);
		p.add(9);
		System.out.println(p);
		p.add(1);
		System.out.println(p);
		p.add(2);
		System.out.println(p);
		p.add(2);
		System.out.println(p);
		p.add(2);
		System.out.println(p);
		p.add(2);
		System.out.println(p);
		//p.add(2);
		System.out.println(p);
		
		while (p.top!=-1){
			int max = p.remove();
			System.out.println(max +  "    " + p);
		}
		
	}
}
