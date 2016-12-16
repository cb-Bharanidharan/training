import java.util.*;
class contact
{
String name,addr,mob,hom,wrk;
contact(String n,String a,String m,String h,String w)
{
name=n;
addr=a;
mob=m;
hom=h;
wrk=w;
}
contact(String n,String a,String m)
{
name=n;
addr=a;
mob=m;
hom="---";
wrk="---";
}
contact(String n,String m)
{
name=n;
addr="---";
mob=m;
hom="---";
wrk="---";
}
public void disp()
{
System.out.println("NAME:"+name+" ADDRESS: "+addr+" MOBILE: "+mob+" HOME: "+hom+" WORK: "+wrk);
}
public boolean connum(String num)
{

return mob.equals(num)||hom.equals(num)||wrk.equals(num);

}
}
class w2d12_3
{
	public static void SBNUM(String inp,HashMap<String,List<contact>> hm)
	{
		     for(Map.Entry m:hm.entrySet())
                                        {

                                        for(contact counter: (List<contact>)m.getValue()){
                                        if(counter.connum(inp))
                                        counter.disp();
                                        }
                                }

	}
 	public static void SBNAM(String inp,HashMap<String,List<contact>> hm)
	{
		for(Map.Entry m:hm.entrySet())
                                        {
                                        if(m.getKey().equals(inp))
                                        {
                                               // System.out.print("["+m.getKey()+"]: ");
                                                for(contact counter: (List<contact>)m.getValue()){
                                                        counter.disp();
                                                }
                                        }
		}
	}
	public static void SBPM(String inp,HashMap<String,List<contact>> hm)
	{
		 for(Map.Entry m:hm.entrySet())
                                        {
					String temp=m.getKey()+"";
                                        if(temp.contains(inp))
                                        {
                                               // System.out.print("["+m.getKey()+"]: ");
                                                 for(contact counter: (List<contact>)m.getValue()){
                                                        counter.disp();

                                                 }
                                        }
		}
	}
	public static void main(String args[])
	{
	contact[] c=new contact[4];
	c[0]=new contact("BHARANI","CHENNAI","9791868650","9566443846","8667242606");
	c[1]=new contact("ABI","BANGALORE","9500896214");
	c[2]=new contact("AARU","8668159121");
	c[3]=new contact("AARU","CHENNAI","9486753825");
	int i,opt;
	Scanner in=new Scanner(System.in);
	HashMap<String,List<contact>> hm=new HashMap<String,List<contact>>();
        for(i=0;i<4;i++)
        {
         
         if(hm.containsKey(c[i].name))
                {
                hm.get(c[i].name).add(c[i]);
                }
         else
                {
                 List<contact> a=new ArrayList<contact>();
                 a.add(c[i]);
                 hm.put(c[i].name,a);
                }
        }
	
	System.out.println("CONTACT-LIST");
        for(Map.Entry m:hm.entrySet()){
        System.out.print("["+m.getKey()+"]:\n");
	  for(contact counter: (List<contact>)m.getValue()){
		counter.disp();
		}
	}	
	System.out.println("Search 1)using number 2)Name 3)partial match ");
	opt=in.nextInt();
	String inp;
	switch(opt)
		{
		case 1:{
			System.out.print("ENTER THE NUMBER:");
			inp=in.next();SBNUM(inp,hm);
		}break;
		case 2:{
			System.out.print("ENTER THE NAME:");
			inp=in.next();SBNAM(inp,hm);
			}break;
		case 3:{
			System.out.print("ENTER THE INPUT:");
			inp=in.next();SBPM(inp,hm);


			}break;
	
        }
	
	
	}


}

