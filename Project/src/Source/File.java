package Source;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class File {
   
    private  BufferedReader in;
    private  FileReader read;
    private  FileWriter write;

    public String ReadStringStudent(){
        String temp="" ;
        String result;
        try{
             read=new FileReader("student.txt");
             in= new BufferedReader(read);
             result=in.readLine();
             while(result!=null){
                 temp+=result;
                 temp+="\n";
                 result=in.readLine();
        
            }
            read.close();
            in.close();
            System.out.println("File Student imported.");
        }catch(IOException e)
            {System.out.println(e.getMessage());}
        return temp;
    }
    public String ReadStringTeacher(){
        String temp ="";
        String result;
        try{
               read=new FileReader("teacher.txt");
               in= new BufferedReader(read);
               result=in.readLine();
               while(result!=null){
                   temp+=result; 
                   temp+="\n";
                   result=in.readLine();
        
                }
               read.close();
               in.close();
               System.out.println("File Teacher imported.");
        }catch(IOException e)
            {System.out.println(e.getMessage());}
        return temp;
    } 
    public ArrayList<Student> ReadArrayStudent(){
        
         ArrayList<Student> AFile=new ArrayList<Student>();
         try{
                String[] elmt=null;
       
                read=new FileReader("student.txt");
                in= new BufferedReader(read);
        
                String line = in.readLine();
                while(line!=null){
                    elmt = line.split(",");
                    Student s1 = new Student();
                    s1.SetId(Integer.valueOf(elmt[0]));
                    s1.SetName(elmt[1]);
                    s1.SetDepart(Integer.valueOf(elmt[2]));
                    s1.SetMark1(Double.parseDouble(elmt[3]));
                    s1.SetMark2(Double.parseDouble(elmt[4]));
                    AFile.add(s1);
                    line = in.readLine();                
                } 
                read.close();
                in.close();
         System.out.println("File Student imported.");
         }catch(IOException e)
            {System.out.println(e.getMessage());}
        
        
         return AFile;
        
    }
    public ArrayList<Teacher> ReadAraayTeacher(){
         ArrayList<Teacher> TFile=new ArrayList<>();
         try{
              String[] elmt=null;
       
              read=new FileReader("teacher.txt");
              in= new BufferedReader(read);
        
              String line = in.readLine();
              while(line!=null){
                elmt = line.split(",");
                Teacher t1=new Teacher(); 
                t1.SetId(Integer.valueOf(elmt[0]));
                t1.SetName(elmt[1]);
                t1.SetDepart(Integer.parseInt(elmt[2]));
                t1.SetSalary(Double.parseDouble(elmt[3]));
                t1.SetDegree(elmt[4]);
                TFile.add(t1);
                line = in.readLine();                
              } 
             read.close();
             in.close(); 
             System.out.println("File Teacher imported.");
         }catch(IOException e)
         {
             System.out.println(e.getMessage());}
        
        
         return TFile;
    
    } 
     public void WriteStudent(ArrayList<Student> a ){
        try{
            if(a.isEmpty())
            {
                System.out.println("Record not find to Update Student File");
            }
            else{
                String str="";
                write= new FileWriter("student1.txt",true);
                for (Student s: a)
                    str += "\n"+s.GetId()+","+s.GetName()+","+s.GetDepart()+","+s.GetMark1()+','+s.GetMark2()+"\n";
                write.write(str);
                
                write.close();
                System.out.println("File Student has been written");
               }
        }catch (IOException e){
            System.out.println(e.getMessage());}
    
    }
    public void WriteTeacher(ArrayList<Teacher> a ){
        try{
            if(a.isEmpty())
               System.out.print("Record not find to Update Teacher File");
            else{
                String str="";
               write= new FileWriter("teacher1.txt",true);
                for (Teacher t: a)
                    str +="\n" +t.GetId()+","+t.GetName()+","+t.GetDepart()+","+t.GetSalary()+','+t.GetDegree()+"\n";
                write.write(str);
           
                write.close();
                System.out.println("File Teacher has been written");
           }
        }catch (IOException e){
                System.out.println(e.getMessage());}
    
    }
}
