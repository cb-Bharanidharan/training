import java.util.*;
class w2d12_1
{
	

	public static void main(String args[])
	{
	Scanner in=new Scanner(System.in);
	int n,i;
	System.out.println("ENTER THE NUMBER OF WORDS:");
	n=in.nextInt();
	  
   	String[] arr=new String[n];
	HashMap<Integer,List<String>> hm=new HashMap<Integer,List<String>>();  
  	for(i=0;i<n;i++)
	{
	 System.out.println("WORD "+(i+1)+":");
	 arr[i]=in.next();
	 if(hm.containsKey(arr[i].length()))
		{
		hm.get(arr[i].length()).add(arr[i]);
		}
	 else
		{
		 List<String> a=new ArrayList<String>();
		 a.add(arr[i]);
		 hm.put(arr[i].length(),a);
		}
	}
  	for(Map.Entry m:hm.entrySet()){  
   	System.out.println("LIST OF WORDS OF LENGTH ["+m.getKey()+"]: "+m.getValue());  
  	}	  
 }  





}
