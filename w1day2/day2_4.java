import java.util.Scanner;
class day2_4
{
public void sim_int(double cap,double roi,double yrs)
{
System.out.println("SIMPLE INTEREST:"+(cap*roi*yrs/100));
}
public void com_int(double cap,double roi,double yrs)
{
System.out.println("COMPOUND INTEREST:"+Math.round((cap*Math.pow((1+roi/100),yrs)-cap)*100.0/100.0));
}
public static void main(String args[])
{
double cap,roi,yrs;
Scanner in=new Scanner(System.in);
System.out.print("CAPITAL:");
cap=in.nextDouble();
System.out.print("RATE OF INTEREST:");
roi=in.nextDouble();
System.out.print("NUMBER OF YEARS:");
yrs=in.nextDouble();
day2_4 obj=new day2_4();
obj.sim_int(cap,roi,yrs);
obj.com_int(cap,roi,yrs);

}


}
