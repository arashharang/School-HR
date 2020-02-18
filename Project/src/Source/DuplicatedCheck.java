
package Source;

import java.util.*;

public class DuplicatedCheck {
    
    // ArrayList<Student> SFile = new ArrayList<>();
     //ArrayList<Student> SDbase = new ArrayList<>();  
    
     DuplicatedCheck(){}
     
     public boolean InStudent(ArrayList<Student> a,ArrayList<Student> b,ArrayList<Student> c, int d){
         boolean key=true;
         int count;
         count=a.size();
         for(int i=0; i<count;i++)
            {
                if(a.get(i).GetId()==d){
                    key=false;
                System.err.println("This ID is available in the DataBase");
                }
            }
         count=b.size();
         for(int i=0; i<count;i++)
            {
                if(b.get(i).GetId()==d){
                    key=false;
                System.err.println("This ID is available in the File");
                }
            }
         count=c.size();
         for(int i=0; i<count;i++)
            {
                if(c.get(i).GetId()==d){
                    key=false;
                System.err.println("This ID is available in new records, Update records");
                }
            }
     
         return key;
     }
     public boolean InTeacher(ArrayList<Teacher> a,ArrayList<Teacher> b,ArrayList<Teacher> c, int d){
         boolean key=true;
         int count;
         count=a.size();
         for(int i=0; i<count;i++)
            {
                if(a.get(i).GetId()==d){
                    key=false;
                    System.err.println("This ID is available in the DataBase");
                }
            }
         count=b.size();
         for(int i=0; i<count;i++)
            {
                if(b.get(i).GetId()==d){
                    key=false;
                    System.err.println("This ID is available in the File");
                }
            }
         count=c.size();
         for(int i=0; i<count;i++)
            {
                if(c.get(i).GetId()==d){
                    key=false;
                    System.err.println("This ID is available in new records, Update records");
                }
            }
     
         return key;
     }
 
    
}
