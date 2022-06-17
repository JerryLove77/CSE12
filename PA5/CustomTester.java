/**
 * Name: Jianrui Zhang
 * ID: A16878087
 * Email: Jiz145@ucsd.edu
 * Sources used: None
 * 
 * CustomTester is a test file to test methods in 
 * Student class,Course class, Sanctuary class.
 * These test case are not included in public tester
 */

import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

/** 
 * test methods in Student class,Course class, Sanctuary class.
 * These test case are not included in public tester
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {
    private final int INVALID = -1;
    private final int TENANIMALS = 10;
    private final int TWOSPECIES = 2;
    private final int NUM = 20;
    private final String CAT = "cat";
    private final String DOG = "dog";
    private final String FIRSTNAME1 = "Jianrui";
    private final String FIRSTNAME2 = "Jerry";
    private final String LASTNAME = "Zhang";
    private final String PID = "A16878087";
    private final String DEPARTMENT  = "CSE";
    private final String NUMBER = "11";
    private final String DESCRIPTION = "Introduction";
    private final int CAPACITY = 1;
    private final int TEN = 10;
    private final int SIX = 6;
    private final int FOUR = 4;
    private final int CAPACITY2 = 2;

    // ----------------Student class----------------
    /**
     * Test the equals method when two students are not same
     */
    @Test
    public void testEquals() {
        Student a = new Student(FIRSTNAME1,LASTNAME,PID);
        Student b = new Student(FIRSTNAME2,LASTNAME,PID);
        assertTrue(!a.equals(b));

    }

    /**
     * Test the compareTo method when two students are same
     */
    @Test
    public void testCompareTo() {
        Student a = new Student(FIRSTNAME1,LASTNAME,PID);
        Student b = new Student(FIRSTNAME1,LASTNAME,PID);
        assertEquals(0,a.compareTo(b));

    }

    // ----------------Course class----------------
    /**
     * Test the enroll method when capacity is full
     */
    @Test
    public void testEnroll() {
        Course coursea = new Course(DEPARTMENT,NUMBER,DESCRIPTION,CAPACITY);
        Student a = new Student(FIRSTNAME1,LASTNAME,PID);
        Student b = new Student(FIRSTNAME2,LASTNAME,PID);
        
        coursea.enroll(a);
        assertEquals(1,coursea.enrolled.size());
        assertTrue(!coursea.enroll(b));
        assertTrue(!coursea.enrolled.contains(b));
    }

    /**
     * Test the unenroll method when student is null
     */
    @Test(expected = IllegalArgumentException.class)
    public void testUnenroll() {
        Student nullstu = null;
        Course coursea = new Course(DEPARTMENT,NUMBER,DESCRIPTION,CAPACITY);
        coursea.unenroll(nullstu);


    }

    /**
     * Test the getRoster method when 
     */
    @Test
    public void testGetRoster() {
        Student a = new Student(FIRSTNAME2,LASTNAME,PID);
        Student b = new Student(FIRSTNAME1,LASTNAME,PID);
        Course coursea = new Course(DEPARTMENT,NUMBER,DESCRIPTION,CAPACITY2);
        coursea.enroll(a);
        coursea.enroll(b);
        List<Student> set = new ArrayList<>();
        set.add(a);
        set.add(b);
        assertEquals(set,coursea.getRoster());
    }
    

    // ----------------Sanctuary class----------------
    /**
     * Test the constructor when maxanimals and maxspecies are invalid
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSanctuaryConstructor() {
        Sanctuary a = new Sanctuary(INVALID, INVALID);

    }

    /**
     * Test the rescue method when there is not enough space
     */
    @Test
    public void testRescueTestOne(){
        Sanctuary a = new Sanctuary(TENANIMALS, TWOSPECIES);
        assertEquals(TEN,a.rescue(CAT, NUM));
    }

    /**
     * Test the rescue method when there is No space
     */
    @Test
    public void testRescueTestTwo(){
        Sanctuary a = new Sanctuary(TENANIMALS, TWOSPECIES);
        a.rescue(CAT,TEN);
        assertEquals(NUM,a.rescue(DOG,NUM));
    }

    /**
     * Test the release method when call release twice
     */
    @Test
    public void testReleaseTestOne(){
        Sanctuary a = new Sanctuary(TENANIMALS, TWOSPECIES);
        a.sanctuary.put(CAT,SIX);
        a.sanctuary.put(DOG,FOUR);
        a.release(CAT, SIX);
        assertEquals(0,a.getNum(CAT));
        assertEquals(FOUR, a.getNum(DOG));
        a.release(DOG,FOUR);
        assertEquals(0,a.getNum(CAT));
        assertEquals(0, a.getNum(DOG));
    }

    /**
     * Test the release method 
     * when num is greater than total amout of that species
     */
    @Test(expected = IllegalArgumentException.class)
    public void testReleaseTestTwo(){
        Sanctuary a = new Sanctuary(TENANIMALS, TWOSPECIES);
        a.sanctuary.put(CAT,SIX);
        a.release(DOG,SIX);
    
    }
}

