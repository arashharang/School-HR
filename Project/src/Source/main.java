
package Source;

import java.util.*;

public class main {
    public static void main(String args[]) {
        ArrayList <Student> ArrayStudent1 = new ArrayList <>();
        ArrayList <Student> ArrayStudent2 = new ArrayList <>();
        ArrayList <Teacher> ArrayTeacher1 = new ArrayList <>();
        ArrayList <Teacher> ArrayTeacher2 = new ArrayList <>();
        ArrayList<Student> SFile = new ArrayList<>();
        ArrayList<Student> SDbase = new ArrayList<>();  
        ArrayList<Teacher> TFile = new ArrayList<>();
        ArrayList<Teacher> TDbase= new ArrayList<>();
        ArrayList<Student> SFlocal=new ArrayList<>();
        ArrayList<Teacher> TFlocal=new ArrayList<>();
        ArrayList<Student> SSlocal=new ArrayList<>();
        ArrayList<Teacher> TSlocal=new ArrayList<>();
        File File=new File();
        DuplicatedCheck Duplicated= new DuplicatedCheck();
        SQL SQL=new SQL();
        int temp;
        
        Scanner sc = new Scanner(System.in);
        int i;
        boolean key = true;
        SFile=File.ReadArrayStudent();
        TFile=File.ReadAraayTeacher();
        for(i=0; i<SFile.size();i++){
            if(SFile.get(i).GetDepart()==1){
               ArrayStudent1.add(SFile.get(i));
          }
            else if(SFile.get(i).GetDepart()==2){
                ArrayStudent2.add(SFile.get(i));
           }
        }
        for(i=0;i<TFile.size();i++){
            if(TFile.get(i).GetDepart()==1){
                ArrayTeacher1.add(TFile.get(i));
            }
            else if(TFile.get(i).GetDepart()==2){
                ArrayTeacher2.add(TFile.get(i));
            }
        }
        //System.out.println(SFile);
        //System.out.println(TFile);
        SQL.OpenConnection();
        SQL.DuplicatedInsertStudent(ArrayStudent1);
        SQL.DuplicatedInsertStudent(ArrayStudent2);
        SQL.DuplicatedInsertTeacher(ArrayTeacher1);
        SQL.DuplicatedInsertTeacher(ArrayTeacher2);
        while(key==true){
             System.out.println("\n");
             System.out.println("Select option : ");
             System.out.println("1.  Display Student ArrayList 1\n" +
                           "2.  Display Student ArrayList 2\n" +
                           "3.  Display Teacher ArrayList 1\n" +
                           "4.  Display Teacher ArrayList 2\n" +
                           "5.  Update both Tables\n" +
                           "6.  Write New Records to other Files\n"+
                           "7.  Display table Student\n" +
                           "8.  Display table Teacher\n" +
                           "9.  Add new record to Student ArrayList\n" +
                           "10. Add new record to Teacher ArrayList\n" +
                           "11  Show new records added to Student local list\n"+
                           "12  Show New records added to Teacher local list\n"+
                           "13. Quit the program");
            System.out.println("\n");
            temp=sc.nextInt();
            System.out.println("\n");
            if(temp==1){  
                  System.out.println(ArrayStudent1);}
            else if(temp==2){
                  System.out.println(ArrayStudent2);}
            else if(temp==3){
            System.out.println(ArrayTeacher1);
            }
            else if(temp==4){
                 System.out.println(ArrayTeacher2);
             }
            else if(temp==5){
       
                // SQL.InsertStudent(SSlocal);
                // SQL.InsertTeacher(TSlocal);
                // SSlocal.clear();
                // TSlocal.clear();
                 SQL.DuplicatedInsertStudent(SSlocal);
                 SQL.DuplicatedInsertTeacher(TSlocal);
            }
            else if(temp==6){
                 File.WriteStudent(SFlocal);
                 File.WriteTeacher(TFlocal);
                 SFlocal.clear();
                 TFlocal.clear();
            }
            else if(temp==7){
            
                System.out.println(SQL.SelectStudent());
            }
            else if(temp==8){
                  System.out.println(SQL.SelectTeacher());
            }
            else if(temp==9){
                 boolean tempKey=true;
                 while (tempKey==true){
                     System.out.print("Enter the ID: ");
                     Student Stemp=new Student();
                     Stemp.SetId(sc.nextInt());
                     System.out.println();
                     if(Duplicated.InStudent(SQL.SelectStudent(), SFile,SSlocal, Stemp.GetId()))
                     {
                        System.out.print("Enter the Name: ");
                        Stemp.SetName(sc.next());
                        boolean tempKey1=true;
                        System.out.println();
                        while(tempKey1){
                            System.out.print("Enter the Department(only 1 or 2) : ");
                            int p=sc.nextInt();
                            if(p==1 | p==2){
                                  Stemp.SetDepart(p);
                                  tempKey1=false;
                            }
                        }
                        System.out.println();
                        System.out.print("Enter the Mark1: ");
                        Stemp.SetMark1(sc.nextDouble()); 
                        System.out.println();
                        System.out.print("Enter the Mark2: ");
                        Stemp.SetMark2(sc.nextDouble());
                        System.out.println();
                        SSlocal.add(Stemp);
                        SFlocal.add(Stemp);
                 
                        if(Stemp.GetDepart()==1){
                               ArrayStudent1.add(Stemp);
                        }
                        else if(Stemp.GetDepart()==2){
                               ArrayStudent2.add(Stemp);
                        }
                        tempKey=false;
                        }   
                 }
       
             }
             else if(temp==10){
                boolean tempKey=true;
                while(tempKey==true) {   
                    System.out.print("Enter the ID: ");
                    Teacher Ttemp=new Teacher(); 
                    Ttemp.SetId(sc.nextInt());
                    System.out.println();
                    if(Duplicated.InTeacher(SQL.SelectTeacher(), TFile,TSlocal, Ttemp.GetId()))
                    {
                         System.out.print("Enter the Name: ");
                         Ttemp.SetName(sc.next());
                         System.out.println();
                         boolean tempKey1=true;
                         while(tempKey1){
                            System.out.print("Enter the Department(only 1 or 2) : ");
                            int p=sc.nextInt();
                            if(p==1 | p==2){
                                  Ttemp.SetDepart(p);
                                  tempKey1=false;
                            }
                        }
                         System.out.println();
                         System.out.print("Enter the salary: ");
                         Ttemp.SetSalary(sc.nextDouble()); 
                         System.out.println();
                         System.out.print("Enter the grade: ");
                         Ttemp.SetDegree(sc.next());
                         System.out.println();
                         TSlocal.add(Ttemp);
                         TFlocal.add(Ttemp);
                         if(Ttemp.GetDepart()==1){
                             ArrayTeacher1.add(Ttemp);
                         }
                         else if(Ttemp.GetDepart()==2){
                             ArrayTeacher2.add(Ttemp);
                         }
                         tempKey=false;
                     }
                 }
             }
             else if(temp==11){
                 System.out.println(SSlocal);
             }
             else if(temp==12){
                 System.out.println(TSlocal);
             }
             else if(temp==13){
                 key=false;
             
             }
        }
        SQL.CloseConnection();
    }
}
        
    