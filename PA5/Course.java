/**
 * Name: Jianrui Zhang
 * ID: A16878087
 * Email: Jiz145@ucsd.edu
 * Sources used: None
 * 
 * 2-4 sentence file description here
 * There is a Course class in this file.
 * This class is about info of enrollment about one course
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import org.junit.runner.Describable;

/**
 * several instance variable about course.
 * Its own methods to access and manipulate variables 
 * And a display - toString- method to show info of this course
 */
public class Course {
    HashSet<Student> enrolled;
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;
    private final String formatting = "%s %s [%d]\n%s";

    /**
     * constructor to initailize variables
     * @param department (the department of the course)
     * @param number (the course number)
     * @param description (the descriptin of this course)
     * @param capacity (the capacity of this course)
     */
    public Course(String department, String number, String description, 
        int capacity){
            if(capacity <= 0){
                throw new IllegalArgumentException();
            }
            if(department == null|| number == null
            || description == null){
                throw new IllegalArgumentException();
            }
            this.enrolled = new HashSet<>();
            this.capacity = capacity;
            this.department = department;
            this.number = number;
            this.description = description;
           
        }

    /** @return department*/
    public String getDepartment(){
        return this.department;
    }

    /** @return number */
    public String getNumber(){
        return this.number;
    }

    /** @return description */
    public String getDescription(){
        return this.description;
    }

    /** @return capacity */
    public int getCapacity(){
        return this.capacity;
    }

    /**
     * enroll a student to the course
     * @param student (the student will be enrolled)
     * @return whether student are enrolled or not
     */
    public boolean enroll(Student student) {
        if(student == null) {
            throw new IllegalArgumentException();
        }

        if(capacity > this.enrolled.size()) {
            return enrolled.add(student);
        }
        else{
            return false;
        }
    }

    /**
     * unenroll a student to the course
     * @param student (the student will be unenrolled)
     * @return whether student are unenrolled or not
     */
    public boolean unenroll(Student student) {
        if(student == null){
            throw new IllegalArgumentException(); 
        }
        if(enrolled.contains(student)){
            enrolled.remove(student);
            return true;
        }
        else{
            return false;
        }
    }

    /** cancel the course */
    public void cancel() {
        enrolled.clear();
    }

    /** @return whether there are any available seat in the course */
    public boolean isFull() {
        if(capacity == getEnrolledCount()) {
            return true;
        }
        return false;
    }

    /** @return how mant student are enrolled in this course */
    public int getEnrolledCount() {
        return this.enrolled.size();
    }

    /** @return how many available seats*/
    public int getAvailableSeats() {
        return capacity - enrolled.size();
    }

    /**@return shallow copy of student hash set */
    public HashSet<Student> getStudents() {
        return (HashSet<Student>) enrolled.clone();
    }

    /**
     * All the students in the course should be listed in the increasing order 
     * specified by the compareTo method in Student
     * @return (student list)
     */
    public ArrayList<Student> getRoster() {
        ArrayList<Student> enrolledarrlist = new ArrayList<>();
        //creates an iterator 
        Iterator<Student> enrollit = enrolled.iterator();
        for(int i = 0; i < enrolled.size(); i++) {
            //adds the student to the ArrayList by the iterator
            enrolledarrlist.add(enrollit.next());
        }
        //sorts the ArrayList
        Collections.sort(enrolledarrlist);
        return enrolledarrlist;
    }

    /**@return  a string representation of info about this course */
    public String toString() {
        String temp = String.format(formatting, getDepartment(), 
        getNumber(), getCapacity(), getDescription());
        return temp;
    }
}

