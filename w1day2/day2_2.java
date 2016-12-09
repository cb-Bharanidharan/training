import java.util.Scanner;
class day2_2
{



public static void main(String args[])
{
	Scanner in=new Scanner(System.in);
	int [][] a=new int[3][3];
	int i,j;
	for(i=0;i<3;i++)
	{	
		for(j=0;j<3;j++)
		{
			System.out.print("ENTER a["+(i+1)+"]["+(j+1)+"]:");
			a[i][j]=in.nextInt();	 
		}
	}

	System.out.print("ROTATE (LEFT-L/RIGHT-R):");
	char ch=in.next().charAt(0);
	switch(ch)
		{
		 case 'L':
		 case 'l':{
				for(i=2;i>=0;i--)
					{
					for(j=0;j<3;j++)
					System.out.print(" "+a[j][i]);					
					System.out.println();
					}
			  }
				break;
		 case 'R':
		 case 'r':
			 {
				for(i=0;i<3;i++)
                                        {
                                        for(j=2;j>=0;j--)
                                        System.out.print(" "+a[j][i]);           
                                        System.out.println();
                                        }
				
			 }
				break;		 	
		default:System.out.println("INVALID CHOICE");
		}		
}


}
