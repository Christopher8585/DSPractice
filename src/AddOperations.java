
public class AddOperations {
	public static boolean differentSigns(int a,int b){
		if((a<0 && b>0) || (a>0 && b<0))
			return true;
		else
			return false;
	}
	
	public static int negate(int a){
		int value=0;
		int posneg= a>0?-1:1;
		while(a!=0){
			a+=posneg;
			value+=posneg;
		}
		return value;
	}
	
	public static int abs(int a){
		if(a<0)
			return negate(a);
		else
			return a;
	}
	
	public static int multiply(int a,int b){
		if(a<b)
			return multiply(b,a);
		int value=0;
		for(int i=0;i<b;i++){
			value+=a;
		}
		return value;
	}
	
	public static int subtract(int a, int b){
		int value=0;
		value=a+negate(b);
		return value;
	}
	
	public static int divide(int a,int b){
		if(b==0)
			return 0;
		
		int q=0;
		for(int i=abs(b);i<=abs(a);i+=abs(b))
			q++;
		
		if(differentSigns(a, b))
			q=negate(q);
		
		return q;
	}
	
	public static int add(int a, int b)
	{
		int sum=0,carry=0;
	     if(b == 0)
	         return a;
	     sum = a ^ b;
	     carry = (a & b) << 1;
	     
	     return add(sum,carry);
	}
	
	public static void main(String args[]){
		int a=3,b=12;
		System.out.println(Integer.MIN_VALUE);
		System.out.println(multiply(a, b));
		System.out.println(subtract(a, b));
		System.out.println(divide( b,a));
		System.out.println(negate(a));
		System.out.println(abs(-2));
		System.out.println(add(12,6));
		
	}
}
