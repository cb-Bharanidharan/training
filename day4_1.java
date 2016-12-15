import java.util.*;
class car
{
int speed;
double rp;
String color;
 car(int s,double r,String c)
 {
  speed=s;
  rp=r;
  color=c;
 }
 public double getsaleprice()
 {
	return rp;
 }	

}
class truck extends car
{

int weight;
 truck(int w,int s,double r,String c)
 {
 
  super(s,r,c);	
  weight=w;
 }
 public double getsaleprice()
 {
  if(weight>2000)
  return 0.9*rp;
  
  return 0.8*rp;	
 }

}
class ford extends car
{
int year;
int md;
 ford(int y,int m,int s,double r,String c)
  {
  super(s,r,c);
   year=y;
   md=m;
  
  }
 public double getsaleprice()
 {
  return rp-md;
 } 
}
class sedan extends car
{
int length;
 sedan(int l,int s,double r,String c)
 {
  super(s,r,c);
  length=l;
  
 }
  public double getsaleprice()
 {
  if(length>20)
    return 0.95*rp;
  return 0.9*rp;
 }	
}
class day4_1
{
 public static void main(String  args[])
 {
  sedan s=new sedan(25,100,25000,"RED");
  ford f1=new ford(2000,2000,200,30000,"BLUE");
  ford f2=new ford(2012,4000,250,40000,"BLACK");
  car c=new car(150,15000,"WHITE");
  System.out.println("CAR - SPEED:"+c.speed+" COLOR:"+c.color+" PRICE:"+c.getsaleprice());
  System.out.println("FORD1- MODEL:"+f1.year+" SPEED:"+f1.speed+" COLOR:"+f1.color+" PRICE:"+f1.getsaleprice()+" MD:"+f1.md);
  System.out.println("FORD2- MODEL:"+f2.year+" SPEED:"+f2.speed+" COLOR:"+f2.color+" PRICE:"+f2.getsaleprice()+" MD:"+f2.md);
  System.out.println("SEDAN- LENGTH:"+s.length+" SPEED:"+s.speed+" COLOR:"+s.color+" PRICE:"+s.getsaleprice());

 }

}
