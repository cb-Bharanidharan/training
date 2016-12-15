import java.util.*;
class day5_1
{
int lowerlimit,upperlimit;
day5_1(int ll,int ul)
{
lowerlimit=ll;
upperlimit=ul;
}
interface iterator
{
public void fact(int l,int u);
public String tostr();
}
class factorial_iterator implements iterator
{
String str="";
	public void fact(int l,int u)
	{
	int i=1,val=1;
	
	while(i<=u)
	{
	 val*=i;
	 if(i==l)
	 str+=val+"";
	 if(i>l)
	 str+=","+val;
	 i++;	
	}
	
	}
	public String tostr()
	{
	 return str;
	}

}

String tostring()
{
factorial_iterator f=new factorial_iterator();
f.fact(lowerlimit,upperlimit);
return f.tostr();
} 

public static void main(String args[])
{
int l,u;
Scanner in=new Scanner(System.in);
l=in.nextInt();
u=in.nextInt();
day5_1 obj=new day5_1(l,u);
System.out.println(obj.tostring());

}



}


