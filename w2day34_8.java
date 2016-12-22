import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;
import java.io.FileNotFoundException;
import java.io.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.text.*;


class w2day34_8
{
 private static String [] FILE_HEADER_MAPPING = {"Customer Id","Subscription Id","Invoice Number",
    "Invoice Date","Start Date","Amount","Status","Paid On","Next Retry","Refunded Amount","Recurring","First Invoice",
    "Customer First Name","Customer Last Name","Customer Email","Customer Company","Tax Total"};

    private static final String NEW_LINE_SEPARATOR = "\n";
    
    private static final Object [] FILE_HEADER = {"Customer Id","Subscription Id","Invoice Number",
    "Invoice Date","Start Date","Amount","Status","Paid On","Next Retry","Refunded Amount","Recurring","First Invoice",
    "Customer Details","Tax Total"};
    
    public static void readCsvFile(String fileName,String fileName2) {

        FileReader fileReader = null;
        
        CSVParser csvFileParser = null;
        
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
     

         FileWriter fileWriter = null;
        
        CSVPrinter csvFilePrinter = null;
        
        
        CSVFormat csvFileFormat2 = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
                



		JSONParser parser = new JSONParser();

        try {
            
            
            
            fileReader = new FileReader(fileName);
            
            csvFileParser = new CSVParser(fileReader, csvFileFormat);
            Object obj = parser.parse(new FileReader("config.json"));

			JSONObject jsonObject = (JSONObject) obj;
			fileWriter = new FileWriter(fileName2);
            csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat2);
            csvFilePrinter.printRecord(FILE_HEADER);
            

            
            List<CSVRecord> csvRecords = csvFileParser.getRecords(); 
            
            for (int i = 1; i < csvRecords.size(); i++) {

            	System.out.println("\n RECORD "+i);
                CSVRecord record = csvRecords.get(i);
                List<String> custRecord = new ArrayList<String>();

                for(int j=0;j<FILE_HEADER_MAPPING.length;j++)
      	     		{
      	     			System.out.println(record.get(j)+"-"+FILE_HEADER_MAPPING[j]);	
      	     			JSONObject jO=(JSONObject)jsonObject.get(FILE_HEADER_MAPPING[j]);
      	     			if((boolean)jO.get("change"))
      	     			{

      	     				switch(jO.get("code")+"")
      	     					{
      	     						case "1":{
      	     								System.out.print(jO.get("comment"));
      	     									Double val=Double.parseDouble(record.get(j));
      	     										val=val/10;
      	     										custRecord.add(val+"");
      	     								} 
      	     								break;
      	     						case "2":{
      	     								System.out.print(jO.get("comment"));
      	     								if(record.get(j).length()>0)
      	     								{	
      	     								String dateStr = record.get(j);
										    DateFormat srcDf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
									        Date date = srcDf.parse(dateStr);
								            DateFormat destDf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
            								dateStr = destDf.format(date);
            								System.out.println("Converted date is : " + dateStr);

            								custRecord.add(dateStr);	
            								}
            								else
            									{
            										custRecord.add(record.get(j));
            									}	

      	     								} break;
      	     						case "3":{
      	     								System.out.print(jO.get("comment"));
      	     									Double val=Double.parseDouble(record.get(j));
      	     										val=val/100;
      	     										custRecord.add(val+"");
      	     								} break;
      	     						case "4":{	
      	     								System.out.println(jO.get("comment"));
                             JSONObject objt = new JSONObject();
                              objt.put("{FirstName:",record.get(j++)+"}"); 
                              objt.put("{LastName:", record.get(j++)+"}");
                              objt.put("{Email:", record.get(j++)+"}");
                              objt.put("{Company:", record.get(j)+"}"); 
                                custRecord.add(objt+"");
      	     								} break;

      	     					}

      	     			}
      	     			else
      	     			{
      	     				custRecord.add(record.get(j));
      	     			}


                
            		}
            
	            csvFilePrinter.printRecord(custRecord);
            
            }
            
    
        } 
                catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        }
         finally {
            			try {
                fileReader.close();
                csvFileParser.close();
            		} 
            		catch (IOException e) {
                							System.out.println("Error while closing fileReader/csvFileParser !!!");
                							e.printStackTrace();
            	}
        }

            
    }

    

            




    public static void main(String args[])
    {
    
    	readCsvFile("Input.csv","Cust.csv");

    }
 }   





