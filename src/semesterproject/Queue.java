package semesterproject;

public class Queue {
    // Attributes:
    private LinkList list; // Object 
    
    // Constractor:
    public Queue(){
        this.list = new LinkList();
    }
    
    // Enqueue: Add Student
    public void insert(Student s){
        list.insertLast(s);
    }
    
    // Dequeue: Remove Student
    public Student remove(){
        return list.deleteFirst();
    }
    
    // Delete Student from Queue
    public Link deleteStudent(int key){
        return list.deleteStudent(key);
    }
    
    // Number of Students in Queue
    public int getStudentCount(){
        return list.getSize();
    }
    
    // Display Students in Queue
    public void displayQueue(){
        list.display();
    }
    
    // Statistics:
    public int getComparisons(){
        return list.comparisons;
    }
    
    public int getSwaps(){
        return list.swaps;
    }
    
    // increment comparisons
    public void incrementComparisons(){
        list.comparisons++;
    }
    
    // get first link
    public Link peekFirst(){
        return list.getFirstLink();
    }
    
    // searching for a student
    public Link find(int key){
        return list.find(key);
    }
}
