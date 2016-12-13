package animals;
import java.util.*;
public class day3_1
{
String name,type,live;
Scanner in=new Scanner(System.in);
static int cnt=0; 
public void get_animal()
{
System.out.print("NAME:");
name=in.next();
System.out.print("TYPE(D-DOMESTIC/W-WILD):");
type=in.next();
System.out.print("LIVES IN:");
live=in.next();

}
public void print_animal()
{
System.out.println("NAME:"+name+"\nTYPE:"+type+"\nLIVES IN:"+live);
}
public day3_1()
{
System.out.println("NUMBER OF ANIMALS:"+cnt++);
}

}
