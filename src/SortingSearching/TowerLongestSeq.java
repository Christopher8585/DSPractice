package SortingSearching;

import java.util.ArrayList;
import java.util.Collections;

public class TowerLongestSeq {
	private class t1{
		t1(){
			
		}
	}
	
	t1 t=new t1();
	
	
	static ArrayList<HTWT> items;
	static ArrayList<HTWT> maxseq;
	
	public static ArrayList<HTWT> maxSequence(ArrayList<HTWT> s1, ArrayList<HTWT> s2){
		return s1.size()>s2.size()?s1:s2;
	}
	
	public static int findSequence(int startfrom, ArrayList<HTWT> a){
		int unfit=startfrom;
		if(unfit<items.size()){
			for(int i=0; i<items.size();i++){
				HTWT item=items.get(i);
				if(i==0 || items.get(i-1).isBefore(item))
					a.add(item);
				else
					unfit=i;
			}
		}
		return unfit;
	}
	
	public static void maxTower(){
		Collections.sort(items);
		int currentunfit=0;
		while(currentunfit<items.size()){
			ArrayList<HTWT> nextseq= new ArrayList<HTWT>();
			int nextunfit=findSequence(currentunfit, nextseq);
			maxseq=maxSequence(nextseq,maxseq);
			if(nextunfit==currentunfit)
				break;
			else
				currentunfit=nextunfit;
			
		}
		print();
	}
	
	public static void print(){
		for(HTWT h : items){
			System.out.print(" ht:"+h.height +" wt:"+h.weight);
			System.out.println();
		}
	}
	
	public static void main(String p[]){
		items=new ArrayList<HTWT>();
		maxseq=new ArrayList<HTWT>();
		items.add(new HTWT(3,4));
		items.add(new HTWT(1,4));
		items.add(new HTWT(4,5));
		items.add(new HTWT(4,4));
		items.add(new HTWT(2,4));
		items.add(new HTWT(7,4));
		maxTower();
		
	}
}
