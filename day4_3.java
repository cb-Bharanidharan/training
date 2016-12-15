class servstat
{
String name,addr,cont;
 servstat(String n,String a,String c)
    {
     name=n;
     addr=a;
     cont=c;	
    }
}
class person
{
String name,cont;
int age;
 person(String n,String c,int a)
   {
    name=n;cont=c;age=a;
   }	
}
class emp extends person
{
int empid;
    emp(String n,String c,int a,int e)
    {
 	super(n,c,a);
	empid=e;
    }	

} 
class vehicle
{
String brand,color;
servstat ser;
 vehicle(String b,String c,servstat s)
 {
	brand=b;color=c;ser=s;
 }	
}
class invoice
{
person own;
emp em;
vehicle vec;
double amount;

 invoice(person p,emp e,vehicle v,double a)
	{
	 own=p;em=e;vec=v;amount=a;
	}
 public void display()
 {
  System.out.println("OWNER DETAILS: "+own.name+","+own.cont+" Age-"+own.age);
  System.out.println("VEHICLE DETAILS: "+vec.brand+","+vec.color);
  System.out.println("SERVICE STATION DETAILS:"+vec.ser.name+","+vec.ser.addr+" CONTACT-"+vec.ser.cont);
  System.out.println("EMPLOYEE DETAILS: "+em.empid+","+em.name+","+em.cont+" Age-"+em.age);
  System.out.println("AMOUNT:"+amount);		
 }
}
class day4_3
{

public static void main(String args[])
{
servstat s1=new servstat("ABC","CHENNAI","9876543211");
servstat s2=new servstat("XYZ","COIMBATORE","1234567899");
vehicle v1=new vehicle("BMW","RED",s1);
vehicle v2=new vehicle("AUDI","WHITE",s2);
person p=new person("BHARANI","9791868650",23);
person p1=new person("AARU","9487527596",23);
emp e=new emp("AARU","9487527596",23,18);
emp e1=new emp("SAKTHI","9798771278",24,33);
invoice i=new invoice(p,e,v1,1000);
invoice i2=new invoice(p1,e1,v2,20000);
i.display();
i2.display();
}

}
