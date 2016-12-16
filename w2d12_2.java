import java.util.*;
class w2d12_2
{


        public static void main(String args[])
        {
        Scanner in=new Scanner(System.in);
        int n,i;
        System.out.println("ENTER THE NUMBER OF WORDS:");
        n=in.nextInt();

        String[] arr=new String[n];
        HashMap<String,List<String>> hm=new HashMap<String,List<String>>();
        for(i=0;i<n;i++)
        {
         System.out.println("WORD "+(i+1)+":");
         arr[i]=in.next();
         if(hm.containsKey(arr[i].substring(0,3)))
                {
                hm.get(arr[i].substring(0,3)).add(arr[i]);
                }
         else
                {
                 List<String> a=new ArrayList<String>();
                 a.add(arr[i]);
                 hm.put(arr[i].substring(0,3),a);
                }
        }
        for(Map.Entry m:hm.entrySet()){
        System.out.print("LIST OF WORDS OF PREFIX ["+m.getKey()+"]: ");
	List<String> a=(List<String>)m.getValue();
	Collections.sort(a);
	System.out.println(a);
        }
 }





}
