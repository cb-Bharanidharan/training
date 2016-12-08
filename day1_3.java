import java.util.*;
class day1_3
{
public static void main(String args[])
{
Scanner in=new Scanner(System.in);
System.out.print("ENTER A NUMBER:");
int x=in.nextInt();
if(x%2==1)
	{
	System.out.println("ODD");
	}
else
	{
	System.out.println("EVEN");
	}

System.out.print("ENTER A NUMBER FROM(0-6):");
x=in.nextInt();
switch(x)
	{
	case 0:System.out.println("MONDAY");break;
	case 1:System.out.println("TUESDAY");break;
	case 2:System.out.println("WEDNESDAY");break;
	case 3:System.out.println("THURSDAY");break;
	case 4:System.out.println("FRIDAY");break;
	case 5:System.out.println("SATURDAY");break;
	case 6:System.out.println("SUNDAY");break;
	default:System.out.println("INVALID INPUT");

	}

}
}
