import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
public String getName()
{

		return name;
}
public void disp()
{
System.out.println("NAME:"+name+" ADDRESS: "+addr+" MOBILE: "+mob+" HOME: "+hom+" WORK: "+wrk);
}
public boolean belongsto(String num)
{

return mob.equals(num)||hom.equals(num)||wrk.equals(num);

}

}



class w2day34_7 {


 public static void SBNUM(String inp,List<contact> Cont)
    {
             for(contact Contct : Cont)
                                        {

                                        if(Contct.belongsto(inp))
                                            Contct.disp();
                                        }
                                }

    
    public static void SBNAM(String inp,List<contact> Cont)
    {
        for(contact Contct : Cont)
                                        {
                                            Contct.toString();
                                        if(Contct.getName().equals(inp))
                                        {
                                                         Contct.disp();
                                        
                                        }
                                        }
        
    }
    public static void SBPM(String inp,List<contact> Cont)
    {
         for(contact Contct : Cont)
                                        {
                                        if(Contct.getName().contains(inp))
                                        {
                                             Contct.disp();
                                        

                                        }
                                }
        
    }




     public static void main(String[] args) {

	JSONParser parser = new JSONParser();

	try {

		Object obj = parser.parse(new FileReader("contact.json"));

		JSONObject jsonObject = (JSONObject) obj;

			JSONArray msg = (JSONArray) jsonObject.get("Contacts"); 
		Iterator iterator = msg.iterator();
		List<contact> cont=new ArrayList<contact>();
		while (iterator.hasNext()) {
			JSONObject t=(JSONObject) iterator.next();
			contact c=new contact((String)t.get("Name"),(String)t.get("Address"),(String)t.get("Mobile"),(String)t.get("Home"),(String)t.get("Work"));
			cont.add(c);
			}
		

			int opt;
        Scanner in=new Scanner(System.in);
        System.out.println("Search 1)using number 2)Name 3)partial match ");
            opt=in.nextInt();
            String inp;
             switch(opt)
                 {
                    case 1:{
                     System.out.print("ENTER THE NUMBER:");
                     inp=in.next();
                     SBNUM(inp,cont);
                      }break;
                    case 2:{
                    System.out.print("ENTER THE NAME:");
                    inp=in.next();
                    SBNAM(inp,cont);
                    
                     }break;
                    case 3:{
                    System.out.print("ENTER THE INPUT:");
                    inp=in.next();
                    SBPM(inp,cont);
                    }break;
    
                }

		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}

     }

}