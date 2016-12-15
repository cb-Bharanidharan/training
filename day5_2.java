import java.util.*;
interface mob
{
public void name();
public void remaining_charge();
public void disp();
}
class day5_2
{
private String name;
private int remaining_charge;
public void  display()
{
	
 mob mobil=new mob()
	{
 	public void name()
		{
			Scanner in=new Scanner(System.in);
			name=in.next();
		}
	public void remaining_charge()
		{
			remaining_charge=(int)(Math.random()*100+1);
			
		}
	public void disp()
	{
	System.out.println("PHONE: "+name+"\nCHARGES: "+remaining_charge);
	}	
	};

mobil.name();
mobil.remaining_charge();
mobil.disp();
}
public static void main(String args[])
{
day5_2 d=new day5_2();
d.display();

}

}


