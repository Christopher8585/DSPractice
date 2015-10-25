import java.util.HashMap;


public class TestAspera {
	
	 static HashMap<String, Integer> map=new HashMap<String, Integer>();
	  
	static boolean dictionaryContains(String word)
	{
	   
	    if (map.containsKey(word))
	           return true;
	    return false;
	}
	
	static boolean wordBreak(String str)
	{
	    int size = str.length();
	    if (size == 0)   return true;
	 
	    // Create the DP table to store results of subroblems. The value wb[i]
	    // will be true if str[0..i-1] can be segmented into dictionary words,
	    // otherwise false.
	    boolean wb[]=new boolean[size+1];
	   // memset(wb, 0, sizeof(wb)); // Initialize all values as false.
	 
	    for (int i=1; i<=size; i++)
	    {
	        // if wb[i] is false, then check if current prefix can make it true.
	        // Current prefix is "str.substr(0, i)"
	        if (wb[i] == false && dictionaryContains(str.substring(0, i)))
	            wb[i] = true;
	 
	        // wb[i] is true, then check for all substrings starting from
	        // (i+1)th character and store their results.
	        if (wb[i] == true)
	        {
	            // If we reached the last prefix
	            if (i == size)
	                return true;
	 
	            for (int j = i+1; j <= size; j++)
	            {
	                // Update wb[j] if it is false and can be updated
	                // Note the parameter passed to dictionaryContains() is
	                // substring starting from index 'i' and length 'j-i'
	                if (wb[j] == false && dictionaryContains( str.substring(i, j) ))
	                    wb[j] = true;
	 
	                // If we reached the last character
	                if (j == size && wb[j] == true)
	                    return true;
	            }
	        }
	    }
	 
	    /* Uncomment these lines to print DP table "wb[]"
	     for (int i = 1; i <= size; i++)
	        cout << " " << wb[i]; */
	 
	    // If we have tried all prefixes and none of them worked
	    return false;
	}
	
	public static void main(String args[])
	{
		 
		String[] arr=new String[]{"mobile","samsung","sam","sung","man","mango","icecream","and","go","i","like","ice","cream"};


		 for(String word:arr)	
		    	 map.put(word, word.length());
		
		
	    System.out.println(wordBreak("ilikesamsungasdasd"));
	    //wordBreak("iiiiiiii")? cout <<"Yes\n": cout << "No\n";
	    //wordBreak("")? cout <<"Yes\n": cout << "No\n";
	    //wordBreak("ilikelikeimangoiii")? cout <<"Yes\n": cout << "No\n";
	    //wordBreak("samsungandmango")? cout <<"Yes\n": cout << "No\n";
	    //wordBreak("samsungandmangok")? cout <<"Yes\n": cout << "No\n";
	    //return 0;
	}
}
