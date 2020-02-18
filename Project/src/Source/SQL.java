
package Source;
import java.util.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQL {
    private Connection conn = null;
    public void OpenConnection(){
        
        
    try { 
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        String username = "root";
        String password = "";
        String url = "jdbc:MySQL://localhost/project";
        conn = DriverManager.getConnection(url, username, password);
        System.err.println("Opening MYSQL Connection .....\n");
        
        System.out.println("MYSQL Connection Established.");
           
    }catch(SQLException e){
        System.err.println("Cannot Connect to the server"+e.getMessage());
        }
    }
    
    
    public void InsertStudent(ArrayList<Student> a){
    
         try{
               String query = "insert into student (id, name, depart, mark1, mark2) values(?,?,?,?,?)";
               PreparedStatement preparedstmt = conn.prepareStatement(query);
               if(a.isEmpty()){
                  System.out.println("Nothing to update");
                }
              else{
                                
                    for(int i=0;i<a.size();i++){
                        preparedstmt.setInt(1, a.get(i).GetId());
                        preparedstmt.setString(2, a.get(i).GetName());
                        preparedstmt.setInt(3, a.get(i).GetDepart());
                        preparedstmt.setDouble(4, a.get(i).GetMark1());
                        preparedstmt.setDouble(5, a.get(i).GetMark2());
                        preparedstmt.execute();}
                        System.out.println("Student Table updated");
                  }
                                
                                               
        }catch(SQLException e){
            System.out.println("Update failed!"+e.getMessage());
             
        }
    
    
    }
    public void InsertTeacher(ArrayList<Teacher> a){
    
         try{
              String query = "insert into teacher (id, name,depart, salary, degree)" + "values(?,?,?,?,?)";
              PreparedStatement preparedstmt = conn.prepareStatement(query);
              if(a.isEmpty()){
                   System.out.println("Nothing to update");
              }
              else{
                    for(Teacher t : a){
                           preparedstmt.setInt(1, t.GetId());
                           preparedstmt.setString(2, t.GetName());
                           preparedstmt.setInt(3, t.GetDepart());
                           preparedstmt.setDouble(4, t.GetSalary());
                           preparedstmt.setString(5, t.GetDegree());
                           preparedstmt.execute();}
                           System.out.println("Teacher Table Updated");
                 }
                                
                                               
            }catch(SQLException e){
                  System.out.println("update failed!"+e.getMessage());
                               
            }
    
    
    }
    public ArrayList<Student> SelectStudent(){
        ArrayList<Student> ADbase=new ArrayList<>();
        try{   
              String query = "SELECT * FROM student";
              Statement importDB = conn.createStatement();
              ResultSet result = importDB.executeQuery(query);
            
              while(result.next()){
                 Student st = new Student();
                 st.SetId(result.getInt("id"));
                 st.SetName(result.getString("name"));
                 st.SetDepart(result.getInt("depart"));
                 st.SetMark1( result.getDouble("mark1"));
                 st.SetMark2(result.getDouble("mark2"));
                 ADbase.add(st);            
              }
        }catch(SQLException e){
            System.out.println("update failed!"+e.getMessage());
        }
    
        return ADbase;
    }
    
    public ArrayList<Teacher> SelectTeacher(){
        ArrayList<Teacher> ADbase=new ArrayList<>();
        try{   
            String query = "SELECT * FROM teacher";
            Statement importDB = conn.createStatement();
            ResultSet result = importDB.executeQuery(query);
            
            while(result.next()){
                Teacher t = new Teacher();
                t.SetId(result.getInt("id"));
                t.SetName(result.getString("name"));
                t.SetDepart(result.getInt("depart"));
                t.SetSalary(result.getDouble("salary"));
                t.SetDegree(result.getString("degree"));
                ADbase.add(t);            
            }
        }catch(SQLException e){
             System.out.println("update failed!"+e.getMessage());
        }
    
        return ADbase;
    }
    public void CloseConnection (){
         try {
            if(conn !=null){
            System.err.println("Closing MYSQL Connection ....."+"\n");
            System.out.println("MY SQL Connection Closed");
            conn.close();
            }
         }catch(SQLException e){
            System.err.println("Error while closing the Connection");
            System.err.println(e.getMessage());
         }
     
    }
    public void DuplicatedInsertStudent(ArrayList<Student> a){
         ArrayList<Student> ADbase=new ArrayList<>();
        try{   
              String query = "SELECT * FROM student";
              Statement importDB = conn.createStatement();
              ResultSet result = importDB.executeQuery(query);
            
              while(result.next()){
                 Student st = new Student();
                 st.SetId(result.getInt("id"));
                 st.SetName(result.getString("name"));
                 st.SetDepart(result.getInt("depart"));
                 st.SetMark1( result.getDouble("mark1"));
                 st.SetMark2(result.getDouble("mark2"));
                 ADbase.add(st);            
              }
        }catch(SQLException e){
            System.out.println("update failed!"+e.getMessage());
        }
         try{
               String query = "insert into student (id, name, depart, mark1, mark2) values(?,?,?,?,?)";
               PreparedStatement preparedstmt = conn.prepareStatement(query);
               if(a.isEmpty()){
                  System.out.println("Nothing to update Student");
                }
              else{
                   int temp=0;  
                   for(int i=0; i<a.size();i++) {       
                          int count=0;  
                          for(int j=0; j<ADbase.size();j++){
                               
                              if(a.get(i).GetId()==ADbase.get(j).GetId())
                                      count+=1;}
                              if(count==0){
                                     preparedstmt.setInt(1, a.get(i).GetId());
                                     preparedstmt.setString(2, a.get(i).GetName());
                                     preparedstmt.setInt(3, a.get(i).GetDepart());
                                     preparedstmt.setDouble(4, a.get(i).GetMark1());
                                     preparedstmt.setDouble(5, a.get(i).GetMark2());
                                     preparedstmt.execute();
                                     temp+=1;
                              }
                                      
                       }
                      System.out.println(temp +" Record Student Inserted.");
               }         
                                               
        }catch(SQLException e){
            System.out.println("Update failed!"+e.getMessage());
             
        }
        
    }
    public void DuplicatedInsertTeacher(ArrayList<Teacher> a){
         ArrayList<Teacher> TDbase=new ArrayList<>();
        try{   
              String query = "SELECT * FROM teacher";
              Statement importDB = conn.createStatement();
              ResultSet result = importDB.executeQuery(query);
            
              while(result.next()){
                 Teacher t = new Teacher();
                 t.SetId(result.getInt("id"));
                 t.SetName(result.getString("name"));
                 t.SetDepart(result.getInt("depart"));
                 t.SetSalary(result.getDouble("salary"));
                 t.SetDegree(result.getString("degree"));
                 TDbase.add(t);            
              }
        }catch(SQLException e){
            System.out.println("update failed!"+e.getMessage());
        }
         try{
               String query = "insert into teacher (id, name, depart, salary, degree) values(?,?,?,?,?)";
               PreparedStatement preparedstmt = conn.prepareStatement(query);
               if(a.isEmpty()){
                  System.out.println("Nothing to update Teacher");
                }
              else{
                   int temp=0;  
                   for(int i=0; i<a.size();i++) {       
                          int count=0; 
                          for(int j=0; j<TDbase.size();j++){
                                 
                              if(a.get(i).GetId()==TDbase.get(j).GetId())
                                      count+=1;}
                              if(count==0){
                                     preparedstmt.setInt(1, a.get(i).GetId());
                                     preparedstmt.setString(2, a.get(i).GetName());
                                     preparedstmt.setInt(3, a.get(i).GetDepart());
                                     preparedstmt.setDouble(4, a.get(i).GetSalary());
                                     preparedstmt.setString(5, a.get(i).GetDegree());
                                     preparedstmt.execute();
                                     temp+=1; 
                              }
                                     
                    }
                      System.out.println(temp +" Record Teacher Inserted.");
               }         
                                               
        }catch(SQLException e){
            System.out.println("Update failed!"+e.getMessage());
             
        }    
    }
}
