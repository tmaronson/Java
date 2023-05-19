
/*
 * Create the Student class.
 */

class Student {
    
    private String name;
    
    public static int enrollmentNumber = 0;
    
    public Student(String name) {
        this.name = name;
        enrollmentNumber++;
    }
    
    public String toString() {
        
        return enrollmentNumber + ": " + name;
    }
}