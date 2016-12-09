class day2_1
{
public void pattern(int n)
{
int i,j=1;
	System.out.println();
	while(j<=n)
	{
		for(i=0;i<(n-j);i++)
			System.out.print("  ");
		for(i=1;i<=j;i++)
		{
			System.out.print(i+" ");
		}

		for(i=i-2;i>=1&&j!=1;i--)
		{	
			System.out.print(i+" ");
		}			
		System.out.println(" ");
	j++;	
	}

}
public static void main(String args[])
{
int n=4;
day2_1 a=new day2_1();
a.pattern(n);
}
}
