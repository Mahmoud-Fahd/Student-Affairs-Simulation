package semesterproject;
import java.util.Scanner;
import java.util.Random;

public class SemesterProject {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Several Lines:
        Queue[] lines = new Queue[3];
        for(int i = 0 ; i < lines.length ; i++){
            lines[i] = new Queue();
        }
        
        Random rand = new Random();
        int studentCount = 1; 
        
        // Simulation Engine
        boolean running = true;
        
        // continous loop to display minu
        while(running){
            System.out.println("\n=== Student Affairs Simulation ===");
            System.out.println("1. Add a new student");
            System.out.println("2. Pass one minute (Process students)");
            System.out.println("3. Display all lines");
            System.out.println("4. Searching for a student");
            System.out.println("5. Delete Student by Id");
            System.out.println("6. Exit and show statistics");
            System.out.print("Choose an option: ");
        
            int choice = input.nextInt();
        
            switch(choice){
                case 1:
                    // 
                    int randomId = 1000 + rand.nextInt(9000); // Id => (1000 : 9999)
                    int randomGrade = 0 + rand.nextInt(101); // numGrade => (0 : 100)
                    int randomTime = 1 + rand.nextInt(5);  // Processing time => (1 : 5)
                    String name = "Student_" + studentCount++;
                    
                    // creating new student
                    Student newStudent = new Student(name, randomId, randomGrade, randomTime);
                    
                    // Decision Making 
                    int shortestIndx = 0; // assume queue1 is the shortest
                    
                    for(int i = 1 ; i < lines.length ; i++){
                        
                        lines[0].incrementComparisons(); 
                        
                        if(lines[i].getStudentCount() < lines[shortestIndx].getStudentCount()){
                            shortestIndx = i;
                        }
                    }
                    
                    // insert student in queue
                    lines[shortestIndx].insert(newStudent);
                    
                    System.out.println("");
                    System.out.println(name + " added to line " + (shortestIndx + 1) +
                                       " with Processing Time: " + randomTime);
                    
                    break;
                case 2:
                    //
                    System.out.println("\n>>> Passing one minute of processing...");
                    
                    boolean anyoneProcessed = false;
                    
                    for(int i = 0 ; i < lines.length ; i++){
                        Link firstLink = lines[i].peekFirst();
                        
                        if(firstLink != null){
                            Student s = firstLink.student;
                            s.decreaseTime(); // decrease one minute
                            anyoneProcessed = true;
                            
                            System.out.println("Line " + (i+1) + ": Working on [" + s.getName() +
                                                "], Time left: " + s.getProcessingTime() + " min");
                            
                            if(s.getProcessingTime() <= 0){
                                lines[i].remove(); // leave from Queue
                                System.out.println("!!! [Check-out] " + s.getName() + " has finished and left Line " + (i+1));
                            }
                        }
                    }
                    
                    if (!anyoneProcessed) {
                        System.out.println("All lines are currently empty. No students to process.");
                    }
                    
                    break;
                case 3:
                    System.out.println("\n========================================");
                    System.out.println("   CURRENT STATE OF STUDENT LINES");
                    System.out.println("========================================");
                    
                    for(int i = 0 ; i < lines.length ; i++){
                        System.out.println("LINE #" + (i + 1) + " (Count: " + lines[i].getStudentCount() + "): ");
                        
                        lines[i].displayQueue();
                        
                        System.out.println("----------------------------------------");
                    }
                    break;
                case 4:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = input.nextInt();
                    boolean foundInAnyLine = false;
                    
                    for(int i = 0 ; i < lines.length ; i++){
                        if(lines[i].find(searchId) != null){
                            System.out.println(">>> Student with ID " + searchId + " is currently in Line " + (i + 1));
                            foundInAnyLine = true;
                            break;
                        }
                    }
                    
                    if(!foundInAnyLine){
                        System.out.println("Student with ID " + searchId + " was not found in any line.");
                    }
                    
                    break;
                case 5:
                    System.out.print("Enter Student ID to cancel: ");
                    int cancelId = input.nextInt();
                    boolean foundAndDeleted = false;
                    
                    for(int i = 0 ; i < lines.length ; i++){
                        if(lines[i].deleteStudent(cancelId) != null){
                            System.out.println(">>> Student with ID " + cancelId + " has been removed from Line " + (i + 1));
                            foundAndDeleted = true;
                            break;
                        }
                    }
                    
                    if(!foundAndDeleted){
                        System.out.println("Student not found in any line.");
                    }
                    
                    break;
                case 6:
                    System.out.println("\n========================================");
                    System.out.println("   FINAL SIMULATION STATISTICS");
                    System.out.println("========================================");
                    
                    int totalComparisons = 0;
                    int totalSwaps = 0;
                    
                    for(int i = 0 ; i < lines.length ; i++){
                        int queueComp = lines[i].getComparisons();
                        int queueSwaps = lines[i].getSwaps();
                        
                        System.out.println("Line " + (i + 1) + " -> Comparisons: " + queueComp + " | Swaps: " + queueSwaps);
                        
                        totalComparisons += queueComp;
                        totalSwaps += queueSwaps;
                    }
                    
                    System.out.println("----------------------------------------");
                    System.out.println("GRAND TOTAL COMPARISONS: " + totalComparisons);
                    System.out.println("GRAND TOTAL SWAPS: " + totalSwaps);
                    System.out.println("========================================");
                    
                    
                    running = false; // for out from Queue
                    
                    System.out.println("Thank you for using Student Affairs Simulator. Bye!");
                    break;
                
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
    
}
