import animals.day3_1;
import java.util.*;
class day3_1a
{
public static void main(String[] args){
	int opt=0;
	Scanner in=new Scanner(System.in);
	do
	{
	day3_1 a = new day3_1();
	a.get_animal();
	a.print_animal();
	System.out.print("Do you want insert more animals(1.YES/0.NO):");
	opt=in.nextInt();
	}while(opt==1);
}

}
