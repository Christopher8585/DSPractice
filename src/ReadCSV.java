import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReadCSV {

	public static void main(String[] args) {

		ReadCSV obj = new ReadCSV();
		obj.createReport();

	}

	public void createReport() {

		String csvFile = "/home/christopher/Downloads/75f647c2ac77-Metropolitan_Populations_2010-2012_.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		//List<Population> plist = new ArrayList<Population>();
		Map<String, Population> map = new HashMap<String, Population>();
		MinHeap minHeap=new MinHeap(5);
		MaxHeap maxHeap=new MaxHeap(5);
		MinHeap minHeapStates=new MinHeap(5);
		int count = 0;
		try {

			br = new BufferedReader(new FileReader(csvFile));

			while ((line = br.readLine()) != null) {
				if (count++ == 0)
					continue;
				count++;
				String[] Population = line.split(cvsSplitBy);

				Population p = new Population(Population[0], Population[1],
						Integer.parseInt(Population[2]),
						Integer.parseInt(Population[3]),
						Integer.parseInt(Population[4]));
				
				//plist.add(p);
				
				if(p.pop10>50000){
					minHeap.add(p);
					maxHeap.add(p);
				}

				if (!map.containsKey(Population[1]))
					map.put(Population[1],
							new Population("", Population[1],
									Integer.parseInt(Population[2]),
									Integer.parseInt(Population[3]),
									Integer.parseInt(Population[4])));
				else {
					Population d = map.get(Population[1]);
					map.put(Population[1],
							new Population("", Population[1],
									d.pop10 + Integer.parseInt(Population[2]),
									d.pop11 +Integer.parseInt(Population[3]),
									d.pop12 +Integer.parseInt(Population[4])));
				}	

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//Collections.sort(plist);
		System.out.println("Total Rows :-"+ count);
		System.out.println("Top five cities to target based on highest population growth:- " );
		minHeap.print();
		System.out.println();
		System.out.println("Top five cities to avoid based on the most shrinking population");
		maxHeap.print();
		System.out.println();
		
		Iterator it = map.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	       // System.out.println(pair.getKey() + " = " + pair.getValue());
	        minHeapStates.add((Population)pair.getValue());
	        it.remove(); 
	    }
	    System.out.println("Top five states with highest cumulative growth");
	    minHeapStates.print();
	    
	}

	class Population implements Comparable<Population> {
		String geography;
		String city;
		int pop10;
		int pop11;
		int pop12;
		double percentDiff;

		Population(String geog, String city, int pop1, int pop2, int pop3) {
			this.geography = geog;
			this.pop10 = pop1;
			this.pop11 = pop2;
			this.pop12 = pop3;
			this.city = city;

			this.percentDiff = ((double) (pop12 - pop10) * 100) / pop10;
			// System.out.println(this.percentDiff);
		}

		@Override
		public int compareTo(Population o) {
			return this.pop10 - o.pop10;
		}
	}

	class MinHeap {
		Population[] heap;
		int top;

		MinHeap(int size) {
			heap = new Population[size];
			top = -1;
		}

		void add(Population pt) {

			if (top < heap.length - 1) {
				heap[++top] = pt;
				siftUp();
			} else {
				
				Population temp=remove();
				if (temp.percentDiff > pt.percentDiff){
					heap[++top] = temp;
					siftUp();
				}
				else{	
					heap[++top] = pt;
					siftUp();
				}
			}
		}

		Population remove() {
			if (top == -1)
				return null;
			if (top == 0)
				return heap[top--];

			Population value = heap[0];
			heap[0] = heap[top];
			top--;
			siftDown();
			return value;
		}

		private void siftUp() {
			int k = top;

			while (k > 0) {
				int p = (k - 1) / 2;
				if (heap[k].percentDiff < heap[p].percentDiff){
					Population t = heap[k];
					heap[k] = heap[p];
					heap[p] = t;
					k = p;
				}
				else {
					break;
				}
			}
		}

		private void siftDown() {
			int k = 0;
			int l = 2 * k + 1;

			while (l <= top) {
				int min = l;
				int r = l + 1;
				
				if (r <= top)
					if (heap[r].percentDiff < heap[l].percentDiff)
						min++;

				if (heap[min].percentDiff < heap[k].percentDiff) {
					Population t = heap[k];
					heap[k] = heap[min];
					heap[min] = t;
				} else
					break;
				
				k = min;
				l = 2 * k + 1;
			}
		}
		
		public void print(){
			for(int i=0;i<5;i++){
				Population temp=remove();
				System.out.println("Place: "+temp.geography + " " + temp.city + " % Change: " + temp.percentDiff +" Population in 2010: "+temp.pop10 +" Population in 2012: "+temp.pop12);
			}
		}
	}
	
	class MaxHeap {
		Population[] heap;
		int top;

		MaxHeap(int size) {
			heap = new Population[size];
			top = -1;
		}

		void add(Population pt) {

			if (top < heap.length - 1) {
				heap[++top] = pt;
				siftUp();
			} else {
				
				Population temp=remove();
				if (temp.percentDiff < pt.percentDiff){
					heap[++top] = temp;
					siftUp();
				}
				else{	
					heap[++top] = pt;
					siftUp();
				}
			}
		}

		Population remove() {
			if (top == -1)
				return null;
			if (top == 0)
				return heap[top--];

			Population value = heap[0];
			heap[0] = heap[top];
			top--;
			siftDown();
			return value;
		}

		private void siftUp() {
			int k = top;

			while (k > 0) {
				int p = (k - 1) / 2;
				if (heap[k].percentDiff > heap[p].percentDiff){
					Population t = heap[k];
					heap[k] = heap[p];
					heap[p] = t;
					k = p;
				}
				else {
					break;
				}
			}
		}

		private void siftDown() {
			int k = 0;
			int l = 2 * k + 1;

			while (l <= top) {
				int min = l;
				int r = l + 1;
				
				if (r <= top)
					if (heap[r].percentDiff > heap[l].percentDiff)
						min++;

				if (heap[min].percentDiff > heap[k].percentDiff) {
					Population t = heap[k];
					heap[k] = heap[min];
					heap[min] = t;
				} else
					break;
				
				k = min;
				l = 2 * k + 1;
			}
		}
		
		public void print(){
			for(int i=0;i<5;i++){
				Population temp=remove();
				System.out.println("Place: "+temp.geography + " " + temp.city + " % Change: " + temp.percentDiff +" Population in 2010: "+temp.pop10 +" Population in 2012: "+temp.pop12);
			}
		}
	}
	
	
}
