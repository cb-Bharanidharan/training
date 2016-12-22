import java.io.*;
import java.util.*;

class w2day34_3
{

 public static void main(String[] args) throws IOException {


        Scanner in=new Scanner(System.in);
                  try {
            FileReader fileReader = new FileReader("samp.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            File file1 = new File("output.txt");
            FileWriter fw = new FileWriter(file1);
            BufferedWriter bw = new BufferedWriter(fw);
            int cnt=1;
             bw.write("HEY\n");
            String word=in.next();
            while ((line = bufferedReader.readLine()) != null) 
            {
                System.out.println(line);
                if(line.contains(word))
                    {
                        int ind=0;
                                do
                                {

                                     ind=line.indexOf(word,ind);
                                    System.out.print(ind);
                                     bw.write("LINE NO: "+cnt+" INDEX NO: "+ind);
                                        
                                }while(ind>0);
                    }   


                        cnt++;
            }
            System.out.println("TOTAL LINES:"+cnt);
            fileReader.close();
           bw.close();
           fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

         }


  }