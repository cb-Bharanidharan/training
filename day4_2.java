import java.util.*;
interface herbi
{
public boolean isherbi();
}
interface fly
{
public boolean canfly();
}


abstract class animal
{

abstract void setname(String nme);

}

class mammal extends animal
{
String name;

public void setname(String nme)
{
name=nme;
}
}

class bird extends animal
{
String name;
public void setname(String nme)
{
name=nme;
}
}

class bat extends mammal implements fly,herbi
{
public boolean canfly()
{
return true;
}
public boolean isherbi()
{
return false;
}
}

class dog extends mammal implements fly,herbi
{
public boolean canfly()
{
return false;
}
public boolean isherbi()
{
return false;
}
}

class cow extends mammal implements fly,herbi
{
public boolean canfly()
{
return false;
}
public boolean isherbi()
{
return true;
}
}

class ostrich extends bird implements fly,herbi
{

public boolean canfly()
{
return false;
}
public boolean isherbi()
{
return true;
}
}

class parrot extends bird implements fly,herbi
{
public boolean canfly()
{
return true;
}
public boolean isherbi()
{
return true;
}
}

class day4_2
{

public static void main(String args[])
{
bat b=new bat();
dog d=new dog();
cow c=new cow();
ostrich o=new ostrich();
parrot p=new parrot();
b.setname("BAT");
d.setname("DOG");
c.setname("COW");
o.setname("OSTRICH");
p.setname("PARROT");
int i;
System.out.println("ANIMALS THAT CAN FLY!!!");
if(b.canfly())
{
System.out.println(b.name);
}
if(c.canfly())
{
System.out.println(c.name);
}
if(d.canfly())
{
System.out.println(d.name);
}
if(o.canfly())
{
System.out.println(o.name);
}
if(p.canfly())
{
System.out.println(p.name);
}

System.out.println("ANIMALS THAT ARE HERBIVOROUS");
if(b.isherbi())
{
System.out.println(b.name);
}
if(c.isherbi())
{
System.out.println(c.name);
}
if(d.isherbi())
{
System.out.println(d.name);
}
if(o.isherbi())
{
System.out.println(o.name);
}
if(p.isherbi())
{
System.out.println(p.name);
}

}



}
