package semesterproject;

public class Student {
    // Attributes:
    private String name;
    private int id;
    private int numGrade;
    private int processingTime;
    
    // Constractor:
    public Student(String name, int id, int numGrade, int processingTime){
        this.name = name;
        this.id = id;
        this.numGrade = numGrade;
        this.processingTime = processingTime;
    }
    
    // Getters:
    public String getName(){
        return name;
    }
    
    public int getId(){
        return id;
    }
    
    public int getGrade(){
        return numGrade;
    }
    
    public int getKey(){
        return id;
    }
    
    public int getProcessingTime(){
        return processingTime;
    }
    
    // decrease processing time 
    public void decreaseTime(){
        if(processingTime > 0){
            processingTime--;
        }
    }
}
