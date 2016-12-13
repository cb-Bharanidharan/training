import java.util.*;
class emp
{
String name,desg;
double sal,tax;
char gend;

	emp(String N,String D,char G,double S)
	{
	name=N;
	desg=D;
	gend=G;
	sal=S;
	}
	public void display()
	{
	System.out.println(name+" "+gend+" "+sal+" "+tax);
	}
	public static void calculatetax(emp e)
	{
	 e.tax=(e.gend=='M')?e.sal/100*30:e.sal/100*20;
	
	}
	

}
class day3_4
{
 	
  public static void main(String args[])
  {
	emp e1=new emp("BHARANI","PE",'M',25000.00);
	emp e2=new emp("ABINAYA","DE",'F',22000.00);
	e1.calculatetax(e1);
	e1.display();
	e2.calculatetax(e2);
	e2.display();
	

 }
}
