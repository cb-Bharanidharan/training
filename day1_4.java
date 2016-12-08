import java.util.*;
class day1_4
{
public static void main(String args[])
{
Scanner in=new Scanner(System.in);
System.out.print("X=");
int x=in.nextInt();
System.out.print("Y=");
int y=in.nextInt();
int z=0;
do
{
}
while(y>Math.pow(x,z++));
System.out.println("ANS="+(z-1));
}
}
