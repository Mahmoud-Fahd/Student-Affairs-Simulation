package semesterproject;

public class LinkList {
    // Attributes: 
    private Link first;
    private Link last;
    private int size;
    
    // Counters:
    public int comparisons;
    public int swaps = 0;
    
    // Constractor:
    public LinkList(){
        this.first = null;
        this.last = null;
        
        this.comparisons = 0;
        this.swaps = 0;
    }
    
    // check List is empty or not
    public boolean isEmpty(){
        return (first == null);
    }
    
    // insert student in the end of list
    public void insertLast(Student s){
        Link newLink = new Link(s);
        
        if(isEmpty()){  
            first = newLink;
        }
        else{
            last.next = newLink;
        }
        last = newLink;
        
        swaps++;
        size++;
    }
    
    // delete student from list
    public Student deleteFirst(){
        if(isEmpty()){
            return null;
        }
        
        Student temp = first.student;
        
        if(first.next == null){ // list has one link
            last = null;
        }
        
        first = first.next;
        
        swaps++;
        size--;
        
        return temp;
    }
    
    // find student using key
    public Link find(int key){
        Link current = first;
        
        while(current != null){
            comparisons++;
            
            if(current.student.getKey() == key){
                return current; // found
            }
            current = current.next;
        }
        
        return null; // Student not found 
    }
    
    // Delete student by Id 
    public Link deleteStudent(int key){
        Link current = first;
        Link previous = first;
        
        while(current != null && current.student.getKey() != key){
            comparisons++;
            previous = current;
            current = current.next;
        }
        
        if(current == null){ // student not found
            return null;
        }
        
        if(current == first){
            first = first.next;
            if(first == null){ 
                last = null;   
            }
        }
        else{
            previous.next = current.next;
            if(current == last){ 
                last = previous; 
            }
        }
        
        swaps++;
        size--;
        return current;
    }
    
    // Calculate number of student in list
    public int getSize(){
        return size;
    }
    
    // display Student
    public void display(){
        Link current = first;
        
        while(current != null){
            current.displayLink();
            current = current.next;
        }
    }
    
    // get first link
    public Link getFirstLink(){
        return first;
    }
}
