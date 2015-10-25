package trietest;

public class runtrie {
	public static void main(String[] args){
		String[] values={"A", "ans", "and", "an", "Pineapple",
				"Apple", "Orange", "Banana","answer"};
		
		testtrie t=new testtrie();
		
		for(String val : values)
			t.insert(val);
		
		System.out.println(t.search("pineappl"));
		
		t.find("a");
	}
}
