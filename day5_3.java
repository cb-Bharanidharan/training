import java.util.*;
class employee
{
String name;
int salary,age;
employee(String n,int s,int a)
{
name=n;
salary=s;
age=a;
}
public String getname()
{
return name;
}
public int getsal()
{
return salary;
}
void display()
{
System.out.println("NAME:"+name+"\tSALARY:"+salary+"\tAGE:"+age);
}



	public int compareTo(employee e) {

		int compareQuantity = ((employee) e).getsal();

		return this.salary - compareQuantity;

	}

	public static Comparator<employee> empcomp
                          = new Comparator<employee>() {

	    public int compare(employee e1,employee e2) {

	      String Name1 = e1.getname().toUpperCase();
	      String Name2 = e2.getname().toUpperCase();

	      return e1.compareTo(e2);

	      
	    }

	};





}
class day5_3
{

	public static void main(String args[])
	{
	employee[]e=new employee[3];
	e[0]=new employee("A",1500,20);
        e[1]=new employee("B",2500,22);
        e[2]=new employee("C",1800,21);
	int i;
 	Arrays.sort(e,employee.empcomp);
	for(i=0;i<3;i++)
		e[i].display();	
	}	




}
