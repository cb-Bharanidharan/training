import java.io.*;
import java.util.*;

class w2day34_2
{

 public static void main(String[] args) throws IOException {

        HashMap<String,Integer> hm = new HashMap<String,Integer>();

        Scanner s = new Scanner(new BufferedReader(new FileReader("samp.txt")));


        String temp;

            while (s.hasNext()) {

                temp = s.next();


                if(hm.get(temp) != null)

                        hm.put(temp,hm.get(temp)+1);

                else

                        hm.put(temp,1);

            }

                s.close();



         FileWriter out = new FileWriter("out.txt");


         for(String key : hm.keySet()){

                 temp = "\n["+key+"] : ["+hm.get(key)+"]";

                 out.write(temp);

        }


         out.close();

         }


  }