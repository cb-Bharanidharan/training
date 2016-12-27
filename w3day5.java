/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week3;


/**
 *
 * @author bharanidharan
 */
import java.sql.*;
import java.util.*;
public class day5 {
    
    public static void main(String args[]) 
    {
        try
        {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/PD","root","");  
        Statement stmt=con.createStatement();  
        ResultSet rs;
        String name="",addr="",mob="",home="",work="";
            Scanner in;
            in = new Scanner(System.in);
            
            System.out.println("1)ADD\n2)UPDATE\n3)SEARCH BY NAME \n4)SEARCH BY NUM\n5)PARTIAL SEARCH");
           int opt=in.nextInt();
            switch(opt)
           {
               case 1:{
               String query="INSERT INTO PHONE (name,address,mobile,home,work)VALUES(?,?,?,?,?)";
               PreparedStatement p=con.prepareStatement(query);
               
               System.out.print("NAME:");
               name=in.next();
               System.out.print("ADDRESS:");
               addr=in.next();
               System.out.print("MOBILE:");
               mob=in.next();
               System.out.print("HOME:");
               home=in.next();
               System.out.print("WORK:");
               work=in.next();
               p.setString(1,name);
               p.setString(2,addr);
               p.setString(3,mob);
               p.setString(4,home);
               p.setString(5,work);
               p.execute();
               } break;
               case 2:{
                       System.out.println("ENTER THE NAME OF THE CONTACT TO BE EDITED:");
                   name=in.next();
               rs=stmt.executeQuery("select * from PHONE where name like '"+name+"'");  
                 while(rs.next())  
                 {
                     System.out.print(rs.getString(1).toUpperCase()+"  "+rs.getString(2).toUpperCase()+"  "+rs.getString(3));
                     System.out.println("  "+rs.getString(4)+"  "+rs.getString(5));
                     name=rs.getString(1);
                     addr=rs.getString(2);
                     mob=rs.getString(3);
                     home=rs.getString(4);
                     work=rs.getString(5);
                 }
                 System.out.println("FIELD TO BE CHANGED:"
                         + "\n1)NAME"
                         + "\n2)ADDRESS"
                         + "\n3)MOBILE"
                         + "\n4)HOME"
                         + "\n5)WORK\n");
                 int ch=in.nextInt();
                 String oname=name;
                    switch(ch)
                    {
                        case 1:name=in.next();break;
                        case 2:addr=in.next();break;
                        case 3:mob=in.next();break;
                        case 4:home=in.next();break;
                        case 5:work=in.next();break;
                            
                    }
                    
                 stmt.executeUpdate("UPDATE PHONE set name='"+name+"'"
                         + ",address='"+addr+"'"
                                 + ",mobile='"+mob+"'"
                                         + ",home='"+home+"'"
                                                 + ",work='"+work+"' where name ='"+oname+"'");
               } break;
               case 3:{
                   System.out.println("ENTER THE NAME:");
                   name=in.next();
               rs=stmt.executeQuery("select * from PHONE where name like '"+name+"'");  
                 while(rs.next())  
                 {
                     System.out.print(rs.getString(1).toUpperCase()+"  "+rs.getString(2).toUpperCase()+"  "+rs.getString(3));
                     System.out.println("  "+rs.getString(4)+"  "+rs.getString(5));
                 }  

               
               } break;
               
               case 4:{
                   System.out.println("ENTER THE NUMBER:");
                   name=in.next();
               rs=stmt.executeQuery("select * from PHONE where mobile like '"+name+"' or home like '"+name+"' or work like '"+name+"'");  
                 while(rs.next())  
                 {
                     System.out.print(rs.getString(1).toUpperCase()+"  "+rs.getString(2).toUpperCase()+"  "+rs.getString(3));
                     System.out.println("  "+rs.getString(4)+"  "+rs.getString(5));
                 }  

               
               } break;
               
               case 5:{
                   System.out.println("ENTER THE INPUT:");
                   name=in.next();
               rs=stmt.executeQuery("select * from PHONE where name like '%"+name+"%' or mobile like '%"+name+"%' or home like '%"+name+"%' or work like '%"+name+"%' or address like '%"+name+"%'");  
                 while(rs.next())  
                 {
                     System.out.print(rs.getString(1).toUpperCase()+"  "+rs.getString(2).toUpperCase()+"  "+rs.getString(3));
                     System.out.println("  "+rs.getString(4)+"  "+rs.getString(5));
                 }  
                
               } break;
           }
            
           con.close(); 
        }
        catch(Exception e)
        { 
            System.out.println(e);
        }  
        
    }
    
}
