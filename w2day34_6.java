import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.*;
class Student
{
String name,id,doj,std;
List<String> sub; 
List<Long> mark;
	Student(String n,String i,String d,String st,List<String> s ,List<Long> m)
		{
			name=n;
			id=i;
			doj=d;
			std=st;
			sub=s;
			mark=m;
		}
		public void display()
		{
			System.out.println(name+" "+id+" "+doj+" "+std+" "+sub+" "+mark);

		}
 }

class Teacher
{
String name,id,doj;
long sal;
List<String> ct;

	Teacher(String n,String i,String d,long s,List<String> c)
		{
			name=n;id=i;doj=d;sal=s;ct=c;

		}
	public void display()
		{
			System.out.println(name+" "+id+" "+doj+" "+sal+" "+ct);

		}	


}

class w2day34_6 {
     public static void main(String[] args) {

	JSONParser parser = new JSONParser();

	try {

		Object obj = parser.parse(new FileReader("S-T.json"));

		JSONObject jsonObject = (JSONObject) obj;


		JSONObject jsonObject2 = (JSONObject)jsonObject.get("Student"); 
		String name = (String)jsonObject2.get("Name");
		System.out.println(name);
		String id = (String)jsonObject2.get("ID");
		System.out.println(id);
		String doj = (String)jsonObject2.get("Date Of Joining");
		System.out.println(doj);
		String std = (String)jsonObject2.get("Std");
		System.out.println(std);
		List<String> sb=new ArrayList<String>();
		List<Long> m=new ArrayList<Long>();
		JSONArray msg = (JSONArray) jsonObject2.get("Marks");
		Iterator iterator = msg.iterator();
		while (iterator.hasNext()) {
			JSONObject t=(JSONObject) iterator.next();
			sb.add((String)t.get("Subject"));
			m.add((Long)t.get("Mark"));		
			}
		Student s=new Student(name,id,doj,std,sb,m);	
		s.display();
		jsonObject2 = (JSONObject)jsonObject.get("Teacher"); 
		name = (String)jsonObject2.get("Name");
		System.out.println(name);
		 id = (String)jsonObject2.get("ID");
		System.out.println(id);
		 doj = (String)jsonObject2.get("Date Of Joining");
		System.out.println(doj);
		long sal = (long)jsonObject2.get("Salary");
		System.out.println(sal);
		List<String> c=new ArrayList<String>();
		msg = (JSONArray) jsonObject2.get("Classes Taking Care Of");
		Iterator<String> iter = msg.iterator();
		while (iter.hasNext()) {
			//JSONObject t=(JSONObject) iterator.next();
			c.add(iter.next());
			
			}
		Teacher t=new Teacher(name,id,doj,sal,c);
			t.display();






	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} catch (ParseException e) {
		e.printStackTrace();
	}

     }

}