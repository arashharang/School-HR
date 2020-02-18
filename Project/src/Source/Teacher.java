
package Source;


public class Teacher {
     private int id;
     private  String name;
     private int depart;
     private  double salary;
     private  String degree;
     Teacher(){}
     Teacher(int a, String b, int c, double d, String e){
          id=a;
          name=b;
          depart=c;
          salary=d;
          degree=e;
     }
     public void SetId(int a){
         this.id=a;
    }
    public int GetId(){
         return this.id;
    
    }
    public void SetName (String a){
        this.name=a;
    }
    public String GetName (){
        return this.name;
    }
    public void SetDepart(int d){
        this.depart=d;
    
    }
    public int GetDepart(){
        return this.depart;
    }
    public void SetSalary(double b){
        this.salary=b;
    }
    public double GetSalary(){
        return this.salary;
    }
    public void SetDegree(String e){
        this.degree=e;
    }
    public String GetDegree(){
        return this.degree;
    }
    @Override
    public String toString(){
        return "\n"+ "ID: " + id + " Name: " +name+ " Department: " +depart+" Salary: "+salary+"Degree : " +degree +"\n";
    }
}



