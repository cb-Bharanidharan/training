import java.util.*;
class author
{
private String name,email;
private char gender;
	author(String nam,String eml,char gend)
	{
	 name=nam;
	 email=eml;
	 gender=gend;
	}
	public String getname()
	{
	 return name;
	}
	public String getemail()
	{
	 return email;
	}
	public void setemail(String eml)
	{
	 email=eml;
	}
	public char getgender()
	{
	 return gender;
	}
	public String todisplay()
	{
	 return name+" ("+gender+") at "+email;
	}

/*	public static void main(String args[])
	{
	 author a=new author(“R.K. Narayan”, “rknarayan@gmail.com”, “M”);
	 System.out.println(a.todisplay());
	 a.setemail("nakki@bookstall.com");
	 System.out.println(a.todisplay());	
	}
*/
}	
class day3_3
{
private String name;
private author a[];
private double price;
private int stk;
		
	day3_3(String nam,author at[],double pri,int qst)
	{
	name=nam;
	price=pri;
	stk=qst;
	a=new author[at.length];
	for(int i=0;i<at.length;i++)
		{
		 //a[i]=new author(at[i].name,at[i].email,at[i].gender);
		a[i]=at[i];
		}
	}
	day3_3(String nam,author at,double pri,int qst)
        {
	name=nam;
        price=pri;
        stk=qst;
	//a[0]=new author(at.name,at.email,at.gender);
       	a[0]=at;
	 }
	public String getname()
	{
	return name;
	}
        public author[] getauth()
        {
        return a;
        }
	public double getprice()
        {
        return price;
        }
	public void setprice(double p)
	{
	 price=p;
	}
	public int getqst()
        {
        return stk;
        }
	public void setqst(int qst)
        {
        stk=qst;
        }
	public String toDisplay()
	{
	 String res=name+" by ";
         for(int i=0;i<a.length;i++)
		{
		res+=a[i].todisplay()+" ";	
		}
	res+="\nPRICE:"+price+"\nSTOCK:"+stk;	
	return res;
	}
	public void addauth(author ath)
	{
	 int len=a.length;
	 //a[len]=new author(ath.name,ath.email,ath.gender);
	 a[len]=ath;		
	}
	public void printauth()
	{
         	for(int i=0;i<a.length;i++)
                {
                System.out.println(a[i].todisplay()); 
                }

	}
	public static void main(String args[])
	{
         Scanner in=new Scanner(System.in);
	 int cnt,i;
	 System.out.print("enter the number of authors:");
	 cnt=in.nextInt();
	 String name,email;
	 char gender;
	 author[] a=new author[cnt];
	 for(i=0;i<cnt;i++)
	 {
	  System.out.print("NAME:");
	  name=in.next();
	  System.out.print("EMAIL:");
	  email=in.next();
	  System.out.print("GENDER(M/F):");
	  gender=in.next().charAt(0);
          a[i]=new author(name,email,gender);
	  System.out.println(a[i].todisplay()); 
	}	
	 day3_3 obj=new day3_3("MY DAIRY",a,500.00,25);
	 System.out.println(obj.toDisplay());	
	}

}
