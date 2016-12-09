import java.util.Scanner;
class day2_6
{

public static void main(String args[])
{
Scanner in=new Scanner(System.in);
System.out.print("ENTER THE NUMBER OF ELEMENTS:");
int n=in.nextInt();
int[] a=new int[n];
int min=0,max=0,i;
	for(i=0;i<n;i++)
	{
		 a[i]=in.nextInt();
		if(i==0)
		{
			min=max=a[i];
		}
		else
		{
			if(a[i]<min)
				min=a[i];
			else if(a[i]>max)
				max=a[i];
		}
	}
System.out.println("MIN:"+min+"\nMAX:"+max);	
}


}
