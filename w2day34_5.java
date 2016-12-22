import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileNotFoundException;


class Contact {
    
    private String name;
    private String address;
    private String mob;
    private String home;
    private String work;    
    
    public Contact(String name, String address, String mob,String home,String work) {
        this.name = name;
        this.address = address;
        this.mob = mob;
        this.home = home;
        this.work = work;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getMob() {
        return mob;
    }
    public String getHome() {
        return home;
    }
    public String getWork() {
        return work;
    }
    public boolean belongsto(String num)
    {
        return mob.equals(num)||home.equals(num)||work.equals(num);

    }
    @Override
    public String toString() {
        return "Contact [ Name=" + name+ ", Address=" + address + ", Mobile =" + mob + ", Home ="+home+", Work ="+work+"]";
    }
}


class CsvFileReader {
    

    private static final String [] FILE_HEADER_MAPPING = {"name","address","mob","home","work"};
    
    private static final String Contact_NAME = "name";
    private static final String Contact_ADDR = "address";
    private static final String Contact_MOB = "mob"; 
    private static final String Contact_HOME = "home"; 
    private static final String Contact_WORK = "work"; 
    
    public static List<Contact> readCsvFile(String fileName) {

        FileReader fileReader = null;
        
        CSVParser csvFileParser = null;
        
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
     
            List<Contact> Contacts = new ArrayList<Contact>();
        try {
            
            
            
            fileReader = new FileReader(fileName);
            
            csvFileParser = new CSVParser(fileReader, csvFileFormat);
            
            List<CSVRecord> csvRecords = csvFileParser.getRecords(); 
            
            for (int i = 1; i < csvRecords.size(); i++) {
                CSVRecord record = csvRecords.get(i);
                Contact Contact = new Contact(record.get(Contact_NAME), record.get(Contact_ADDR), record.get(Contact_MOB), record.get(Contact_HOME), record.get(Contact_WORK));
                Contacts.add(Contact);  
            }
            
            for (Contact Contact : Contacts) {
                System.out.println(Contact.toString());
            }
        } 
        catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                fileReader.close();
                csvFileParser.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader/csvFileParser !!!");
                e.printStackTrace();
            }
        }

            return Contacts;
    }

}


class w2day34_5
{

    public static void SBNUM(String inp,List<Contact> Cont)
    {
             for(Contact Contct : Cont)
                                        {

                                        if(Contct.belongsto(inp))
                                            System.out.println(Contct.toString());
                                        }
                                }

    
    public static void SBNAM(String inp,List<Contact> Cont)
    {
        for(Contact Contct : Cont)
                                        {
                                            Contct.toString();
                                        if(Contct.getName().equals(inp))
                                        {
                                                         System.out.println(Contct.toString());
                                        
                                        }
                                        }
        
    }
    public static void SBPM(String inp,List<Contact> Cont)
    {
         for(Contact Contct : Cont)
                                        {
                                        if(Contct.getName().contains(inp))
                                        {
                                             System.out.println(Contct.toString());
                                        

                                        }
                                }
        
    }

    public static void main(String[] args) {
        
        String fileName = "phone.csv";    
        System.out.println("\nRead CSV file:");
        List<Contact> cont=CsvFileReader.readCsvFile(fileName);
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

    }

}