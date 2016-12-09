import java.util.*;
class day2_3
{

public static void main(String args[])
{
Scanner in=new Scanner(System.in);
	System.out.print("ENTER THE STRING:");
	String inp=in.next();
	int sum=0;
	for(int i=0;i<inp.length();i++)
	{
		sum+=(int)inp.charAt(i);
	}	
	if(sum%2==0)
		System.out.println("EVEN");
	else
		System.out.println("ODD");
}
}
