import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.CSVPrinter;




class Student {
    
    private String firstName;
    private String lastName;
    private String mail;
    
    public Student(String firstName, String lastName, String mail) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mail = mail;
        
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    
    @Override
    public String toString() {
        return "Student [ FirstName=" + firstName+ ", LastName=" + lastName + ", MAIL=" + mail + "]";
    }
}


class CsvFileReader {
    

    private static final String [] FILE_HEADER_MAPPING = {"firstName","lastName","mail"};
    
    private static final String STUDENT_FNAME = "firstName";
    private static final String STUDENT_LNAME = "lastName";
    private static final String STUDENT_MAIL = "mail"; 
    
    public static List<Student> readCsvFile(String fileName) {

        FileReader fileReader = null;
        
        CSVParser csvFileParser = null;
        
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withHeader(FILE_HEADER_MAPPING);
     
            List<Student> students = new ArrayList<Student>();
        try {
            
            
            
            fileReader = new FileReader(fileName);
            
            csvFileParser = new CSVParser(fileReader, csvFileFormat);
            
            List<CSVRecord> csvRecords = csvFileParser.getRecords(); 
            
            for (int i = 1; i < csvRecords.size(); i++) {
                CSVRecord record = csvRecords.get(i);
                Student student = new Student(record.get(STUDENT_FNAME), record.get(STUDENT_LNAME), record.get(STUDENT_MAIL));
                students.add(student);  
            }
            
            for (Student student : students) {
                System.out.println(student.toString());
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

            return students;
    }

}

class CsvFileWriter {
    
    
    private static final String NEW_LINE_SEPARATOR = "\n";
    
    private static final Object [] FILE_HEADER = {"firstName","lastName","mail"};

    public static void writeCsvFile(String fileName,List<Student> students) {
        
    
        FileWriter fileWriter = null;
        
        CSVPrinter csvFilePrinter = null;
        
        
        CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
                
        try {
            
            fileWriter = new FileWriter(fileName);
            

            csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
  
            csvFilePrinter.printRecord(FILE_HEADER);
            HashMap<String,Student> s=new HashMap<String,Student>();
            for(Student student:students)
                 {
                    s.put(student.getMail(),student);
                 }   
                 System.out.println("OUTPUT:");
                 for(Map.Entry m:s.entrySet())
                 {
                        Student a=(Student)m.getValue();
                        System.out.println(a.toString());
                  List<String> studentDataRecord = new ArrayList<String>();
                studentDataRecord.add(a.getFirstName());
                studentDataRecord.add(a.getLastName());
                studentDataRecord.add(a.getMail());
                csvFilePrinter.printRecord(studentDataRecord);
                }

            System.out.println("CSV file was created successfully !!!");
            
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
                csvFilePrinter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter/csvPrinter !!!");
                e.printStackTrace();
            }
        }
    }
}


public class w2day34_4{

    public static void main(String[] args) {
        
        String fileName = "sample.csv";    
        System.out.println("\nRead CSV file:");
        List<Student> stud=CsvFileReader.readCsvFile(fileName);
        String fileName2="output.csv";
        CsvFileWriter.writeCsvFile(fileName2,stud);

    }

}