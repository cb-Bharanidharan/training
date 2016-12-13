import java.util.*;
class subject
{
String s1,s2,s3;
float m1,m2,m3;
Scanner in=new Scanner(System.in);
	public void sets1()
	{
          s1=in.next();
	}
	public void sets2()
	{
	  s2=in.next();	
	}
	public void sets3()
	{
	 s3=in.next();	
	}
	public void gets1()
	{
	System.out.println("S1:"+s1);
	}
	public void gets2()
	{
	System.out.println("S2:"+s2);
	}
	public void gets3()
	{
	System.out.println("S3:"+s3);
	}
	public void getm1()
	{	
	System.out.println(s1+":"+m1);
	}
	public void getm2()
	{
	System.out.println(s2+":"+m2);
	}
	public void getm3()
	{
	System.out.println(s3+":"+m3);
	}
	public void setm1()
	{
         m1=in.nextFloat();
	}
	public void setm2()
	{
	 m2=in.nextFloat();
	}
	public void setm3()
	{
	 m3=in.nextFloat();
	}
}
class Student
{
String name;
int id;
boolean gender;
subject sub = new subject();
Scanner in=new Scanner(System.in);
	public void setName()
        {
         name=in.next();
        }
        public void setId()
        {
         id=in.nextInt();
        }
        public void setGender()
        {
	 int num;	
         num=in.nextInt();
         if(num%2==1)
		gender=true;
	 else
		gender=false;
	}
	public void setSub()
	{
	 sub.sets1();
	 sub.sets2();
 	 sub.sets3();
	 sub.setm1();
	 sub.setm2();
	 sub.setm3();
	}
	public void getName()
	{
	 System.out.println("NAME:"+name);
	}
	public void getId()
	{
	 System.out.println("ID:"+id);
	}
	public void getGender()
	{
	 if(gender)
	 	System.out.println("GENDER:MALE");
	 else
		System.out.println("GENDER:FEMALE");
	}
	public void getSub()
	{
	 sub.getm1();
	 sub.getm2();
	 sub.getm3();
	}
}
class resultgenerator
{
	public static void generateResult(Student s)
	{
	 float tot;
	 tot=s.sub.m1+s.sub.m2+s.sub.m3;	
	 s.getName();
	 s.getId();
	 s.getGender();
	 s.getSub();
	 System.out.println("TOTAL:"+tot+"AVERAGE:"+(tot/3));
		
	}

}
class day3_2
{
  public Student storeStudentData(Student s)
  {	
	s.setName();
	s.setId();
	s.setGender();
	s.setSub();
	return s;
 }		
  public static void main(String args[])
  {
	Student s=new Student();
	day3_2 obj=new day3_2();
        s=obj.storeStudentData(s);
	resultgenerator r=new resultgenerator();
        r.generateResult(s); 
 }
}
