import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.DirectoryStream;
import java.util.*;

class w2day34_1
{

 public static void main(String arg[])
 	{


        w2day34_1 dsg = new w2day34_1();
        dsg.searchDirectory("/users/bharanidharan/training", "*.*");
      

 	}


 	public void searchDirectory(String directory, String pattern){
        DirectoryStream<Path> directoryStream = null;
        try{
            directoryStream = Files.newDirectoryStream(Paths
                    .get(directory), pattern);


            HashMap<String,Integer> hm=new HashMap<String,Integer>();  
  				
            for(Path path : directoryStream){
 				int temp;
           
                if(hm.containsKey(path.toString().substring(path.toString().indexOf('.'))))
					{
						temp=hm.get(path.toString().substring(path.toString().indexOf('.')));
						}	
				 else
					{
		 			  temp=0;
		 			}
		 			hm.put(path.toString().substring(path.toString().indexOf('.')),temp+1);
				
    }

            for(Map.Entry m:hm.entrySet()){  
   			System.out.println("TOTAL NUMBER OF FILES OF EXTENSION ["+m.getKey()+"]: "+m.getValue());}  	
 
        }catch(IOException ioe){
            ioe.printStackTrace();
        }finally{
            try{
                directoryStream.close();
            }catch(IOException ioe){
                //Do Nothing
            }
        }
    }




}