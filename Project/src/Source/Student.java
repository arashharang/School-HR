package Source;


public class Student {
    private int id;
    private String name;
    private int depart;
    private double mark1;
    private double mark2;
    Student(){};
    Student(int a, String b, int c, double d, double e){
    id=a;
    name=b;
    depart=c;
    mark1=d;
    mark2=e;
    }
    public void SetId(int a){
        this.id=a;
    }


    public int GetId(){
        return this.id;
    }    
    public void SetName(String n){
        this.name=n;
    
    }
    public String GetName(){
        return this.name;
    }
    public void SetDepart(int b){
        this.depart=b;
    
    }
        
    public int GetDepart(){
        return this.depart;
    }   
    public void SetMark1(double c){
        this.mark1=c;  
    }    
    public double GetMark1(){
        return this.mark2;
    }
    public void SetMark2(double d){
        this.mark2=d;
    }
    public double GetMark2(){
        return this.mark2;
    
    }
    @Override  
    public String toString(){
        return "\n" +"ID: " + id + " Name: " +name+" Department "+depart+ " Mark1:" +mark1+" Mark2: "+mark2 + "\n";
    }

}