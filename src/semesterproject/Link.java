package semesterproject;

public class Link {
    // Attributes:
    public Student student; // Object 
    public Link next; 
    
    // Constractor:
    public Link(Student s){
        this.student = s ;
        this.next = null;
    }
    
    // Diplay Link
    public void displayLink(){
//        System.out.print("Name: " + student.getName() + "\n"
//        + "Id: " + student.getId() + "\n" + "Grade: " + student.getGrade() + "\n");
        System.out.println("[ ID: " + student.getId() + " | Name: " + student.getName()
                           + " | Grade: " + student.getGrade() + "% ]");
    }
}
