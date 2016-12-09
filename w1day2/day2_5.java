import java.util.Scanner;
class day2_5
{

public static void main(String args[])
{
int n;
Scanner in=new Scanner(System.in);
System.out.print("ENTER THE 'N' VALUE:");
n=in.nextInt();
int a=-1,b=1,c;
for(int i=0;i<n;i++)
{
c=a+b;
System.out.print(c+" ");
a=b;
b=c;
}
}



}
